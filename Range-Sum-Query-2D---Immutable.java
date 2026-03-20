1class NumMatrix {
2    int prefix[][];
3    public NumMatrix(int[][] mat) {
4        int n = mat.length;
5        int m = mat[0].length;
6
7        prefix = new int[n + 1][m + 1];
8        for(int i=1; i<=n; i++){
9            for(int j=1; j<=m; j++){
10                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1]-prefix[i-1][j-1];
11
12            }
13        }
14
15    }
16    
17    public int sumRegion(int row1, int col1, int row2, int col2) {
18        return prefix[row2 + 1][col2 + 1]- prefix[row1][col2 + 1]- prefix[row2 + 1][col1]+ prefix[row1][col1];
19    }
20}
21
22/**
23 * Your NumMatrix object will be instantiated and called as such:
24 * NumMatrix obj = new NumMatrix(matrix);
25 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
26 */