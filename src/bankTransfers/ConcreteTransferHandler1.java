package bankTransfers;

import bank.Bank;

public class ConcreteTransferHandler1 implements TransferHandler {

	@Override
	public boolean handleTransfer(Bank bank, double amount) {
		if (amount > 0){
			System.out.println("-------- Bank transfer --------"
								+"\n transfer: "+amount
								+"\n new bank balance: "+bank.getBalance()
								+"\n\n");
		}else{
			return new ConcreteTransferHandler2().handleTransfer(bank, amount);
		}
		return true;
	}

}
