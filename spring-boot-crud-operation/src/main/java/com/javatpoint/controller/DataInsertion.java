package com.javatpoint.controller;



/**
 * I am getting out of memory in java code while inserting 4 lakh records using
 * jdbctemplate , can someone provide me solution what is correct way to handle
 * this i am keeping all 4 lakh records in arraylist.
 * 
 * AnS::: When dealing with a large number of records, keeping all of them in an
 * ArrayList can lead to memory issues, especially if the data exceeds the
 * available memory. To handle this situation more efficiently, you can consider
 * using batch processing and streaming the data instead of storing everything
 * in memory at once. Here's an approach using JdbcTemplate and batch
 * processing:
 * 
 * @author rabi0
 *
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataInsertion {
	private JdbcTemplate jdbcTemplate;

	public DataInsertion(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertData(List<Data> dataList) {
		String sql = "INSERT INTO your_table_name (column1, column2, ...) VALUES (?, ?, ...)";

		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Data data = dataList.get(i);
				ps.setString(1, data.getColumn1());
				ps.setString(2, data.getColumn2());
				// Set other parameters based on your table schema
			}

			@Override
			public int getBatchSize() {
				return dataList.size();
			}
		});
	}

	public class Data {
		private String column1;
		private String column2;

		// Constructors, setters, and getters for column1 and column2

		public String getColumn1() {
			return column1;
		}

		public void setColumn1(String column1) {
			this.column1 = column1;
		}

		public String getColumn2() {
			return column2;
		}

		public void setColumn2(String column2) {
			this.column2 = column2;
		}
	}

}
