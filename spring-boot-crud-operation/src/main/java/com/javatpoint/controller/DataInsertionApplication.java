package com.javatpoint.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Can anyone suggest on I have a requirement that I have a list of one lakh
 * unique records to be stored into a table in which it contains 80 columns..
 * need to insert all one lakh records into table in less than a minute.. can
 * someone suggest the approach how can we deal this using spring data??
 * 
 * Here's an example Java program that demonstrates the insertion of one lakh
 * records into a database table using Spring Data JPA and batch processing:
 * 
 * @author rabi0
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Can anyone suggest on I have a requirement that I have a list of one lakh
 * unique records to be stored into a table in which it contains 80 columns..
 * need to insert all one lakh records into table in less than a minute.. can
 * someone suggest the approach how can we deal this using spring data??
 * 
 * Here's an example Java program that demonstrates the insertion of one lakh
 * records into a database table using Spring Data JPA and batch processing:
 * 
 * @author rabi0
 *
 */
@Entity
class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Define your 80 columns here

	// Getters and setters

	// Other constructors and methods as needed
}

@Repository
interface RecordRepository extends JpaRepository<DataInsertionApplication, Long> {
}

@SpringBootApplication
public class DataInsertionApplication {
	private static final int BATCH_SIZE = 1000;
	private static final int TOTAL_RECORDS = 100000;

	private final RecordRepository recordRepository;

	@Autowired
	public DataInsertionApplication(RecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DataInsertionApplication.class, args);
	}

	public void insertRecords() {
		List<DataInsertionApplication> records = generateRecords();

		List<DataInsertionApplication> batch = new ArrayList<>(BATCH_SIZE);
		for (DataInsertionApplication record : records) {
			batch.add(record);

			if (batch.size() == BATCH_SIZE) {
				recordRepository.saveAll(batch);
				batch.clear();
			}
		}

		if (!batch.isEmpty()) {
			recordRepository.saveAll(batch);
		}
	}

	private List<DataInsertionApplication> generateRecords() {
		List<DataInsertionApplication> records = new ArrayList<>(TOTAL_RECORDS);
		// Generate your records here
		for (int i = 0; i < TOTAL_RECORDS; i++) {
			DataInsertionApplication record = new DataInsertionApplication();
			// Set values for your 80 columns
			records.add(record);
		}
		return records;
	}
}
