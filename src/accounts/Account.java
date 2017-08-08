package accounts;

import interests.Interest;

import java.util.ArrayList;

import reports.Visitable;
import reports.Visitor;
import decoratedAccount.AccountInterface;

public class Account implements Visitable, AccountInterface {
	int id;
	double balance;
	Interest interest;
	String type;
	ArrayList<String> operationslist;

	public Account() {

		setId(accountId);
		accountId = accountId++;

		this.operationslist = new ArrayList<String>();
		
		this.setType("Normal Account");
	}

	public ArrayList<String> getOperationslist() {
		return operationslist;
	}

	private static int accountId = 1;

	public String getType() {
		return type;
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void applyInterest() {
		balance += getInterestAmount(balance);
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public double getInterestAmount(double ammount) {
		double interestCalculator = getInterest().getInterest(ammount) / 100;
		return (balance * interestCalculator);
	}

	public boolean deposit(double amount) {
		boolean receipt = false;
		try {
			this.balance = this.balance + amount;
			receipt = true;

		} catch (Exception exception) {
			receipt = false;

		}

		return receipt;
	}

	public boolean withdraw(double amount) {
		boolean receipt = false;
		double result = getBalance() - amount;
		if (result <= 0){
			System.out.println("the withdraw operation failed");
		}
	
		setBalance(result);
		receipt = true;
		
		return receipt;
	}

};
