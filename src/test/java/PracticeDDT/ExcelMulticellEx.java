package PracticeDDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ExcelMulticellEx {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
   FileInputStream fis=new FileInputStream("C:\\\\Users\\\\ASUS\\\\Desktop\\\\automationpractice\\\\Book1.xlsx");
  Workbook wb= WorkbookFactory.create(fis);
 Sheet sh= wb.getSheet("Sheet1");
 int lastrownum=sh.getLastRowNum();
 for(int i=0;i<lastrownum;i++) {
	 Row r=sh.getRow(i);
 
 int lastcellnum=r.getLastCellNum();
 for(int j=0;j<lastcellnum;j++) {
	 String value=r.getCell(j).toString();
	 System.out.println(value);
		 
	 }
 
 }

	}

}
