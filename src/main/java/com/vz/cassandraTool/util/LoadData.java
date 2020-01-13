package com.vz.cassandraTool.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.util.LinkedMultiValueMap;

public class LoadData {

	public static final String SAMPLE_XLSX_FILE_PATH = "D:\\MeyProject\\cassandraTool\\src\\main\\resources\\Cassandra_Master_Sheet.xlsx";

	public static void main(String[] args) throws IOException, InvalidFormatException {

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

		// Retrieving the number of sheets in the Workbook
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

		// 2. Or you can use a for-each loop
		System.out.println("Retrieving Sheets using for-each loop");
		for (Sheet sheet : workbook) {
			// System.out.println("=> " + sheet.getSheetName());
		}

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		// 2. Or you can use a for-each loop to iterate over the rows and columns
		System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
		Set<String> visionTable = new LinkedHashSet<>();
		Set<String> cassandraTable = new LinkedHashSet<>();
		LinkedMultiValueMap mMap1 = new LinkedMultiValueMap();
		LinkedMultiValueMap mMap2 = new LinkedMultiValueMap();
		Map<Integer, String> visionMap = new LinkedHashMap<>();
		Map<Integer, String> cassandraMap = new LinkedHashMap<>();
		int count = 0;
		for (Row row : sheet) {
			Cell visionCell = row.getCell(0);
			String visionCellValue = dataFormatter.formatCellValue(visionCell);
			Cell cassandraCell = row.getCell(0);
			String cassandraCellValue = dataFormatter.formatCellValue(cassandraCell);
			// System.out.print(cellValue + "\t");
			if (count > 0) {
				visionMap.put(count, visionCellValue);
				cassandraMap.put(count, cassandraCellValue);
				mMap1.add(visionCellValue, cassandraCellValue);
				mMap2.add(cassandraCellValue, visionCellValue);
				visionTable.add(visionCellValue);
				cassandraTable.add(cassandraCellValue);

			}
			count++;
			// System.out.println();
		}

		Set<String> keys = mMap1.keySet();

		Map<Integer, String> visionIndex = new LinkedHashMap<>();
		for (String key : keys) {
			System.out.println("Key = " + key + "    index:" + visionMap.entrySet().stream()
					.filter(e -> key.equals(e.getValue())).map(Map.Entry::getKey).findFirst().get());

			visionIndex.put(visionMap.entrySet().stream().filter(e -> key.equals(e.getValue())).map(Map.Entry::getKey)
					.findFirst().get(), key);
			System.out.println("Values = " + mMap1.get(key));
			List<String> list = (List<String>) mMap1.get(key);

		}
		Set<String> mapKeys = mMap1.keySet();
		List<String> arrList  = new ArrayList<>();
		//String[] arr = (String[]) mapKeys.toArray();
		for(String a : mapKeys) {
			arrList.add(a);
		}

		List<String> cassIndexName = new ArrayList<>();
		List<Integer> cassIndexValue = new ArrayList<>();
		for (String cassT : cassandraTable) {

			for (String key : mapKeys) {
				System.out.println("Key = " + key);
				System.out.println("Values = " + mMap1.get(key));
				List<String> list = (List<String>) mMap1.get(key);

				if(list.contains(cassT)) {
					cassIndexName.add(cassT);
					cassIndexValue.add(arrList.indexOf(cassT));
				}
				for (String list1 : list) {
					//System.out.println(list1);
				}
			}
		}

		for (String set : visionTable) {
			System.out.println(set);
		}

		// Closing the workbook
		workbook.close();
	}
}
