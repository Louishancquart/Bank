package decoratedAccount;




public class Debit extends Decorator {

	public Debit(AccountInterface account) {
		super(account);

	}

	public AccountInterface getAccount() {
		return account;
	}

	public void setAccount(AccountInterface account) {
		this.account = account;
	}

	public boolean withdraw(double amount) {

		if (account.withdraw(amount) == false) {
			System.out
					.println("Withdraw Debit account");
			account.setBalance(account.getBalance() - amount);
		}

		return true;
	}

	

	

	

	

}
