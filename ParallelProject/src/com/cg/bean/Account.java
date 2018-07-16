package com.cg.bean;

import java.time.LocalDateTime;

public class Account {
private String Name;
private String Phone;
private String Email;
private double balance;
private LocalDateTime date;
public Account(String name, String phone, String email, double balance,
		LocalDateTime date) {
	super();
	Name = name;
	Phone = phone;
	Email = email;
	this.balance = balance;
	this.date = date;
}
public Account() {
	// TODO Auto-generated constructor stub
}
public LocalDateTime getDate() {
	return date;
}
public void setDate(LocalDateTime date) {
	this.date = date;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

}
