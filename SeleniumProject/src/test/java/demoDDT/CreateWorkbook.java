package demoDDT;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateWorkbook {
	@Test
	public void f() throws IOException {
//		Create Blank WorkBook
		XSSFWorkbook wb = new XSSFWorkbook();
		
//		Create file system using specific name
		FileOutputStream out = new FileOutputStream(new File("DemoWB.xlsx"));
		
//		Write operation workbook using file out object
		wb.write(out);
		out.close();
		System.out.println("Written Successfully");
	}
}
