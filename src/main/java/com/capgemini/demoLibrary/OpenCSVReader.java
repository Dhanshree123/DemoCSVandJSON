package com.capgemini.demoLibrary;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVReader {
	private static final String OBJECT_LIST_SAMPLE = "./sample-csv-file.csv";

	public static void main(String[] args) throws IOException {

		try (Reader reader = Files.newBufferedReader(Paths.get(OBJECT_LIST_SAMPLE));) {

			CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

			while (csvUserIterator.hasNext()) {
				CSVUser csvUser = csvUserIterator.next();
				System.out.println("Name : " + csvUser.getName());
				System.out.println("Email : " + csvUser.getEmail());
				System.out.println("PhoneNumber : " + csvUser.getPhno());
				System.out.println("Country : " + csvUser.getCountry());
				System.out.println("**********************************");
			}

		}

	}

}
