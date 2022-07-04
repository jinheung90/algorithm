import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
public class SortByCharAt {
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        

        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n) > o2.charAt(n)) {
                    return 1;
                }
                else if(o1.charAt(n) > o2.charAt(n)) {
                    return o1.compareTo(o2);
                }
                else {
                    return -1;
                }
            }
        });
    }
}
