package interests;

import java.util.Random;

public class Flexible implements Interest {
	public Random rand;

	public Flexible() {
		this.rand = new Random();
	}
/**
 * generate interest according to the stock market trend
 */
	public double getInterest(double amount) {

		double stockMarketTrend = (rand.nextInt(4) - 2) / 100;
		double normalInterest = 0.1;

		return amount * (normalInterest + stockMarketTrend);
	}

}
