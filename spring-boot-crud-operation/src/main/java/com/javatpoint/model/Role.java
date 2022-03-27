
package com.javatpoint.model;

import java.util.Set;

 

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;

import javax.persistence.Table;

 

import com.fasterxml.jackson.annotation.JsonIgnore;

 

 

@Entity

@Table(name="Role")

public class Role {

             

              @Id

              //@GeneratedValue(strategy=GenerationType.IDENTITY)

              //@GeneratedValue

              private int roleid;

              private String role;

             

@OneToMany(mappedBy="role",fetch=FetchType.LAZY,cascade=CascadeType.ALL)

              @JsonIgnore

    private Set<Registration> registrations;

             

             

              public Role() {

                            

              }

    public Role(int roleId) {

              super();

              this.roleid = roleId;

              }

              public Role(int roleId, String role) {

                             super();

                             this.roleid = roleId;

                             this.role = role;

              }

             

             

              public Set<Registration> getRegistrations() {

                             return registrations;

              }

              public void setRegistrations(Set<Registration> registrations) {

                             this.registrations = registrations;

              }

              public int getRoleId() {

                             return roleid;

              }

              public void setRoleId(int roleId) {

                             this.roleid = roleId;

              }

              public String getRole() {

                             return role;

              }

              public void setRole(String role) {

                             this.role = role;

              }

              @Override

              public String toString() {

                             return "Role [roleId=" + roleid + ", role=" + role + "]";

              }

             

 

             

             

}