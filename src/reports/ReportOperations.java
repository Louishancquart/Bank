package reports;

import decoratedAccount.AccountInterface;

public class ReportOperations implements Visitor {
	public void visit(AccountInterface acc) {

		System.out.println(" ****** OPERATIONS account : " + acc.getId()
				+ " ******");
		System.out.println("***********\n");

	}
}
