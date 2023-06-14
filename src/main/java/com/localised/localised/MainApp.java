package main.java.com.localised.localised;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

	/**
	 * Parse CSV file
	 * @param fileName
	 * @return
	 */
	public static List<Entry> parseCVS(String fileName) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<Entry> result = new ArrayList<Entry>();

		try {
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] items = line.split(cvsSplitBy);
				Entry itemEntry = new Entry(items[0],
						items[1], items[2]);
				result.add(itemEntry);
			}
		} 	
		catch (FileNotFoundException fe) {
			fe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}


	/**
	 * Main Entry
	 * @param args
	 */
	public static void main(String[] args){
		List<Entry> results = MainApp.parseCVS("test.csv");

		for(Entry entry: results){
			System.out.println(entry.toString());
		}
	}
	
	
}
