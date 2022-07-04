
// 일단 0번 확정실행
// 그 다음에 0번이 실행된 사이의 것에 실행할 수 있는 것들을 찾는다
// 그리고 여기서 가장 실행시간이 적은것을 찾는다
// ex 0,3  1,9  2,8  3,3  4,2  5,8  8,2 이렇게 있다면
// 1, 9와 2, 8, 3, 3를 뽑고 
// 거기서 9, 8, 3을 비교해서 
// 가장 실행시간이 적게걸리는 3,3을 실행시키고 
// 다시 0에서 6사이중 작은거를 한다 이것을 무한반복

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
class DiskController {
    public int solution(int[][] jobs) {
       Queue<int[]> queue2 = new PriorityQueue<>(
               (a, b) -> a[0] >= b[0] ? 1 : -1);
        for (int[] is : jobs) {
            queue2.offer(is);
        }
        Queue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] >= b[1] ? 1 : -1);



        int time = 0;
        int start = 0;
        int[] temp = null;
        System.out.println("----------------------");
        System.out.println("while1");
        System.out.println(queue2.size());
        while(true) {
            System.out.println("----------------------");
            System.out.println("queue2.size()");
            System.out.println(queue2.size());
            if(!queue2.isEmpty()){ 
                temp = queue2.peek();

                if(temp[0] <= start) {
                    System.out.println("temp[0] <= start");
                    System.out.println(temp[0]);
                    System.out.println(start);
                    System.out.println(queue2.size());
                    queue2.poll();
                    queue.offer(temp);
                    continue;
                } 
            }

            if(queue.isEmpty()) { 
                start = temp[0];
                continue;
            }

            temp = queue.poll();
            time +=  start- temp[0] + temp[1];
            start += temp[1];     
            System.out.println(start);
            System.out.println(time);
            if(queue.isEmpty() && queue2.isEmpty()) {
                break;
            }

        }

        System.out.println("----------------------");
        System.out.println("end");
        System.out.println(time);
        System.out.println(Math.ceil(time / jobs.length));

        return (int)(time / jobs.length);
    }

}