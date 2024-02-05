package com.journaldev.spring.model;


import lombok.Data;

@Data
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String email;
	private boolean isActive;
}
