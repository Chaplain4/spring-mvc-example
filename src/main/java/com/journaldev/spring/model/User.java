package com.journaldev.spring.model;


import lombok.Data;

@Data
public class User {
	private String name;
	private String lastName;
	private String login;
	private String pwd;
}
