package operations;

import decoratedAccount.AccountInterface;

public class OperationDeposit implements CommandOperations {
	private AccountInterface acc;
	private double amount;

	public OperationDeposit(AccountInterface acc, double amount) {
		this.acc = acc;
		this.amount = amount;
	}

	public boolean execute() {
		this.saveOperation();
		return acc.deposit(amount);
	}
	
	public void saveOperation(){
		this.acc.getOperationslist().add(this.toString());
	}
	
	@Override
	public String toString() {
		return "-------- Deposit --------"
			  +"\nAccount: "+this.acc.getId()
			  +"\n ==> "+this.amount
			  +"\n\n";
	}
}
