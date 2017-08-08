package operations;

import decoratedAccount.AccountInterface;

public class OperationWithdraw implements CommandOperations{
	
	private AccountInterface acc;
	private double amount;
	public  OperationWithdraw(AccountInterface acc,double amount)
	{
		this.acc=acc;
		this.amount=amount;
	}

	public boolean execute() {
		this.saveOperation();
		return acc.withdraw(amount);
	}

	public void saveOperation(){
		this.acc.getOperationslist().add(this.toString());
	}
	
	@Override
	public String toString() {
		return "-------- Withdraw --------"
			  +"\nAccount: "+this.acc.getId()
			  +"\n <== "+this.amount
			  +"\n\n";
	}
}
