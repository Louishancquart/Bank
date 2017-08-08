package bankTransfers;

import bank.Bank;

public class ConcreteTransferHandler3 implements TransferHandler {

	@Override
	public boolean handleTransfer(Bank bank, double amount) {
		if (amount == 0){
			System.out.println("-------- Bank transfer --------"
								+"\n NO Transfert");
		}else{
			try {
				throw new Exception("untreated transfer");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return false; 
		}
		return true;
	}

}
