package operations;

import bank.Bank;
import bank.BankAgency;

public class OperationInterBankPayment implements CommandOperations{
	
	private double amount;
	private BankAgency ba;
	private Bank bank;
	
	//Bank
	public  OperationInterBankPayment(Bank bank,double amount)
	{
		this.bank=bank;
		this.amount=amount;
		this.ba=this.bank.getBankAgency();
	}

	public boolean execute() {
		return ba.transferMoneyFromBankToBank( bank, amount);
	}
	
	@Override
	public String toString() {
		return "-------- Bank transfer --------"
			  +"\n transfer: "+this.amount
			  +"\n\n";
	}
}
