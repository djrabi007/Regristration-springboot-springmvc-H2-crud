package com.javatpoint.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 
 * can you write the following java program? I have the list of following input
 * String. List<String> ls= new ArrayList<>(); I want to generate file which
 * will give output as '111111','222222','333333','444444'.
 * 
 * @author rabi0
 *
 */
public class FileGenerationExample {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("111111");
		ls.add("hjjhj");
		ls.add("333333");
		ls.add("88888");

		// String outputFilePath = "output.txt";
		String outputFilePath = "C:\\Users\\rabi0\\git\\Regristration-springboot-springmvc-H2-crud\\spring-boot-crud-operation\\src\\main\\java\\com\\javatpoint\\controller\\output.txt";

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

			for (int i = 0; i < ls.size(); i++) {
				String line = "'" + ls.get(i) + "'";
				writer.write(line);

				if (i < ls.size() - 1) {
					writer.write(",");
				}
			}

			writer.close();
			System.out.println("Output file generated successfully!");
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}

