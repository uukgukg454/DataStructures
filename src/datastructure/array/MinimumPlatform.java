package datastructure.array;

import java.util.Arrays;

public class MinimumPlatform {

    public static void main(String [] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println(findPlatform(arr, dep, n));
    }

    /**
     *
     Given arrival and departure times of all trains that reach a railway station.
     Find the minimum number of platforms required for the railway station so that no train is kept waiting.
     Consider that all the trains arrive on the same day and leave on the same day.
     Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
     At any given instance of time, same platform can not be used for both departure of a train and arrival of another train.
     In such cases,we need different platforms.
     */
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=1,j=0;
        int currCount =1;
        int maxCount = 1;
        while(i<n && j<n) {
            if(arr[i]>dep[j]) {
                currCount--;
                j++;
            } else{
                currCount++;
                i++;
            }
            if(currCount>maxCount) {
                maxCount = currCount;
            }
        }
        return maxCount;
    }
}
