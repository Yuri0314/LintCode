/**
 * 时间复杂度为O((m + n)*log(max - min))，m为矩阵行数，n为矩阵列数，max为矩阵最大值，min为矩阵最小值
 */
public class Solution {
    private int rowNum;
    private int colNum;
    private int[][] matrix;
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        rowNum = matrix.length;
        colNum = matrix[0].length;
        this.matrix = matrix;

        int minVal = matrix[0][0];
        int maxVal = matrix[rowNum - 1][colNum - 1];
        while (minVal <= maxVal) {
            int midVal = minVal + ((maxVal - minVal) >> 1);
            ResultType res = findPos(midVal);
            if (res.exist && res.nums == k) return midVal;
            else if (res.nums < k) minVal = midVal + 1;
            else maxVal = midVal - 1;
        }
        return minVal;
    }

    private ResultType findPos(int val) {
        boolean exist = false;
        int nums = 0;
        int row = rowNum - 1, col = 0;
        while (row >= 0 && col < colNum) {
            if (matrix[row][col] == val) exist = true;
            if (matrix[row][col] <= val) {
                nums += row + 1;
                ++col;
            }
            else --row;
        }
        return new ResultType(exist, nums);
    }

    private class ResultType {
        boolean exist;
        int nums;
        ResultType (boolean exist, int nums) {
            this.exist = exist;
            this.nums = nums;
        }
    }
}