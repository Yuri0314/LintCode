/**
 * 时间复杂度为O(k*logk)
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
        Queue<Element> heap = new PriorityQueue<Element>(k, (element1, element2) -> element1.val - element2.val);
        int rowNum = matrix.length, colNum = matrix[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        heap.add(new Element(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 1; i < k; ++i) {
            Element element = heap.remove();
            int newRow = element.row + 1, newCol = element.col + 1;
            if (newRow < rowNum && !visited[newRow][element.col]) {
                heap.add(new Element(newRow, element.col, matrix[newRow][element.col]));
                visited[newRow][element.col] = true;
            }
            if (newCol < colNum && !visited[element.row][newCol]) {
                heap.add(new Element(element.row, newCol, matrix[element.row][newCol]));
                visited[element.row][newCol] = true;
            }
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