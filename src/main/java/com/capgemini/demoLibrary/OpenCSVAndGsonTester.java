package com.capgemini.demoLibrary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVAndGsonTester {

	private static final String SAMPLE_CSV_FILE = "./sample-csv-file.csv";
	private static final String SAMPLE_JSON_FILE = "./sample-json-file.json";

	public static void main(String[] args) {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<CSVUser> csvUsers = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(csvUsers);
			FileWriter writer = new FileWriter(SAMPLE_JSON_FILE);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE));
			CSVUser[] userObj = gson.fromJson(br, CSVUser[].class);
			List<CSVUser> csvUserList = Arrays.asList(userObj);
			for (CSVUser c : csvUserList) {
				System.out.println("Name : " + c.getName());
				System.out.println("Email : " + c.getEmail());
				System.out.println("PhoneNumber : " + c.getPhno());
				System.out.println("Country : " + c.getCountry());
				System.out.println("**********************************");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
