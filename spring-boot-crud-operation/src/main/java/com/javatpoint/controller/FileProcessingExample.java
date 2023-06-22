package com.javatpoint.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileProcessingExample {
	public static void main(String[] args) {
		String inputFilePath = "C:\\Users\\rabi0\\git\\Regristration-springboot-springmvc-H2-crud\\spring-boot-crud-operation\\src\\main\\java\\com\\javatpoint\\controller\\input.txt";
		String outputFilePath = "C:\\Users\\rabi0\\git\\Regristration-springboot-springmvc-H2-crud\\spring-boot-crud-operation\\src\\main\\java\\com\\javatpoint\\controller\\output.txt";

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

			String line;
			while ((line = reader.readLine()) != null) {
				String modifiedLine = "'" + line + "'";
				writer.write(modifiedLine);
				// writer.newLine();
				writer.write(",");
			}

			reader.close();
			writer.close();

			// Remove the last comma from the file
			removeLastComma(outputFilePath);

			System.out.println("Output file generated successfully!");
		} catch (IOException e) {
			System.out.println("Error occurred: " + e.getMessage());
		}
	}

	private static void removeLastComma(String filePath) throws IOException {
		RandomAccessFile file = new RandomAccessFile(filePath, "rw");
		long length = file.length();
		byte b;
		do {
			length -= 1;
			file.seek(length);
			b = file.readByte();
		} while (b != ',' && length > 0);
		if (length > 0) {
			file.setLength(length);
		}
		file.close();
	}
}
