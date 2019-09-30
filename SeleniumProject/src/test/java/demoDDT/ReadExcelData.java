package demoDDT;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	@Test
	public void f() throws IOException {
		File file = new File("C:\\Users\\pdc3a-training.pdc3a\\Desktop\\Activity2.xlsx");
		FileInputStream input = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("Total rows: "+rowCount);
		
		for (int i=0; i<=rowCount; i++) {
			System.out.println("User "+(i+1));
			
			String data1 = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("First Name: " + data1);
			
			String data2 = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Last Name: " + data2);
		}
		
		wb.close();
	}
}
