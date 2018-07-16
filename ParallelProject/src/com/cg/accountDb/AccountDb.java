package com.cg.accountDb;

import java.time.LocalDateTime;
import java.util.HashMap;

import com.cg.bean.Account;

public class AccountDb {
	private static HashMap<String,Account> accountDb=new HashMap<String,Account>();
	public static HashMap<String, Account> getAccountDb() {
	return accountDb;
	}
	static{
	 
	accountDb.put("9490240565",new Account("9490240565","Surya","surya@gmail.com",120.0,LocalDateTime.now()));
	accountDb.put("8008888840",new Account("8008888840","Raghu","raghu@gmail.com",100.0,LocalDateTime.now()));
	accountDb.put("9885574455",new Account("9885574455","Appu","appu@gmail.com",15100.0,LocalDateTime.now()));
	accountDb.put("9632587412",new Account("9632587412","rachel","rachel@gmail.com",20100.0,LocalDateTime.now()));
	}
	
}
