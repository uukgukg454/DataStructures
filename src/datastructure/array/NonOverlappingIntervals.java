package datastructure.array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String args[]) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println("min no of removals:"+eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int [] arr1, int [] arr2) {
                return arr1[0]-arr2[0];
            }
        });

        //1st sol
        /*int i=0;
        int count =0;
        for(int j=1;j<intervals.length;j++) {
            if(intervals[i][1]>intervals[j][0]) {
                count++;
                if(intervals[i][1]<intervals[j][1]) {
                    intervals[j]=intervals[i];
                }
            }
            i++;
        }*/

        //2nd sol
        int end = intervals[0][1];
        int count =0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++;
                end = Math.min(intervals[i][1], end);
            }
            else
                end = intervals[i][1];
        }

        for(int i=0;i<intervals.length;i++) {
            for(int j=0;j<intervals[0].length;j++) {
                System.out.print(intervals[i][j]+" ");
            }
            System.out.println();
        }

        return count;
    }
}
