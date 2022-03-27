package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Login;


public interface LoginRepository extends CrudRepository<Login, Integer> {

	public Login findByEmailidAndPassword(String emailid, String password);

}