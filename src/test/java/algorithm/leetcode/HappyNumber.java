package algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class HappyNumber {
    @Test
    void happyNumber_Test(){
        int n = 1;
//        int n = 1999999999;
        Solution solution = new Solution();
        boolean answer = solution.isHappy(n);
        Assertions.assertTrue(answer);
    }

    /*class Solution {
        public boolean isHappy(int n) {
                int tmp = n;
                int higherNumber = 0;

            Deque<Integer> tmpArray = new ArrayDeque<>();

            while(tmp != 1){
                System.out.println(tmp);

                while (tmp > 0){
                    tmpArray.addLast(tmp %10);
                    tmp/=10;
//                    System.out.println(n);
                }

            tmp = tmpArray.stream().mapToInt(integer -> (int) Math.pow(integer, 2)).sum();

                if (higherNumber == tmp) return false;

                higherNumber = Math.max(tmp,higherNumber);

                    if (tmp == 1)return true;

                    System.out.println(tmp);
                    System.out.println("higherNumber:  " +  higherNumber);

                    tmpArray.clear();
            }
                return true;
        }
    }*/

        class Solution {
            public boolean isHappy(int n) {
                if(n==1) return true;
                int tmp = n;
                Set<Integer> seen = new HashSet<>();

                Deque<Integer> tmpArray = new ArrayDeque<>();

                while (tmp != 1 && !seen.contains(tmp)) {
                    seen.add(tmp);

                    while (tmp > 0) {
                        tmpArray.addLast(tmp % 10);
                        tmp /= 10;
                    }

                    tmp = tmpArray.stream().mapToInt(integer -> (int) Math.pow(integer, 2)).sum();

                    if (tmp == 1)
                        return true;

                    tmpArray.clear();
                }

                return false;
            }
        }
}
