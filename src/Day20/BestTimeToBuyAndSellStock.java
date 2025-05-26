package Day20;

/**
 * Solves the "Best Time to Buy and Sell Stock III" problem.
 * Calculates the maximum profit achievable with at most two transactions.
 * Each transaction consists of a buy followed by a sell.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Calculates the maximum profit with at most two transactions.
     *
     * @param prices Array of stock prices.
     * @return Maximum profit achievable.
     */
    public int maxProfit(int[] prices) {
        int buy1 = Integer.MAX_VALUE;  // Lowest price for the first buy
        int sell1 = 0;                 // Max profit after the first sell
        int buy2 = Integer.MAX_VALUE;  // Lowest effective price for the second buy
        int sell2 = 0;                 // Max total profit after the second sell

        for (int price : prices) {
            buy1 = Math.min(buy1, price);             // Minimize first buy cost
            sell1 = Math.max(sell1, price - buy1);    // Maximize profit from first sell
            buy2 = Math.min(buy2, price - sell1);     // Minimize second buy cost (adjusted with profit from first sell)
            sell2 = Math.max(sell2, price - buy2);    // Maximize total profit after second sell
        }

        return sell2;  // Final profit after at most two transactions
    }

    /**
     * Main method to test the algorithm with sample data.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();

        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};

        System.out.print("Stock Prices: [ ");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println("]");

        int result = solution.maxProfit(prices);
        System.out.println("Maximum Profit with 2 transactions (buy1-sell1, buy2-sell2): " + result);
    }
}
