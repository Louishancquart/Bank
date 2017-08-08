package decoratedAccount;

import interests.Interest;

import java.util.ArrayList;

import accounts.Account;

public abstract class Decorator extends Account{
	protected AccountInterface account;
	double amount;
	

	public ArrayList<String> getOperationslist() {
		return this.account.getOperationslist();
	}

	public Decorator(AccountInterface account) {
		this.account = account;
		this.amount= this.account.getBalance();
	}

	public boolean withdraw(double amount) {
		return account.withdraw(amount);
	}

	public double getBalance() {
		return account.getBalance();
	}

	public Interest getInterest() {
		return account.getInterest();
	}

	public void deposit(int amount) {
		account.deposit(amount);
	}

	public AccountInterface getAccount() {
		return account;
	}

	public String getType() {
		return (java.lang.String) account.getType();

	}

	public int getId() {
		return this.account.getId();
	}

	public void applyInterest() {
		this.account.setBalance(this.account.getBalance()+ getInterestAmount(this.account.getBalance()));
	}

	public void setBalance(double amount) {
		this.account.setBalance(amount);
	}

	public void setInterest(Interest interest) {
		this.account.setInterest(interest);
	}

	public double getInterestAmount(double ammount) {
		double interestCalculator = getInterest().getInterest(ammount) / 100;
		return (amount * interestCalculator);
	}

	public boolean deposit(double amount) {
		boolean addFlag = false;
		try {
			this.amount = this.amount + amount;
			addFlag = true;

		} catch (Exception exception) {
			addFlag = false;

		}

		return addFlag;
	}

	

}
