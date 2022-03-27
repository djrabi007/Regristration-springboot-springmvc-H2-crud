package com.javatpoint.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "registration")

public class Registration {

	@Id

	private Integer loginid;

//           @Id

	// @GeneratedValue(strategy=GenerationType.IDENTITY)

	// @GeneratedValue

	// private int id;

	private String firstname;

	private String lastname;

	private String address;

	private String phonenumber;

	private int roleid;

	@JsonIgnore

	@Transient

	private String password; // Not saved in Table. Only for UI purpose

	@JsonIgnore

	@Transient

	private String emailid; // Not saved in Table. Only for UI purpose

	@ManyToOne

	@JoinColumn(name = "roleid", referencedColumnName = "roleid", insertable = false, updatable = false)

	@JsonIgnore

	private Role role;

	@ManyToOne

	@JoinColumn(name = "loginid", referencedColumnName = "loginid", insertable = false, updatable = false)

	@JsonIgnore

	private Login login;

	public Registration() {

	}

	public Registration(String firstname, String lastname, String address, String phonenumber) {

		super();

		this.firstname = firstname;

		this.lastname = lastname;

		this.address = address;

		this.phonenumber = phonenumber;

		// this.roleid = roleid;

	}

	public int getRoleid() {

		return roleid;

	}

	public void setRoleid(int roleid) {

		this.roleid = roleid;

	}

	public Role getRole() {

		return role;

	}

	public void setRole(Role role) {

		this.role = role;

	}

	public Login getLogin() {

		return login;

	}

	public void setLogin(Login login) {

		this.login = login;

	}

	public String getFirstname() {

		return firstname;

	}

	public void setFirstname(String firstname) {

		this.firstname = firstname;

	}

	public String getLastname() {

		return lastname;

	}

	public void setLastname(String lastname) {

		this.lastname = lastname;

	}

	public String getAddress() {

		return address;

	}

	public void setAddress(String address) {

		this.address = address;

	}

	public String getPhonenumber() {

		return phonenumber;

	}

	public void setPhonenumber(String phonenumber) {

		this.phonenumber = phonenumber;

	}

	public Integer getLoginid() {

		return loginid;

	}

	public void setLoginid(Integer loginid) {

		this.loginid = loginid;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getEmailid() {

		return emailid;

	}

	public void setEmailid(String emailid) {

		this.emailid = emailid;

	}

	@Override

	public String toString() {

		return "Registration [loginid=" + loginid + ", firstname=" + firstname + ", lastname=" + lastname + ", address="

				+ address + ", phonenumber=" + phonenumber + ", roleid=" + roleid + ", role=" + role + ", login="

				+ login + "]";

	}

}
