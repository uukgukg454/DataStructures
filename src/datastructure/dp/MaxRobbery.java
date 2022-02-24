package datastructure.dp;

/**
 * There are n houses build in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value of these houses, 
 * but he can’t steal in two adjacent houses 
 * because the owner of the stolen houses will tell his two neighbors left and right side. 
 * What is the maximum stolen value
 */
public class MaxRobbery {
    public static void main(String []args) {
        int[] arr = {6, 7, 1, 3, 8, 2, 4};
        System.out.println("max robbery::"+maxRobbery(arr));
    }

    static int maxRobbery(int [] arr) {
        int n = arr.length;
        if(n==1)
            return arr[0];
        else if(n==2)
            return Math.max(arr[0],arr[1]);
        else {
            int [] maxStolenValueArr = new int [n];
            maxStolenValueArr[0] = arr[0];
            maxStolenValueArr[1] = Math.max(arr[0],arr[1]);
            for(int i=2;i<n;i++) {
                maxStolenValueArr[i]= Math.max(maxStolenValueArr[i-1], (arr[i]+maxStolenValueArr[i-2]));
            }
            return maxStolenValueArr[n-1];
        }

    }
}
