package com.javatpoint.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Suppose we have map with two custom object Map<Employee,List<Address> > now
 * we need to sort this map based on employee age is greater than 53 and out put
 * should be in the for of Map<Employee,List<Address> >
 * 
 * @author rabi0
 *
 */

public class MapSorting {
	public static void main(String[] args) {
		// Create a sample map
		Map<Employee, List<Address>> employeeMap = new HashMap<>();
		Employee emp1 = new Employee("John", 50);
		Employee emp2 = new Employee("Alice", 55);
		Employee emp3 = new Employee("Bob", 60);

		employeeMap.put(emp1, Arrays.asList(new Address("123 Main St"), new Address("456 Elm St")));
		employeeMap.put(emp2, Arrays.asList(new Address("789 Oak St")));
		employeeMap.put(emp3, Arrays.asList(new Address("987 Pine St"), new Address("654 Maple St")));

		// Sort the map based on employee age > 53
		Map<Employee, List<Address>> sortedMap = sortMapByAge(employeeMap);

		// Print the sorted map
		for (Map.Entry<Employee, List<Address>> entry : sortedMap.entrySet()) {
			System.out.println("Employee: " + entry.getKey().getName() + ", Age: " + entry.getKey().getAge());
			System.out.println("Addresses: " + entry.getValue());
			System.out.println();
		}
	}

	public static Map<Employee, List<Address>> sortMapByAge(Map<Employee, List<Address>> employeeMap) {
		// Filter employees with age > 53
		Map<Employee, List<Address>> filteredMap = employeeMap.entrySet().stream()
				.filter(entry -> entry.getKey().getAge() > 53).collect(LinkedHashMap::new,
						(map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

		// Sort the filtered map based on employee age
		Map<Employee, List<Address>> sortedMap = new TreeMap<>(Comparator.comparingInt(Employee::getAge));
		sortedMap.putAll(filteredMap);

		return sortedMap;
	}
}

class Employee {
	private String name;
	private int age;

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class Address {
	private String street;

	public Address(String street) {
		this.street = street;
	}

	public String getStreet() {
		return street;
	}

	@Override
	public String toString() {
		return street;
	}
}
