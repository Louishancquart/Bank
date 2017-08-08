package reports;

import decoratedAccount.AccountInterface;

public interface Visitor {
	public void visit(AccountInterface acc);

}