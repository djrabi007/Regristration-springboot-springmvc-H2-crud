package com.javatpoint.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "Login")

public class Login {

	@Id

	// @GeneratedValue(strategy=GenerationType.IDENTITY)

	// @GeneratedValue (strategy=GenerationType.AUTO)

	private int loginid;

	private String password;

	private String emailid;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	@JsonIgnore

	private Set<Registration> registrations;

	public Login() {

	}

	public Login(int loginId, String password, String emailId) {

		super();

		this.loginid = loginId;

		this.password = password;

		this.emailid = emailId;

	}

	public Set<Registration> getRegistrations() {

		return registrations;

	}

	public void setRegistrations(Set<Registration> registrations) {

		this.registrations = registrations;

	}

	public int getLoginid() {

		return loginid;

	}

	public void setLoginid(int loginid) {

		this.loginid = loginid;

	}

	public String getEmailid() {

		return emailid;

	}

	public void setEmailid(String emailid) {

		this.emailid = emailid;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getEmailId() {

		return emailid;

	}

	public void setEmailId(String emailId) {

		this.emailid = emailId;

	}

	@Override

	public String toString() {

		return "Login [loginId=" + loginid + ", password=" + password + ", emailId=" + emailid + "]";

	}

}