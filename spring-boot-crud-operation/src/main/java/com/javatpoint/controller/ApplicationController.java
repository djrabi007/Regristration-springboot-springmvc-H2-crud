package com.javatpoint.controller;

import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javatpoint.model.Login;
import com.javatpoint.model.Registration;
import com.javatpoint.model.Role;
import com.javatpoint.service.LoginService;
import com.javatpoint.service.RegistrationService;
import com.javatpoint.service.RoleService;

/**
 * INSERT INTO ROLE( ROLEID,ROLE) VALUES ('1','ADMIN'); SELECT * FROM ROLE
 * SELECT * FROM REGISTRATION SELECT * FROM LOGIN
 * 
 * @author rabi0
 *
 */

//@RestController
@Controller
public class ApplicationController {

	private static final String REGISTRATION_JSP = "registration.jsp";

	private static final String LOGIN_JSP = "login.jsp";

	private static final String SUCCESS_JSP = "success.jsp";

	@Autowired

	private RegistrationService registrationService;

	@Autowired

	private RoleService roleService;

	@Autowired

	private LoginService loginService;

	@RequestMapping("/")
	public String Welcome1()
	{
		return REGISTRATION_JSP;

	}


	@PostMapping("/save-user1")
	public String registerUser1(@ModelAttribute Registration registration, HttpServletRequest request)
	{
		Role role = roleService.editUser(registration.getRoleid());
		Login login = new Login();
		login.setEmailId(registration.getEmailid());
		login.setPassword(registration.getPassword());
		login.setLoginid(ThreadLocalRandom.current().nextInt(7, 8000));
		login = loginService.SaveMyUser(login);
		registration.setRole(role);
		registration.setLogin(login);
		registration.setLoginid(login.getLoginid());
		registrationService.SaveMyUser(registration);
		request.setAttribute("mode", "MODE_SAVEDUSER");
		return LOGIN_JSP;

	}


	@GetMapping("/show-users1")
	public String showAllUsers1(HttpServletRequest request) {

		request.setAttribute("newusers", registrationService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return REGISTRATION_JSP;

	}


	@RequestMapping("/login1")
	public String login1(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return LOGIN_JSP;
	}


	@RequestMapping("/login-user1")
	public String loginUser1(@ModelAttribute Login login, HttpServletRequest request) {
		if (loginService.findByEmailidAndPassword(login.getEmailid(), login.getPassword()) != null) {
			request.setAttribute("username", login.getEmailid());
			return SUCCESS_JSP;

		}

		else {
			request.setAttribute("error", "Invalid Username or Password");
			return LOGIN_JSP;
		}

	}

}