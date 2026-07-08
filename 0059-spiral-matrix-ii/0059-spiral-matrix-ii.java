import java.util.Arrays;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1, maxNum = n * n;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= maxNum) {
            // left → right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;

            // top → bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // right → left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = num++;
                }
                bottom--;
            }

            // bottom → top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] result = sol.generateMatrix(3);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
