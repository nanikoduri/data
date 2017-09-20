package excel;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven2 {
	@Test (dataProvider = "abcd")
	public void  add(String num1, String num2, String num3){
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = Integer.parseInt(num3);
		int result = a+b+c;
		System.out.println("Result is " +result);
	}
		
	@DataProvider (name = "abcd")

	public Object [][] readExcel()  throws BiffException, IOException  {
		File f = new File("C:/Users/nanik/Desktop/input.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet s = wb.getSheet("Sheet2");
		int rows = s.getRows();
		int columns = s.getColumns();
		System.out.println("Number of Rows " +rows); System.out.println("Number of Columns " +columns);
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






