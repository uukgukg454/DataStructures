package datastructure.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumOfCoins {
    public static void main(String [] args) {
        int []coins =  {9,5,6,1}; //{1,2,5};
        int amount = 10;//11;
        System.out.println("minimum no of coins required using array:"+minCoinsUsingArray(coins,amount));
        System.out.println("minimum no of coins required using 2D array:"+minCoinsUsing2DArray(coins,amount));
    }

    static int minCoinsUsingArray(int [] coins, int amount) {
        int []dpArr = new int[amount+1];
        Arrays.fill(dpArr,Integer.MAX_VALUE);
        dpArr[0]=0;
        for(int i=0;i<amount+1;i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub_res = dpArr[i - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dpArr[i])
                        dpArr[i] = sub_res + 1;
                }
            }
        }
        return dpArr[amount]==Integer.MAX_VALUE?-1:dpArr[amount];
    }

    static int minCoinsUsing2DArray(int [] coins, int amount) {
        if(amount==0)
            return 0;
        int coinArrLen = coins.length;
        int [][]dpArr = new int[coinArrLen][amount+1];
        for(int j=0;j<amount+1;j++) {
            if(coins[0]>j){
                dpArr[0][j] = Integer.MAX_VALUE;
            } else {
                if(j%coins[0]==0){
                    dpArr[0][j]= j/coins[0];
                } else {
                    dpArr[0][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=1;i<coinArrLen;i++) {
            for(int j=1;j<amount+1;j++) {
                if(coins[i]>j) {
                    dpArr[i][j] = dpArr[i-1][j];
                } else {
                    if(dpArr[i][j-coins[i]] != Integer.MAX_VALUE)
                        dpArr[i][j]= Math.min(dpArr[i-1][j], 1+dpArr[i][j-coins[i]]);
                    else
                        dpArr[i][j] = dpArr[i-1][j];
                }
            }
        }
        int result = dpArr[coinArrLen-1][amount];
        //System.out.println("coins used::"+coinsUsed(dpArr,coinArrLen-1, amount, coins));
        return result>=Integer.MAX_VALUE?-1:result;
    }

    //not full proof
    static List<Integer> coinsUsed(int [][]dpArr, int m, int n, int []coins) {
        List<Integer> result = new ArrayList<>();
        while(m>=0) {
            if(n-coins[m]>=0 && dpArr[m][n]-1==dpArr[m][n-coins[m]]) {
                result.add(coins[m]);
                n = n-coins[m];
            } else if(m-1 >=0 && dpArr[m][n] == dpArr[m-1][n]) {
                m--;
            }
            if(m==0 && n==1) {
                result.add(coins[m]);
                break;
            }
        }
        return result;

    }
}
