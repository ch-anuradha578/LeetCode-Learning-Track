package Day9;

public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
		int mini = prices[0];
		int profit = 0;

		for (int i = 1; i < prices.length; i++) {
			int cost = prices[i] - mini;
			profit = Math.max(profit, cost);
			mini = Math.min(mini, prices[i]);
		}
		return profit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStock solution = new BestTimetoBuyandSellStock();
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		System.out.print("Input: [ ");
		for (int price : prices) {
			System.out.print(price + ", ");

		}
		System.out.println("]");

		int result = solution.maxProfit(prices);
		System.out.println("Output: " + result);
	}

}
