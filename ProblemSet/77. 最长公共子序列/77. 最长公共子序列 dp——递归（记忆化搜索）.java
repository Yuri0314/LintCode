import java.util.Arrays;

public class Solution {
    private char[] text1;
    private char[] text2;
    private int[][] memo;
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        this.text1 = A.toCharArray();
        this.text2 = B.toCharArray();
        this.memo = new int[A.length()][B.length()];
        for (int i = 0; i < memo.length; ++i)
            Arrays.fill(memo[i], -1);
        return search(A.length() - 1, B.length() - 1);
    }

    private int search(int pos1, int pos2) {
        if (pos1 == -1 || pos2 == -1) return 0;
        if (memo[pos1][pos2] != -1) return memo[pos1][pos2];
        memo[pos1][pos2] = 
            (text1[pos1] == text2[pos2]) ? 
            (search(pos1 - 1, pos2 - 1) + 1) : 
            Math.max(search(pos1 - 1, pos2), search(pos1, pos2 - 1));
        return memo[pos1][pos2];
    }
}