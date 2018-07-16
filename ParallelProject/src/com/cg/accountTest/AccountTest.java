package com.cg.accountTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cg.account.service.AccountServiceImpl;
import com.cg.bean.Account;
import com.cg.exception.AccountException;

public class AccountTest {
	private AccountServiceImpl service;
	
	@Before
	public void init() {
	service = new AccountServiceImpl();
	}
	
	
	@Test
	public void testCreateAccountForPhone() {
	Account ac= new Account();
	ac.setPhone("949024056");
	ac.setName("surya");
	ac.setEmail("surya@gmail.com");
	ac.setBalance(1200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	Assert.assertEquals("Phone number should contain 10 digits", e.getMessage());
	}
	}
	
	@Test
	public void testCreateAccountForPhone1() {
	Account ac= new Account();
	ac.setPhone("9490ab056");
	ac.setName("surya");
	ac.setEmail("surya@gmail.com");
	ac.setBalance(1200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	Assert.assertEquals("Phone number should contain 10 digits", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForName() {
	Account ac = new Account();
	ac.setPhone("1234567890");
	ac.setName("surya");
	ac.setEmail("saurya@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	Assert.assertEquals("Name should start with a capital letter", e.getMessage());
	}
	}
	
	@Test
	public void testCreateAccountForName1() {
	Account ac = new Account();
	ac.setPhone("1234567890");
	ac.setName("surya123");
	ac.setEmail("saurya@gmail.com");
	ac.setBalance(500.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	Assert.assertEquals("Name should start with a capital letter", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForNameIsEmpty() {
	Account ac = new Account();
	ac.setPhone("1234567890");
	ac.setName("");
	ac.setEmail("surya@gmail.com");
	ac.setBalance(200.0);
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
	Assert.assertEquals("Name cannot be null", e.getMessage());
	}
	}

	@Test
	public void testCreateAccountForEmail() {
	Account ac = new Account();
	ac.setPhone("1234567890");
	ac.setName("Rachel");
	ac.setBalance(2200.0);
	ac.setEmail("Akash@");
	
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Enter a valid email", e.getMessage());
	}
	}
	
	@Test
	public void testCreateAccountForEmail1() {
	Account ac = new Account();
	ac.setPhone("1234567890");
	ac.setName("Rachel");
	ac.setBalance(2200.0);
	ac.setEmail("@gmail.com");
	
	try {
	service.createAccount(ac);
	} catch (AccountException e) {
		Assert.assertEquals("Enter a valid email", e.getMessage());
	}
	}

	
	@Test
	public void testCreateAccount() {
	Account ac = new Account();
	ac.setPhone("9490240565");
	ac.setName("Surya");
	ac.setEmail("surya@gmail.com");
	ac.setBalance(2300.0);
	 
	try {
	String s=service.createAccount(ac);
	Assert.assertNotNull(s);
	} catch (AccountException e) {
	}
	 
	}
	 
	@Test
	public void testAccountBalanceForPhone() {
	try {
	service.AccountBalance("94909");
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Phone number should contain 10 digits",e.getMessage());
	}
	}
	 

	@Test
	public void testAccountBalanceForPhoneDoesNotExist() {
	try {
	service.AccountBalance("7896541230");
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("phone does not exist",e.getMessage());
	}
	}
	
	
	@Test
	public void testAccountBalanceForName() {
	Account ac=new Account();
	ac.setPhone("9874563215");
	try {
	service.AccountBalance(ac.getPhone());
	assertEquals("Surya", ac.getName());
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("phone does not exist",e.getMessage());
	}
	}
	 
	@Test
	public void testDepositForPhone() {
	Account ac=new Account();
	ac.setPhone("95059145");
	try {
	service.deposit(ac.getPhone(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Phone number should contain 10 digits",e.getMessage());
	}
	}
	@Test
	public void testDepositForPhoneDoesNotExist() {
	Account ac=new Account();
	ac.setPhone("1236545632");
	try {
	service.deposit(ac.getPhone(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("phone does not exist",e.getMessage());
	}
	}
	@Test
	public void testDepositForDepositAmt1() {
	Account ac=new Account();
	ac.setPhone("9490240565");
	try {
	service.deposit(ac.getPhone(), -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Deposit amount should be greater than 0",e.getMessage());
	}
	}
	 
	@Test
	public void testDeposit() {
	Account ac=new Account();
	ac.setPhone("9490240565");
	try {
	Account ac1=service.deposit(ac.getPhone(), 230);
	assertNotNull(ac1);
	} catch (AccountException e) {
	 assertEquals("Deposit amount should be greater than 0", e.getMessage());
	}
	}
	 
	@Test
	public void testWithDrawForPhone() {
	Account ac=new Account();
	ac.setPhone("95059345");
	try {
	service.withdraw(ac.getPhone(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Phone number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testWithDrawForPhone1() {
	Account ac=new Account();
	ac.setPhone("9505ab9345");
	try {
	service.withdraw(ac.getPhone(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Phone number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testWithdrawForPhoneDoesNotExist() {
	Account ac=new Account();
	ac.setPhone("3214569874");
	try {
	service.withdraw(ac.getPhone(), 230);
	} catch (AccountException e) {
	Assert.assertEquals("phone does not exist",e.getMessage());
	}
	}
	@Test
	public void testWithdrawForAmt() {
	Account ac=new Account();
	ac.setPhone("9490240565");
	try {
	service.withdraw(ac.getPhone(), -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Withdraw amount is more than current balance",e.getMessage());
	}
	}
	 

	@Test
	public void testFundTransferForPhone() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setPhone("9490240565");
	ac2.setPhone("8008888841");
	try {
	service.fundTransfer(ac.getPhone(),ac2.getPhone(), 230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("Phone number should contain 10 digits",e.getMessage());
	}
	}
	
	@Test
	public void testFundTransferForPhoneDoesNotExist() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setPhone("8885299963");
	ac2.setPhone("7854198563");
	try {
	service.fundTransfer(ac.getPhone(), ac2.getPhone(),  230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The mobile number does not exist",e.getMessage());
	}
	}
	@Test
	public void testFundTransferForAmt() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setPhone("9490240565");
	ac2.setPhone("8008888841");
	try {
	service.fundTransfer(ac.getPhone(), ac2.getPhone(),  -230);
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	Assert.assertEquals("The amount to be withdrawn should be greater than available balance and greater than zero",e.getMessage());
	}
	}
	@Test
	public void testFundTransfer() {
	Account ac=new Account();
	Account ac2=new Account();
	ac.setPhone("9490240565");
	ac2.setPhone("8008888841");
	try {
	assertTrue(service.fundTransfer(ac.getPhone(), ac2.getPhone(),  230));
	} catch (AccountException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	}
	}
	@Test
	public void testtransaction() {
	Account ac=new Account();
	ac.setPhone("9490240565");
	try {
	Account acc=service.TransactionDetails(ac.getPhone());
	assertNotNull(acc);
	} catch (AccountException e) {
	System.out.println(e.getMessage());
	}
	 
	}
	
	

}
