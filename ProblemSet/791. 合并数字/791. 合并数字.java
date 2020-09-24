import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    /**
     * @param numbers: the numbers
     * @return: the minimum cost
     */
    public int mergeNumber(int[] numbers) {
        Queue<Integer> heap = new PriorityQueue<Integer>(numbers.length);
        for (int num : numbers)
            heap.add(num);
        int cost = 0;
        while (heap.size() > 1) {
            int tmp = heap.remove() + heap.remove();
            cost += tmp;
            heap.add(tmp);
        }
        return cost;
    }
}