package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javatpoint.model.Login;
import com.javatpoint.repository.LoginRepository;


@Service

@Transactional

public class LoginService {

	private final LoginRepository loginRepository;

	public LoginService(LoginRepository loginRepository)

	{

		this.loginRepository = loginRepository;

	}

	public Login SaveMyUser(Login role)

	{

		return loginRepository.save(role);

	}

	public List<Login> showAllUsers()

	{

		List<Login> registeredUserList = new ArrayList<>();

		for (Login role : loginRepository.findAll()) {

			registeredUserList.add(role);

		}

		return registeredUserList;

	}

	public void deleteMyUser(int id)

	{

		loginRepository.deleteById(id);

	}

	public Login editUser(int id)

	{

		Optional<Login> studentResponse = loginRepository.findById(id);

		Login student = studentResponse.get();

		return student;

	}

	public Login findByEmailidAndPassword(String emailid, String password) {

		return loginRepository.findByEmailidAndPassword(emailid, password);

	}

}