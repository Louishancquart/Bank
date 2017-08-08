package bankTransfers;

import bank.Bank;

public class ConcreteTransferHandler2 implements TransferHandler {

	@Override
	public boolean handleTransfer(Bank bank, double amount) {
		if (amount < 0){
			System.out.println("-------- Bank transfer --------"
								+"\n transfer: "+amount
								+"\n new bank balance: "+bank.getBalance()
								+"\n\n");
		}else{
			
			return false; 
		}
		return true;
	}

}
