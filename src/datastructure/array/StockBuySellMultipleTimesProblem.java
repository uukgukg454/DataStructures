package datastructure.array;

public class StockBuySellMultipleTimesProblem {

    public static void main(String [] args) {
        int [] arr = {7,1,5,3,6,4};
        System.out.println("max_profit while buying once and selling once: "+maxProfit(arr));
    }

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) {
                //System.out.println("buy at day:"+(i)+":sell at day:"+(i+1));
                maxProfit += prices[i] - prices[i - 1];
            }
        return maxProfit;
    }
}
