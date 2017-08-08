package bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import decoratedAccount.AccountInterface;

import operations.CommandOperations;
import operations.Invoker;
import reports.Visitable;
import reports.Visitor;

import accounts.Account;

public class Bank {
	private List<Visitable> accounts;
	private double balance; 
	private Invoker invoker;
	private CommandOperations command;
	private BankAgency ba;

	public List<Visitable> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Visitable> accounts) {
		this.accounts = accounts;
	}

	public BankAgency getBankAgency() {
		return ba;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}


	

	public Bank(BankAgency ba, double banlance) {
		this.ba= ba;
		this.getBankAgency().getBanklist().add(this);
		accounts = new ArrayList<Visitable>();
		this.setBalance(balance);
	}

	public void addAccount(Account c)

	{
		accounts.add(c);
	}

	public void printInformation(Visitor v) {
		Iterator<Visitable> iterator = accounts.listIterator();
		Account account = null;
		while (iterator.hasNext()) {
			account = (Account) iterator.next();
			account.accept(v);

		}
	}

	public AccountInterface getAccount(int id) {
		AccountInterface acc = null;
		Iterator<Visitable> iterator = accounts.listIterator();
		while (iterator.hasNext()) {
			acc = (AccountInterface) iterator.next();
			if (acc.getId() == id) {
				break;
			}

		}
		return acc;
	}

	public void makeTheInvoke(Invoker invoker, CommandOperations command) {
		this.invoker = invoker;
		this.command = command;
		invoker.setCommand(command);
	}

	public Invoker getInvoker() {
		return invoker;
	}

}
