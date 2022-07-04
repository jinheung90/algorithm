import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class FindTwoAndAdd {

    // 착각한게 hashset은 순서를 정해주지 않는다 
    //Treeset은 정렬된 상태유지를 해준다 (레드블랙트리 구조)
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        Set<Integer> rs = new TreeSet<>();
        int numberSize = numbers.length;
        for(int i =0; i < numberSize; ++i) { 
            for(int j =i; j < numberSize; ++j) {
                if(i == j) continue;
                System.out.println(numbers[i] + numbers[j]);
                rs.add(numbers[i] + numbers[j]);
            } 
        }
      

        int[] answer = new int[rs.size()];
        int count =0;
        Iterator<Integer> it = rs.iterator();
        while(it.hasNext()) {
            answer[count++] = it.next();
        }
    }
}
