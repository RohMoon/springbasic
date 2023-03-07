package algorithm.programars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Printer {

    @Test
    void printer_test() {
        int[] priorities1 = new int[]{2, 1, 3, 2};
        int[] priorities2 = new int[]{1, 1, 9, 1, 1, 1};
//        int[] priorities3 = new int[]{1, 2, 9, 5, 4, 7, 7, 8, 1, 2, 4,};
        int location1 = 2;
        int location2 = 0;
//        int location3 = 0;
        Solution2 solution = new Solution2();
        int answer = solution.solution2(priorities1, location1);
        int answer2 = solution.solution2(priorities2, location2);
//        int answer2 = solution.solution(priorities3, location3);

        Assertions.assertEquals(1, answer);
        Assertions.assertEquals(5, answer2);
    }
}

/**
 * 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
 * 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
 * location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
 */


class Solution2 {
    public int solution2(int[] priorities, int location) {
        int length = priorities.length;
        int maxIndex = priorities.length - 1;
       Document2 [] tmpArray = new Document2[length];
       Document2 [] documentArray = new Document2[length];
        int tmpArrayIndex = 0 ;

        for (int i = 0; i < length; i++) {
            Document2 document = new Document2(i, priorities[i]);
            documentArray[i] = document;
        }

        for (int i = 0; i < length; i++) {
            Document2 document = new Document2();
            tmpArray[i] = document;
        }

        for (int docmentArrayIndex = 0; docmentArrayIndex < length; docmentArrayIndex++) {

            for (; tmpArrayIndex < length ;) {

              if (documentArray[docmentArrayIndex].getPriority() <= tmpArray[tmpArrayIndex].getPriority()){
//                  Document2 tempDocument = documentArray[0];
//
////                  for (int index = 0; index < length; index++) {
//                  for (int tempIndex = docmentArrayIndex; docmentArrayIndex < length; tempIndex++) {
//                      int nextIndexPointer = tempIndex +1;
//                      if (nextIndexPointer==length){
//                          break;
//                      }
//                      documentArray[tempIndex] = documentArray[nextIndexPointer];
//                  }
//                  documentArray[length-1] = tempDocument;
                  tmpArrayIndex++;
              }

                if (documentArray[docmentArrayIndex].getPriority() > tmpArray[tmpArrayIndex].getPriority()){

                    for (int tmpArrayTailRearPointer = maxIndex, tmpArrayTailFrontPointer = tmpArrayTailRearPointer - 1; tmpArrayTailFrontPointer > tmpArrayIndex -1; tmpArrayTailRearPointer--, tmpArrayTailFrontPointer--) {
                        tmpArray[tmpArrayTailRearPointer] = tmpArray[tmpArrayTailFrontPointer];
                    }

                    tmpArray[tmpArrayIndex] = documentArray[docmentArrayIndex];
                    tmpArrayIndex = 0;
                    break;
                }
            }
        }

                for (Document2 document : tmpArray) {
            System.out.println("document.getPriority() ::: " + document.getPriority());
        }
        System.out.println("------------------------");
                for (Document2 document : tmpArray) {
            System.out.println("document.getIndex() ::: " + document.getIndex());
        }
        System.out.println("------------------------");


        int answer = 0;

        for (int i = 0; i < tmpArray.length; i++) {
            if (tmpArray[i].getIndex() == location ){
                answer = i+1;
            }
        }

        return answer;
    }

}

class Document2 {
    private  int index = 0;
    private int priority = 0;

    public Document2(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public Document2() {
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}
