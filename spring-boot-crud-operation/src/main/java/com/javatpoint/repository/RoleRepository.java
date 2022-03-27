package com.javatpoint.repository;

import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

}