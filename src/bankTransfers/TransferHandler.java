package bankTransfers;

import bank.Bank;



public interface TransferHandler {
	public boolean handleTransfer(Bank bank, double amount);
}
