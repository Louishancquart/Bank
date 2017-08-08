package decoratedAccount;

import interests.Interest;

import java.util.ArrayList;

public interface AccountInterface  {
	
	public abstract ArrayList<String> getOperationslist();

	public abstract String getType();

	abstract void setType(String type);

	public abstract int getId();

	public abstract double getBalance();

	public abstract void applyInterest();

	public abstract void setBalance(double amount);

	public abstract Interest getInterest();

	public abstract void setInterest(Interest interest);

	public abstract double getInterestAmount(double ammount);

	public abstract boolean deposit(double amount);

	public abstract boolean withdraw(double amount);

	public abstract void setId(int id);

}