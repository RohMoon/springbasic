package algorithm.leetcod.denom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    public void test(){
        Solution solution = new Solution();
        int[] answer = solution.solution(1,3,1,6);

        int[] expected = {1, 2};

        Assertions.assertArrayEquals(expected, answer);
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (denom1 * numer2);
        int denom = denom1 * denom2;
        int commonFactor = 0;

        int bigger = 0;
        int smaller = 0;
        int result;

        if (numer > denom) {
            bigger = numer;
            smaller = denom;

        } else if (numer < denom) {
            bigger = denom;
            smaller = numer;
        }

        result = bigger % smaller;

        while(result !=0){
            int tmp = smaller;
            smaller = result;
            bigger = tmp;
            result = bigger % smaller;

        }
        if (result == 0){
            commonFactor = smaller;
        }

        int[] answer = { (numer / commonFactor), (denom / commonFactor) };
        return answer;
    }
}