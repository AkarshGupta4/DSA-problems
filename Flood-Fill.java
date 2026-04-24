1class Solution {
2    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
3        int originalcolor = image[sr][sc];
4
5        if(originalcolor == color) return image;
6
7        dfs(image, sr, sc, originalcolor, color);
8
9        return image;
10    }
11
12    int[] rd = {1,-1,0,0};
13    int[] cd = {0,0,1,-1};
14
15    public void dfs(int[][] image, int r ,int c, int originalcolor , int color){
16        int n = image.length;
17        int m = image[0].length;
18
19        if(r<0 || r>=n || c<0 || c>=m || image[r][c] != originalcolor){
20
21            return;
22        }
23        image[r][c] = color;
24
25            for(int i=0; i<4; i++){
26                int nr = r + rd[i];
27                int nc = c + cd[i];
28                dfs(image, nr,nc ,originalcolor , color);
29            }
30
31    }
32}