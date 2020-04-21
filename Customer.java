package account_Pkg1;

import java.math.BigInteger;
import java.util.Scanner;

public class Customer {
	
	private String customerName;
	private int accountType;
	private BigInteger accountNumber;
	private String currency;
	private float amount;
	private float depAmount;
	private float witAmount;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public BigInteger getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(BigInteger accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getDepAmount() {
		return depAmount;
	}
	public void setDepAmount(float depAmount) {
		this.depAmount = depAmount;
	}
	public float getWitAmount() {
		return witAmount;
	}
	public void setWitAmount(float witAmount) {
		this.witAmount = witAmount;
	}
	
	
	
	
}
