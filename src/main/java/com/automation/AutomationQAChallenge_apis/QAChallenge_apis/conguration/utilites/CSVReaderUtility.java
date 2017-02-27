package com.automation.AutomationQAChallenge_apis.QAChallenge_apis.conguration.utilites;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


/**
 * This class is used to get the data from the csv file.
 * 
 */
public class CSVReaderUtility {
	
	private static String CSV_COMMENT_START_CHAR = "#";
	
	@SuppressWarnings("resource")
	public static List<String[]> getCsvDataList(String testDataFile)
			throws FileNotFoundException, IOException {
		List<String[]> dataSubSet = new ArrayList<String[]>();
		System.out.println("test data file is :-" + testDataFile);
		InputStream is  = CSVReaderUtility.class.getClassLoader().getResourceAsStream(testDataFile);
				InputStreamReader isr = new InputStreamReader(is);
				List<String[]> data = new CSVReader(isr,
				CSVReader.DEFAULT_SEPARATOR, CSVReader.DEFAULT_QUOTE_CHARACTER,
				0).readAll();
				for (int i = 1; i < data.size(); i++) {
	        		if(!data.get(i)[0].equals("") && !data.get(i)[0].startsWith(CSV_COMMENT_START_CHAR)){
	        			dataSubSet.add(data.get(i));	
	        		}
	            }
		return dataSubSet;
	}
}
