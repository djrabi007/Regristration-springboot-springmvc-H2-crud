package com.javatpoint.controller;

import java.io.IOException;
import java.io.InputStream;

/**
 * My Java application(Rest service) is consuming another service. Once response
 * is received my service is converting it into desired format into pojo classes
 * and at the end pojo is converted into json using Object mapper as a response.
 * The resulting json string is huge in size(10k lines). I am facing OutOfMemory
 * error. When I analyzed the heap dump I see the resulting json strings are
 * getting hold and not getting garbage collected even though there is no
 * reference to it. Please suggest a solution.
 * 
 * 
 * 
 * Here's an example using Jackson's Streaming API to process a large JSON
 * response incrementally without loading the entire response into memory:
 * 
 * @author rabi0
 *
 */

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonStreamingExample {
	public void processLargeJsonResponse(InputStream inputStream) throws IOException {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(inputStream);

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			parser.nextToken();

			if ("data".equals(fieldName)) {
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					// Process individual JSON object within the "data" array
					processJsonObject(parser);
				}
			}
		}

		parser.close();
	}

	private void processJsonObject(JsonParser parser) throws IOException {
		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			parser.nextToken();

			// Process fields within the JSON object
			if ("id".equals(fieldName)) {
				String id = parser.getValueAsString();
				// Process the ID field
			} else if ("name".equals(fieldName)) {
				String name = parser.getValueAsString();
				// Process the name field
			} else if ("age".equals(fieldName)) {
				int age = parser.getValueAsInt();
				// Process the age field
			}

			// Add more field processing logic as needed
		}
	}

	// Example usage
	public static void main(String[] args) throws IOException {
		// Replace the placeholder with the code to obtain the InputStream from your
		// REST service response
		InputStream inputStream = getRestServiceResponseStream();

        JsonStreamingExample example = new JsonStreamingExample();
        example.processLargeJsonResponse(inputStream);
    }

	// Replace this method with the code to obtain the InputStream from your REST
	// service response
	private static InputStream getRestServiceResponseStream() {
		// Implement the logic to obtain the InputStream from your REST service response
		// Return the InputStream
		return null;
	}
}



