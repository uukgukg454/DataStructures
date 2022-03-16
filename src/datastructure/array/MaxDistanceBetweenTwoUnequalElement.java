package datastructure.array;

public class MaxDistanceBetweenTwoUnequalElement {

    public static void main(String [] args) {
        int [] arr ={1,1,1,6,1,1,1};
        System.out.println("max distance is:" +maxDistance(arr));
    }

    private static int maxDistance(int[] colors) {
        int n =colors.length;
        int maxDiffFixingFirstElement = 0;
        for(int i=n-1;i>0;i--) {
            if(colors[0]!= colors[i] && i> maxDiffFixingFirstElement) {
                maxDiffFixingFirstElement =i;
                break;
            }
        }
        int maxDiffFixingLastElement = 0;
        for(int i=0;i<n-1;i++) {
            if(colors[n-1]!= colors[i] && n-1-i> maxDiffFixingLastElement) {
                maxDiffFixingLastElement =n-1-i;
                break;
            }
        }

        return Math.max(maxDiffFixingFirstElement,maxDiffFixingLastElement);
    }

}
