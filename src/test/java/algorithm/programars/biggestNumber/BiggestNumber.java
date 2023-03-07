package algorithm.programars.biggestNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
* 문제 설명
* 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
*
* 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.
*
* 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
*
* 제한 사항
* numbers의 길이는 1 이상 100,000 이하입니다.
* numbers의 원소는 0 이상 1,000 이하입니다.
* 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
* 입출력 예
* numbers	return
* [6, 10, 2]	"6210"
* [3, 30, 34, 5, 9]	"9534330"
* */

public class BiggestNumber {

    @Test
    void solution_Test(){
        int [] numbers = new int[]{6, 10, 2};
        int [] numbers1 = new int[]{3, 30, 34, 5, 9};
        Solution solution = new Solution();

        String answer = solution.solution(numbers);
        String answer1 = solution.solution(numbers1);

        Assertions.assertEquals("6210",answer);
        Assertions.assertEquals("9534330",answer1);

    }
}
class Solution {

    private int getNumberDigit(int number){

        int count = 0;
        while ( number > 0) {
            number /= 10;
            count ++;
        }
        return count;
    }

    public String solution(int[] numbers) {
        int length = numbers.length;
//        List<NumberNode> nodeList = new ArrayList<>();
        NumberNode[] nodeList = new NumberNode[length];

        for (int i = 0; i < length; i++) {
            NumberNode numberNode= new NumberNode();
            numberNode.setValue(numbers[i]);
            numberNode.setNumberOfDigits(this.getNumberDigit(numbers[i]));
            nodeList[i] = numberNode;
        }

        for (int pin = 0; pin < length; pin++) {
            for (int pointer = pin + 1; pointer < length; pointer++) {
                if (nodeList[pin].getValue() < nodeList[pointer].getValue()
                        && nodeList[pin].getNumberOfDigits() == nodeList[pointer].getNumberOfDigits()){
                    NumberNode tmp = nodeList[pin];
                    nodeList[pin] = nodeList[pointer];
                    nodeList[pointer] = tmp;

                }
                if (nodeList[pin].getNumberOfDigits() != nodeList[pointer].getNumberOfDigits()) {

                    if (nodeList[pin].getNumberOfDigits() // 779 , 3
                            > nodeList[pointer].getNumberOfDigits()// 7 ,1
                    ){
                        int count = nodeList[pin].getNumberOfDigits() - nodeList[pointer].getNumberOfDigits();

                            StringBuilder targetNumber = new StringBuilder(String.valueOf(nodeList[pointer].getValue()));

                        for (int i = 0; i < count; i++) {
                            targetNumber.append(targetNumber);
                        }

                        int pointerNumber = Integer.valueOf(targetNumber.toString());
                        System.out.println("pointerNumber : " + pointerNumber);
                        System.out.println("nodeList[pin].getValue() : " + nodeList[pin].getValue());
                        if (nodeList[pin].getValue() < pointerNumber){
                            NumberNode tmp = nodeList[pin];
                            nodeList[pin] = nodeList[pointer];
                            nodeList[pointer] = tmp;
                        }
                        pointer ++;
                    }

                } else {
                    pointer ++;
                }
            }
        }

        for (int i = 0; i < nodeList.length; i++) {
            System.out.println(nodeList[i].getValue());
        }
            StringBuilder answer = new StringBuilder();
        for (int i = 0; i < nodeList.length; i++) {
            answer.append(nodeList[i].getValue());
        }
        return answer.toString();
    }
}

class NumberNode{
    private int value;
    private int numberOfDigits;

    public int getNumberOfDigits() {
        return numberOfDigits;
    }

    public int getValue() {
        return value;
    }

    public void setNumberOfDigits(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public void setValue(int value) {
        this.value = value;
    }
}