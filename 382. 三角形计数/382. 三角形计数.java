import java.util.Arrays;

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        Arrays.sort(S);
        int num = 0;
        for (int i = 2; i < S.length; ++i) {
            int posL = 0;
            int posR = i - 1;
            while (posR > posL) {
                if (S[posL] + S[posR] > S[i]) {
                    num += posR - posL;
                    --posR;
                }
                else ++posL;
            }
        }
        return num;
    }
}