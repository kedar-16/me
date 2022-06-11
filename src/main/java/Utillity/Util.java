package Utillity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.logging.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Util {
	

	public static String readExcell(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("D:\\kp\\Automation\\Project\\myproject\\XcellSheet\\Shares.xlsx");
		Sheet excell = WorkbookFactory.create(file).getSheet("Sheet1");
		return excell.getRow(row).getCell(row).toString();
	}
	public static String readreadExcell2(int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("D:\\kp\\Automation\\Project\\myproject\\XcellSheet\\Shares.xlsx");
		Sheet excell = WorkbookFactory.create(file).getSheet("Sheet2");
		return excell.getRow(row).getCell(row).getStringCellValue();
	}

}
