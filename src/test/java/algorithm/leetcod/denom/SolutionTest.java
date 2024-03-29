package algorithm.leetcod.denom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SolutionTest {
    @Test
    public void test() throws Exception {
        SolutionTest solution = new SolutionTest();
        int[] answer = solution.solution(1,3,1,6);
        int[] answer2 = solution.solution(3,3,3,3);
        int[] answer3 = solution.solution(1,2,1,2);

        int[] expected = {1, 2};
        int[] expected2 = {2, 1};
        int[] expected3 = {1, 1};

        Assertions.assertArrayEquals(expected, answer);
        Assertions.assertArrayEquals(expected2, answer2);
        Assertions.assertArrayEquals(expected3, answer3);
    }

    public int[] solution(int numer1, int denom1, int numer2, int denom2) throws Exception {
        int numer = calculateCommonNumer(numer1, denom1, numer2, denom2);
        int denom = caculateCommonDenom(denom1, denom2);

        int bigger = 0;
        int smaller = 0;

        if (isNumerBiggerThanDenom(numer, denom)) {
            bigger = numer;
            smaller = denom;

        } else if (isDenomBiggerThanNumer(numer, denom)) {
            bigger = denom;
            smaller = numer;
        } else if (numer == denom) {
            bigger = denom;
            smaller = numer;
        }else{
            throw new Exception(" 찾아라 비밀의 열쇠");
        }

        int commonFactor = calculateCommonFactor(smaller, bigger);

        int[] answer = { (numer / commonFactor), (denom / commonFactor) };

        return answer;
    }

    private static int caculateMOD(int bigger, int smaller) {
        int result;
        result = bigger % smaller;
        return result;
    }

    private boolean isDenomBiggerThanNumer(int numer, int denom) {
        return numer < denom;
    }

    private boolean isNumerBiggerThanDenom(int numer, int denom) {
        return numer > denom;
    }

    private int caculateCommonDenom(int denom1, int denom2) {
        return denom1 * denom2;
    }

    private int calculateCommonNumer(int numer1, int denom1, int numer2, int denom2) {
        int numer = (numer1 * denom2) + (denom1 * numer2);
        return numer;
    }

    private int calculateCommonFactor(int smaller, int bigger) {
        int commonFactor = 1 ;
        int result = caculateMOD(bigger, smaller);

        while(result !=0){
            int tmp = smaller;
            smaller = result;
            bigger = tmp;
            result = bigger % smaller;
        }
            if (result == 0){
                commonFactor = smaller;
            }


        return commonFactor;
    }
}