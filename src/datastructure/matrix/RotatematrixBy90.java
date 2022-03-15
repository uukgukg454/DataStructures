package datastructure.matrix;

public class RotatematrixBy90 {

    public static void main(String[] args) {
        int[][] originalArr ={
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int noOfRows=originalArr.length; //3
        int noOfCols=originalArr[0].length; //4
        //printmatrix(originalArr,noOfRows,noOfCols);
        int [][] rotatedArr = new int[noOfCols][noOfRows];
        rotateAntiClockWise(originalArr,rotatedArr,noOfRows,noOfCols);
    }

    public static void rotateAntiClockWise(int [][] originalArr, int [][] rotatedArr,int noOfRows,int noOfCols)
    {
		/*  4 8 12
		 *  3 7 11
		  	2 6 10
		  	1 5 9
		  */
        for(int i=0;i<noOfRows;i++)
        {
            for(int j=0;j<noOfCols;j++)
            {
                rotatedArr[noOfCols-1-j][i] =originalArr[i][j];
            }
        }
        //printmatrix(rotatedArr,noOfRows,noOfCols);
        printmatrix(rotatedArr,noOfCols,noOfRows);

    }

    public static void printmatrix(int [][] arr,int noOfRows,int noOfCols)
    {
        for(int i=0;i<noOfRows;i++)
        {
            for(int j=0;j<noOfCols;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }

    }

    public static void printmatrix1(int [][] arr,int noOfRows,int noOfCols)
    {
        for(int i=0;i<noOfRows;i++)
        {
            for(int j=0;j<noOfCols;j++)
            {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println("\n");
        }

    }
}
