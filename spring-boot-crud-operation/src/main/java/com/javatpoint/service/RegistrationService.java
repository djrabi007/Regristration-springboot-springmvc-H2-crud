package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javatpoint.model.Registration;
import com.javatpoint.repository.LoginRepository;
import com.javatpoint.repository.RegistrationRepository;


@Service

@Transactional

public class RegistrationService {

	private final RegistrationRepository registrationRepository;

	private final LoginRepository loginRepository; // Added by Rabi

	public RegistrationService(RegistrationRepository registrationRepository, LoginRepository loginRepository)

	{

		this.registrationRepository = registrationRepository;

		this.loginRepository = loginRepository; // Added by Rabi

	}

	public Registration SaveMyUser(Registration registration)

	{

		return registrationRepository.save(registration);

	}

	public List<Registration> showAllUsers()

	{

		List<Registration> registeredUserList = new ArrayList<Registration>();

		for (Registration registration : registrationRepository.findAll()) {

			registration.setEmailid(loginRepository.findById(registration.getLoginid()).get().getEmailid());

			registeredUserList.add(registration);

		}

		return registeredUserList;

	}

	public void deleteMyUser(int id)

	{

		registrationRepository.deleteById(id);

	}

	public Registration editUser(int id)

	{

		Optional<Registration> studentResponse = registrationRepository.findById(id);

		Registration student = studentResponse.get();

		return student;

	}

}