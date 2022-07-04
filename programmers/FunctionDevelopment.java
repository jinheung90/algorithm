import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.Map;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

// 프로그래머스 기능개발
public class FunctionDevelopment {
    static int getDay(int progress, int speed) {

        int leftPorgress =  (100 - progress);
        int day = leftPorgress / speed ;
            if(leftPorgress % speed != 0)
                day++;
        return day;
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        int currentDay = getDay(progresses[0],speeds[0]);

        LinkedList<Integer> store = new LinkedList<Integer>();
        int size = progresses.length;
        store.addFirst(1);
        for(int i =1; i < size; ++i) {
           int day = getDay(progresses[i],speeds[i]);
           if(currentDay >= day)
               store.addLast(store.removeLast() + 1);
           else { 
               store.addLast(1);
               currentDay = day;
           }
        }

        int intStore[] = new int[store.size()];

        for(int i =0; i < store.size(); ++i) {
            intStore[i] = store.get(i);
        }
        return intStore;
    }
}
