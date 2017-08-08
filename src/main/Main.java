package main;

import interests.Fixed;
import interests.Interest;
import operations.CommandOperations;
import operations.Invoker;
import operations.OperationDeposit;
import operations.OperationInterBankPayment;
import operations.OperationWithdraw;
import reports.Report;
import reports.Visitor;
import accounts.Account;
import bank.Bank;
import bank.BankAgency;
import decoratedAccount.Debit;
import decoratedAccount.Decorator;

public class Main {
	
	

	public static void main(String []args)
	{
		//registering banks into mediator
		BankAgency ba = new BankAgency();
		
//		Random rand = new Random();
		Bank bank1 = new Bank(ba, 200000);
		Bank bank2 = new Bank(ba,4000000);
		Interest interest = new Fixed();

		Account account = new Account();
		account.setInterest(interest);
		Invoker invoker = new Invoker();
		bank1.addAccount(account);
		
		System.out.println(" ==> deposit 1000 ");
		CommandOperations depositCommand = new OperationDeposit(account, 1000);
		bank1.makeTheInvoke(invoker, depositCommand);
		bank1.getInvoker().doOperation();// deposit 1000

		System.out.println(" <== withdraw 800 ");
		CommandOperations withdrawCommand = new OperationWithdraw(account, 800);
		bank1.getInvoker().setCommand(withdrawCommand);
		bank1.getInvoker().doOperation();//withdraw 800, remain 200

		
		System.out.println(" Accounts Report ");
		Visitor v=new Report();
		Visitor vOperations=new Report();
		bank1.printInformation(v);
		

		CommandOperations withdrawCommand1 = new OperationWithdraw(account, 400);
		bank1.getInvoker().setCommand(withdrawCommand1);
		bank1.getInvoker().doOperation();

		
		Decorator debitAccount = new Debit(account);
		CommandOperations withdrawCommand2 = new OperationWithdraw(debitAccount, 400);
		bank1.getInvoker().setCommand(withdrawCommand2);
		bank1.getInvoker().doOperation();
		
		

	
		CommandOperations interbankCommand = new OperationInterBankPayment(bank1, 400);
		bank1.getInvoker().setCommand(interbankCommand);
		bank1.getInvoker().doOperation();
		
		CommandOperations interbankCommand2 = new OperationInterBankPayment(bank2, -400);
		bank1.getInvoker().setCommand(interbankCommand2);
		bank1.getInvoker().doOperation();
		
		CommandOperations interbankCommand3 = new OperationInterBankPayment(bank2, 0 );
		bank1.getInvoker().setCommand(interbankCommand3);
		bank1.getInvoker().doOperation();
		
		bank1.printInformation(v);
		
		System.out.println(" Operations Report ");
		bank1.printInformation(vOperations);
		
		System.out.println(" Accounts Report ");
		bank1.printInformation(v);
		
		
		
								
	}
}
