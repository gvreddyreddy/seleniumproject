package util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
		File file = new File(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet s = wb.getSheet("login");
		
		int rowCount = s.getLastRowNum();
		int colCount = s.getRow(0).getLastCellNum();
		
		Map<String, List<Map<String,String>>> sheetMap = new HashMap<>();
		
		List<Map<String,String>> rowsMap = new ArrayList<>();
		
		for(int i=0; i<=rowCount;i++) {
			Map<String, String> row = new HashMap<>();
			for(int j=0;j<colCount;j++) {
				System.out.print(s.getRow(i).getCell(j).getStringCellValue() + " ");
				row.put(s.getRow(0).getCell(j).getStringCellValue(), s.getRow(i).getCell(j).getStringCellValue());
			}
			rowsMap.add(row);
			System.out.println();
		}
		rowsMap.remove(0);
		System.out.println(rowsMap);
	}
}
