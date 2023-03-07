package algorithm.programars.correctBracket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 올바른 괄호
 * 문제 설명
 * 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
 *
 * "()()" 또는 "(())()" 는 올바른 괄호입니다.
 * ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
 * '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
 *
 * 제한사항
 * 문자열 s의 길이 : 100,000 이하의 자연수
 * 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
 * 입출력 예
 *    s	   answer
 * "()()"	true
 * "(())()"	true
 * ")()("	false
 * "(()("	false
 * 입출력 예 설명
 * 입출력 예 #1,2,3,4
 * 문제의 예시와 같습니다.
 *
 * */

public class CorrectBracket {

    @Test
    void correctBracket_Test(){
        String s = "()()";
        String s1 = "(())()";
        String s2 = ")()(";
        String s3 = "(()(";


        Solution solution = new Solution();
        boolean answer = solution.solution(s);
        boolean answer1 = solution.solution(s1);
        boolean answer2 = solution.solution(s2);
        boolean answer3 = solution.solution(s3);

        Assertions.assertTrue(answer);
        Assertions.assertTrue(answer1);
        Assertions.assertFalse(answer2);
        Assertions.assertFalse(answer3);
    }

}

class Solution {
    boolean solution(String s) {
        boolean answer = false;
        char[] chars = s.toCharArray();
        if (chars[0] == ')') return false;
        Queue tmp = new LinkedList<>();
        try {
            for (char index : chars) {
                if (index == '(') {
                    tmp.offer(1);
                }
                if (index == ')'){
                    tmp.remove();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }

        if (tmp.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
