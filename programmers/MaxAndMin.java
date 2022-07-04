import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class MaxAndMin {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4 ";
        StringTokenizer stk = new StringTokenizer(s, " ");
        List<Integer> list = new ArrayList<>();
        
        while(stk.hasMoreTokens()) {
            list.add(Integer.parseInt(stk.nextToken()));
        }
        Collections.sort(list);
        //return list.get(0) + " " + list.get(list.size() - 1);
        System.out.println(list.get(0) + " " + list.get(list.size() - 1));
    }
}
