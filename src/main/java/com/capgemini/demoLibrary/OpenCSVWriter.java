package com.capgemini.demoLibrary;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVWriter {
	private static final String OBJECT_LIST_SAMPLE = "./sample-csv-file.csv";

	public static void main(String[] args)
			throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {

		try (Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_LIST_SAMPLE));) {

			StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			List<CSVUser> myUsers = new ArrayList<>();
			myUsers.add(new CSVUser("Emma Stone", "emmaStone@gmail.com", "9876543210", "Germany"));
			myUsers.add(new CSVUser("John", "johne@gmail.com", "9876543333", "UK"));

			beanToCsv.write(myUsers);
			System.out.println(myUsers.size());
		}
	}
}