package algorithm.programars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Printer2 {

    @Test
    void printer_test() {
        int[] priorities1 = new int[]{2, 1, 3, 2};
        int[] priorities2 = new int[]{1, 1, 9, 1, 1, 1};
        int[] priorities3 = new int[]{7,8,1,5,3,1,1}; // 8,1<,5,3,1,1,7    8,5,3,1,1,7,1<   8,3,1,1,7,1<,5  8,1,1,7,1<,5,3   8,1,7,1<,5,3,1  8,7,1<,5,3,1,1  8,7,5,3,1,1,1<
        int location1 = 2;
        int location2 = 0;
        int location3 = 2;
        Solution solution = new Solution();
        int answer = solution.solution(priorities1, location1);
        int answer2 = solution.solution(priorities2, location2);
        int answer3 = solution.solution(priorities3, location3);

        Assertions.assertEquals(1, answer);
        Assertions.assertEquals(5, answer2);
        Assertions.assertEquals(7, answer3);
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int length = priorities.length;
        Document [] documentArray = new Document[length];


        int answer = 0;

        for (int i = 0; i < length; i++) {
            Document document = new Document(i, priorities[i]);
            documentArray[i] = document;
        }

            for (int documentArrayIndex = 0; documentArrayIndex < length; documentArrayIndex++) {
                System.out.println("count" + documentArrayIndex);
                Document maxPriorityDocument = new Document();
                /*max 구하기*/
                for (int i = documentArrayIndex; i < length; i++) {
                    if (documentArray[i].getPriority() > maxPriorityDocument.getPriority()) {
                        maxPriorityDocument = documentArray[i];
                        System.out.println("maxPriorityDocument.getPriority() ::: " + maxPriorityDocument.getPriority());
                    }
                } // max 구했다.

                if (documentArray[documentArrayIndex].getPriority() < maxPriorityDocument.getPriority()) {

                    while (maxPriorityDocument.getIndex() != documentArray[documentArrayIndex].getIndex()) {

                        Document tempDocument = documentArray[documentArrayIndex];

                        for (int index = documentArrayIndex; index < length; index++) {
                            int nextIndexPointer = index +1;
                            if (nextIndexPointer==length){
                            break;
                            }
                        documentArray[index] = documentArray[nextIndexPointer];
            }
            documentArray[length-1] = tempDocument;
                    }
                }
            }
//        while (maxPriorityDocument.getIndex() != documentArray[0].getIndex()){
//            Document tempDocument = documentArray[0];
//
//            for (int index = 0; index < length; index++) {
//                int nextIndexPointer = index +1;
//                if (nextIndexPointer==length){
//                    break;
//                }
//                documentArray[index] = documentArray[nextIndexPointer];
//            }
//            documentArray[length-1] = tempDocument;
//        }

        for (Document document : documentArray) {
            System.out.println("document.getPriority() ::: " + document.getPriority());
        }
        System.out.println("------------------------");
        for (Document document : documentArray) {
            System.out.println("document.getIndex() ::: " + document.getIndex());
        }
        System.out.println("------------------------");

        for (int i = 0; i < documentArray.length; i++) {
            if (documentArray[i].getIndex() == location ){
                answer = i +1;
            }
        }
        return answer;
    }

}

class Document {
    private  int index = 0;
    private int priority = 0;

    public Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    public Document() {
    }

    public int getIndex() {
        return index;
    }

    public int getPriority() {
        return priority;
    }
}