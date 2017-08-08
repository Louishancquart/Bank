package tests;

import junit.framework.TestCase;
import operations.CommandOperations;
import operations.Invoker;
import operations.OperationDeposit;
import operations.OperationWithdraw;
import accounts.Account;
import bank.Bank;
import bank.BankAgency;

public class AccountTest extends TestCase {
	private Account account;
	private Bank bank1;
	private Invoker invoker;
	private BankAgency ba;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		//registering banks into mediator
		this.ba = new BankAgency();
		
		//	Random rand = new Random();
		this.bank1 = new Bank(ba, 200000);
		
		

		this.account = new Account();
		this.invoker = new Invoker();
		this.bank1.addAccount(account);
				
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDeposit() {

		CommandOperations depositCommand = new OperationDeposit(account, 1000);
		account.setBalance(0);
		bank1.makeTheInvoke(invoker, depositCommand);
		bank1.getInvoker().doOperation();// deposit 1000
		
		
		assertEquals(1000.0, account.getBalance());

		
	}

	public void testWithdraw() {
		account.setBalance(1000);
		CommandOperations withdrawCommand = new OperationWithdraw(account, 800);
		this.invoker.setCommand(withdrawCommand);
		this.invoker.doOperation();
		
		assertEquals(200.0, account.getBalance());
	}

}
