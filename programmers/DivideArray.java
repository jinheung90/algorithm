import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivideArray {
    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        Arrays.sort(arr);
        List<Integer> iList = new ArrayList<>();
        for(int i =0; i < arr.length; ++i) {
            if(arr[i] % divisor != 0) {
                continue;
            }
            iList.add(arr[i]);
        }

        if(iList.isEmpty()) {
            int[] answer = {-1};
            //return answer;
        }

        int[] answer = new int[iList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = iList.get(i);
        }
        
        //return answer;

    }
}
