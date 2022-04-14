package datastructure.graph;

public class NoOfIslands {
    public static void main(String[] args) {
        int[][] ocean = {
                        {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
        };
        int m = ocean.length;
        int n = ocean[0].length;
        int count =0;
        for(int i=0; i<m;i++) {
            for(int j=0;j<n;j++) {
                if(ocean[i][j]==1) {
                    count++;
                    countIslands(ocean, i,j,m,n);
                }
            }
        }
        System.out.println("total no of islands:"+count);

    }

    static void countIslands(int [][] ocean, int i, int j, int m, int n) {
        if(i<0|| i>=m || j<0 ||j>=n || ocean[i][j]==0)
            return;
        ocean[i][j]=0;
        countIslands(ocean, i + 1, j, m, n);
        countIslands(ocean, i - 1, j, m, n);
        countIslands(ocean, i, j + 1, m, n);
        countIslands(ocean, i, j - 1, m, n);
        countIslands(ocean, i + 1, j + 1, m, n);
        countIslands(ocean, i - 1, j - 1, m, n);
        countIslands(ocean, i + 1, j - 1, m, n);
        countIslands(ocean, i - 1, j + 1, m, n);

    }
}
