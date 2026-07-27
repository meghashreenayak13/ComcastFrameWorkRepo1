package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSingleCell {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream("C:\\Users\\ASUS\\Desktop\\automationpractice\\Book1.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet("Sheet1");
	Row r=sh.getRow(0);
    String data=	r.getCell(0).toString();
	 
//Cell c=r.getCell(0);
    //String data1=c.getStringCellValue();
   // double data2= c.getNumericCellValue();
    
    System.out.println(data);
    
    
	}

}
