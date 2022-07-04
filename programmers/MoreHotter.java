import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
// 더 맵게
public class MoreHotter {
    public int solution(int[] scoville, int K) {
        Queue<Integer>  queue= new PriorityQueue<Integer>();
        for(int i =0; i < scoville.length; ++i) {
            queue.offer(scoville[i]);
        }
        
        int ms1 = 0;
        int ms2 = 0;
        int temp = 0;
        int count = 0;
        while(queue.peek() < K) {
            if(queue.size() == 1) return -1;
            ms1 = queue.poll();
            ms2 = queue.poll();
            temp = ms1 +  2 * ms2;
            queue.offer(temp);
            count++;
 

          
        }
        

        return count;
    }
}
