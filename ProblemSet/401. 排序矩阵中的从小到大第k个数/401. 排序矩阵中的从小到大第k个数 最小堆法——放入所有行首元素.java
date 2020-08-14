/**
 * 时间复杂度为O(k*logm)，m为矩阵行数
 */
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        int rowNum = matrix.length, colNum = matrix[0].length;
        Queue<Element> heap = new PriorityQueue<Element>(rowNum, (element1, element2) -> element1.val - element2.val);
        for (int i = 0; i < rowNum; ++i) 
            heap.add(new Element(i, 0, matrix[i][0]));

        for (int i = 1; i < k; ++i) {
            Element element = heap.remove();
            int newCol = element.col + 1;
            if (newCol < colNum) heap.add(new Element(element.row, newCol, matrix[element.row][newCol]));
        }
        return heap.element().val;
    }

    private class Element {
        int row;
        int col;
        int val;
        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}