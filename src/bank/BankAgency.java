package bank;

import java.util.ArrayList;
import java.util.List;

import bankTransfers.ConcreteTransferHandler1;
import bankTransfers.TransferHandler;

public class BankAgency {
	private List<Bank> banklist;
	private TransferHandler trHandler;
	
	public BankAgency() {
		this.banklist = new ArrayList<Bank>();
		this.trHandler = new ConcreteTransferHandler1();
	}
	
	public boolean transferMoneyFromBankToBank(Bank bank,double amount){
		return trHandler.handleTransfer(bank, amount);//Chain Of responsability here
	}

	public List<Bank> getBanklist() {
		return banklist;
	}

	public void setBanklist(List<Bank> banklist) {
		this.banklist = banklist;
	}
	
}
