package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT =10;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Nidhi\\Automation\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Contacts.xlsx";
	static Workbook wb;
	static Sheet sheet;
	
	
	
	public static Object[][] getTestData(String sheetName)
	{
		
		FileInputStream fs = null;
		
		try {
			
			fs=new FileInputStream(TESTDATA_SHEET_PATH);
		
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
		
		
			try {
				wb = WorkbookFactory.create(fs);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		sheet= wb.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0;i<sheet.getLastRowNum();i++)
			for (int k=0;k< sheet.getRow(0).getLastCellNum();k++)
				{data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				System.out.print("data[i][k] " + data[i][k]);
				}	
		return data;
	}

}
