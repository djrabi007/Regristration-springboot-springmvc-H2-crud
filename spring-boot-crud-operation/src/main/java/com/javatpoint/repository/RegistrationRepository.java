package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

}