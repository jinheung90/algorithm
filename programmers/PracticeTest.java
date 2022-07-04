import java.util.Arrays;
import java.util.Collections;

public class PracticeTest {
    public static void main(String[] args) {
        //int[] answers = {1,2,3,4,5};
        int[] answers = {1,3,2,4,2,2,3,4,1,5,4,2,1};
        //1,2,3,4,5
        //2,1,2,3,2,4,2,5,
        //3,3,1,1,2,2,4,4,5,5
        int hit1 = 0;
        int hit2 = 0;
        int hit3 = 0;
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {2,1,2,3,2,4,2,5};
        int[] array3 = {3,3,1,1,2,2,4,4,5,5};
        
        for(int i =0; i < answers.length; ++i) {
            if(answers[i] == array1[i % array1.length]) {
                hit1++;
            }
            if(answers[i] == array2[i % array2.length]) {
                hit2++;
            }
            if(answers[i] == array3[i % array3.length]) {
                hit3++;
            }
        }
          
        if(hit1 > hit2) {
            if(hit1 == hit3) {
              
               int[] answer = new int[2];
                answer[0] = 1;
                answer[1] = 3;
                System.out.println(Arrays.toString(answer));
            }
            if(hit1 > hit3) {
                
                int[]   answer = new int[1];
                answer[0] = 1;
                System.out.println(Arrays.toString(answer));
            }
        }

        if(hit2 > hit3) {
            if(hit2 == hit1) {
                int[] answer = new int[2];
                answer[0] = 1;
                answer[1] = 2;
                System.out.println(Arrays.toString(answer));
            }
            if(hit2 > hit1) {
                int[] answer = new int[1];
                answer[0] = 2;
                System.out.println(Arrays.toString(answer));
            }
        }

        if(hit3 > hit1) {
            if(hit3 == hit2) {
                int[]  answer = new int[2];
                answer[0] = 2;
                answer[1] = 3;
                System.out.println(Arrays.toString(answer));
            }
            if(hit3 > hit2) {
                int[]  answer = new int[1];
                answer[0] = 3;
                System.out.println(Arrays.toString(answer));
            }
            if(hit2 > hit3) {
                int[]  answer = new int[1];
                answer[0] = 2;
                System.out.println(Arrays.toString(answer));
            }
        }

        if(hit3 == hit2 & hit2 == hit1) {
            int[]  answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
            System.out.println(Arrays.toString(answer));

        }
        

        

    }
}
