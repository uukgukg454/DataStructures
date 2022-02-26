package datastructure.dp;

public class CoinChangeProblem {
    public static void main(String [] args)  {
        int [] coins = {4,2,3,5};
        int amount =7;
        System.out.println("no of possible ways using array::"+noOfWaysUsing2DArray(coins, amount));
        System.out.println("no of possible ways using 2D array::"+noOfWaysUsingArray(coins, amount));
    }

    static int noOfWaysUsing2DArray(int [] coins ,int amount) {

        int [][]dpArr = new int[coins.length+1][amount+1];
        dpArr[0][0] = 1;
        for(int i=1;i<amount+1;i++) {
            dpArr[0][i] = 0;
        }
        for(int i=0;i<coins.length;i++) {
            for(int j=0;j<amount+1;j++) {
                if(coins[i]>j) {
                    dpArr[i+1][j] = dpArr[i][j];
                } else {
                    dpArr[i+1][j]= dpArr[i][j]+ dpArr[i+1][j-coins[i]];
                }
            }
        }
        /*for(int i=0;i<coins.length+1;i++) {
            for(int j=0;j<amount+1;j++) {
                System.out.print(dpArr[i][j]+" ");
            }
            System.out.println();
        }*/
        return dpArr[coins.length][amount];
    }

    static int noOfWaysUsingArray(int []coins, int amount) {
        int m = coins.length;
        int[] dpArr = new int[amount +1];
        dpArr[0] = 1;
        for (int i=0; i<m; i++)
            for (int j = coins[i]; j<= amount; j++)
                dpArr[j] += dpArr[j-coins[i]];

        /*for(int i=0;i<=amount;i++) {
            System.out.print(dpArr[i]+" ");
        }*/
        return dpArr[amount];
    }
}


