package com.javatpoint.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javatpoint.model.Role;
import com.javatpoint.repository.RoleRepository;


@Service

@Transactional

public class RoleService {

	private final RoleRepository roleRepository;

	public RoleService(RoleRepository roleRepository)

	{

		this.roleRepository = roleRepository;

	}

	public Role SaveMyUser(Role role)

	{

		return roleRepository.save(role);

	}

	public List<Role> showAllUsers()

	{

		List<Role> registeredUserList = new ArrayList<Role>();

		for (Role role : roleRepository.findAll()) {

			registeredUserList.add(role);

		}

		return registeredUserList;

	}

	public void deleteMyUser(int id)

	{

		roleRepository.deleteById(id);

	}

	public Role editUser(int id)

	{

		Optional<Role> studentResponse = roleRepository.findById(id);

		Role student = studentResponse.get();

		return student;

	}

	/*
	 * 
	 * public User findByUsernameAndPassword(String username, String password) {
	 * 
	 * return registrationRepository.findByUsernameAndPassword(username, password);
	 * 
	 * }
	 * 
	 */

}