class Solution {
    public int minCost(int[][] grid) {
       int rows = grid.length;
        int cols = grid[0].length;
        boolean dp[][] = new boolean[cols][1024];
        dp[0][grid[0][0]] = true;
        for(int i =0;i< rows; i++){
            for(int j =0;j<cols;j++){
                if(i ==0 && j ==0)continue;
                boolean next[] = new boolean [1024];
                int num = grid[i][j];
                for(int x = 0; x<1024;x++){
                    if((i>0 && dp[j][x]) || (j>0 && dp[j-1][x])){
                        next[x^num]=true;
                    }
                }
                dp[j]= next;
            }
        }
        for(int x = 0; x< 1024; x++){
            if(dp[cols - 1][x])return x;
        }
        return -1;
    }
}