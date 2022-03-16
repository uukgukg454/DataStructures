package datastructure.array;

/**
 * buy once and sell once
 * need to find out max difference such that larger eleemnts comes after smaller element
 */
public class StockBuyOnceSellOnceProblem {

    public static void main(String [] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println("max_profit while buying once and selling once: "+maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1)
            return 0;
        int max_profit = prices[1] - prices[0];
        int min_element = prices[0];
        int i;
        for (i = 1; i < n; i++) {
            if (prices[i] - min_element > max_profit)
                max_profit = prices[i] - min_element;
            if (prices[i] < min_element)
                min_element = prices[i];
        }
        return Math.max(max_profit, 0);
    }
}
