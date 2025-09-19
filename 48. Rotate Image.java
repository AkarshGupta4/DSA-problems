class Solution {
    public static void Transpose(int[][] matrix){
         int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverseArray(int[] row) {
        int i = 0, j = row.length - 1;
        while (i < j) {
            int temp = row[i];
            row[i] = row[j];
            row[j] = temp;
            i++;
            j--;
        }
    }

   public void rotate(int[][] matrix) {
        int n = matrix.length;

        
        Transpose(matrix);

        
        for (int i = 0; i < n; i++) {
            reverseArray(matrix[i]);
        }
    }
}