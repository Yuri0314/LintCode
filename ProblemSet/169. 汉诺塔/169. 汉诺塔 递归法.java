import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: the number of disks
     * @return: the order of moves
     */
    public List<String> towerOfHanoi(int n) {
        List<String> path = new ArrayList<String>();
        move(n, 'A', 'B', 'C', path);
        return path;
    }

    private void move(int num, char source, char tmp, char des, List<String> path) {
        if (num == 1) {
            path.add("from " + source + " to " + des);
            return;
        }
        move(num - 1, source, des, tmp, path);
        path.add("from " + source + " to " + des);
        move(num - 1, tmp, source, des, path);
    }
}