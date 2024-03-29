package algorithm.programars.biggestNumber2.biggestNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BiggestNumber {

    @Test
    void solution_Test(){
        int [] numbers = new int[]{6, 10, 2};
        int [] numbers1 = new int[]{3, 30, 34, 5, 9};
        Solution1 solution = new Solution1();

        String answer = solution.solution(numbers);
        String answer1 = solution.solution(numbers1);

        Assertions.assertEquals("6210",answer);
        Assertions.assertEquals("9534330",answer1);

    }
}

class Solution1 {

    public String solution(int[] numbers) {
        int length = numbers.length;

        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = numbers[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < length; i++) {
            answer.append(arr[i]);
        }

        if (answer.toString().charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}
class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        for (int i = 0; i < strArr.length - 1; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if ((strArr[j] + strArr[i]).compareTo(strArr[i] + strArr[j]) > 0) {
                    String temp = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }

        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}


class Solution3 {

    public String solution(int[] numbers) {
        int length = numbers.length;

        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strArr, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            answer.append(strArr[i]);
        }

        if (answer.toString().charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}