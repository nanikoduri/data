package excel;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven1 {
	public WebDriver driver;
	@Test (dataProvider="testdata")
	public void adminLogin(String Username, String Password){
		System.setProperty("webdriver.gecko.driver", "C://Selenium/geckodriver.exe" );	
	driver = new FirefoxDriver();
	driver.get("http://www.gcrit.com/build3/admin/");
	driver.findElement(By.name("username")).sendKeys(Username);
	driver.findElement(By.name("password")).sendKeys(Password);
	driver.findElement(By.id("tdb1")).click();
	Assert.assertEquals("http://www.gcrit.com/build3/admin/index.php", driver.getCurrentUrl());
			}
	@AfterMethod
	public void closebrowser(){
		driver.close();
	}
	
	
	@DataProvider (name="testdata")

	public Object [][] readExcel()  throws BiffException, IOException  {
		File f = new File("C:/Users/nanik/Desktop/input.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet1");
		int rows = s.getRows();
		int columns = s.getColumns();
		//System.out.println("Number of Rows " +rows); System.out.println("Number of Columns " +columns);
		String inputdata [][] = new String [rows][columns] ;
		for(int i=0; i<rows; i++){
			for (int j=0; j<columns; j++){
				Cell c = s.getCell(j,i);
				inputdata [i][j] = c.getContents();
				System.out.println(inputdata [i][j]);
				
				
			}
			}
		return inputdata;
			
		}
		
	}





