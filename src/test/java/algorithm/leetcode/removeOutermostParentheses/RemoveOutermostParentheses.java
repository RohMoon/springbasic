package algorithm.leetcode.removeOutermostParentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class RemoveOutermostParentheses {


    @Test
    void solution_Test(){
        String s = "(())(())";
        String s1 = "(()())(())";
        String s2 = "(()())(())(()(()))";
        String s3 = "()()";
//        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();
//        String answer = solution.removeOuterParentheses(s);
//        String answer1 = solution.removeOuterParentheses(s1);
//        String answer2 = solution.removeOuterParentheses(s2);
//        String answer3 = solution.removeOuterParentheses(s3);
        String answer4 = solution2.removeOuterParentheses(s);

//        Assertions.assertEquals(answer, "");
//        Assertions.assertEquals(answer1, "()()()");
//        Assertions.assertEquals(answer2, "()()()()(())");
//        Assertions.assertEquals(answer3, "");
        Assertions.assertEquals(answer4,"()()");
    }

}

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char index : s.toCharArray()) {
            if (index == '(' && count++ > 0) {
            builder.append(index);
            }
            if (index == ')' && --count > 0) {
                builder.append(index);
            }
        }
        /*
        *    if(index == '(') {
                if(count > 0) s.append(c);
                count++;
            } else {
                if(count > 1) s.append(c);
                count--;
            }
        * */

        return builder.toString();
    }
}
class Solution2 {
    public String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();
        int open=0, close=0, start=0;
        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '(') {
                open++;
            } else if(S.charAt(i) == ')') {
                close++;
            }
            if(open==close) {
                sb.append(S.substring(start+1, i));
                start=i+1;
            }
        }
        return sb.toString();
    }
}

class Solution3 {
    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int f=0,l=0;
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
            if(stack.empty()){
                res.append(s.substring(f+1,i));
                f = i+1;
            }
        }
        return res.toString();
    }
}