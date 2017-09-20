package excel;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven {

	public static void main(String[] args) throws BiffException, IOException  {
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
			
		}
		
	}


