package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static void main(String[] args) throws Exception {
		List<Map<String, String>> rowsList = new ArrayList<>();
		String path = System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx";
		Workbook workbook = WorkbookFactory.create(new File(path));
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();

		System.out.println(rows + " " + cols);
		for (int row = 0; row < rows; row++) {
			Map<String, String> rowMap = new HashMap<>();
			for (int col = 0; col < cols; col++) {
				rowMap.put(sheet.getRow(0).getCell(col).getStringCellValue(), sheet.getRow(row).getCell(col).getStringCellValue());
				System.out.print(sheet.getRow(row).getCell(col).getStringCellValue());
			}
			rowsList.add(rowMap);
			System.out.println();
		}

		workbook.close();
		rowsList.remove(0); // removing header
		System.out.println(rowsList);
	}
}
