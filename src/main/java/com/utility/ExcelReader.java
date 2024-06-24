package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.baseclass.BaseClass;

public class ExcelReader extends BaseClass {
	// ExcelSheet
	// perticular Sheet
	// Perticular Cell Data
	// Perticular Row Data
	// All Sheet data

	public static FileInputStream readExcelSheet(String sheetName) throws FileNotFoundException {

		FileInputStream file = new FileInputStream(
				"projectpath+/NewTestProject/src/test/resources/com/" + "excelSheetName");
		return file;

	}

	public static Sheet getSheet(FileInputStream file, String sheetName)
			throws EncryptedDocumentException, IOException {

		Sheet sh = WorkbookFactory.create(file).getSheet("sheetName");
		return sh;

	}

	public static Object getSingleCellData(Sheet sh, int rowNum, int cellNum) {

		if (sh.getRow(rowNum).getCell(cellNum).getCellType().toString().equalsIgnoreCase("string"))

			return sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		else
			return sh.getRow(rowNum).getCell(cellNum).getNumericCellValue();

	}

	public static Map getRowData(Sheet sh, int rowNum) {
		Map<String, Object> rowData = new HashMap<>();
		int cellNum = sh.getRow(rowNum).getLastCellNum();

		for (int i = 0; i < cellNum; i++) {
			if (sh.getRow(rowNum).getCell(i).getCellStyle().toString().equalsIgnoreCase("String"))

				rowData.put(sh.getRow(0).getCell(cellNum).getStringCellValue(),
						sh.getRow(rowNum).getCell(cellNum).getStringCellValue());

			else
				rowData.put(sh.getRow(0).getCell(cellNum).getStringCellValue(),
						sh.getRow(rowNum).getCell(cellNum).getNumericCellValue());
		}
		return rowData;

	}

	public static void getAllExcelData(Sheet sh) {

		for (int row = 0; row < sh.getLastRowNum(); row++) {

			HashMap<String, Object> allData = new HashMap<>();

			int cellNum = sh.getRow(row).getLastCellNum();
			for (int cell = 0; cell < cellNum; cell++) {

				if (sh.getRow(row).getCell(cellNum).getCellType().toString().equalsIgnoreCase("String"))

					allData.put(sh.getRow(0).getCell(cellNum).getStringCellValue(),
							sh.getRow(row).getCell(cellNum).getStringCellValue());

				else
					allData.put(sh.getRow(0).getCell(cellNum).getStringCellValue(),
							sh.getRow(row).getCell(cellNum).getNumericCellValue());

			}

		}

	}

}
