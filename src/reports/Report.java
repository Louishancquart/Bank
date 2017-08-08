package reports;

import decoratedAccount.AccountInterface;

public class Report implements Visitor {

	public void visit(AccountInterface acc) {
		System.out.println(" ****** INFO ACC " + acc.getId() + " ******");
		System.out.println("account type =" + acc.getType());
		System.out.println("account amount =" + acc.getBalance());
		System.out.println("account interest ="
				+ acc.getInterest().getInterest(acc.getBalance()));

		System.out.println("*************************");

	}

	

}
