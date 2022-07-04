import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class MakeBigNum {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        ArrayList<String> strList = new ArrayList<>();
        int isZero = 0; 
        for (int i : numbers) {
            if(i != 0)  {
                isZero = 1;
                break;
            } 
        }
        
        if(isZero == 0) {
            String rs = "0";
        }
        
        for (int i : numbers) {
            strList.add(String.valueOf(i));
        }
       
        
        
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                if(a.charAt(0) == b.charAt(0)) {
                    int aSize = a.length();
                    int bSize = b.length();
                    int minMulti = aSize * bSize;
                    String tempA ="";
                    String tempB = "";
                    for (int i = 0; i < bSize; i++) {
                        tempA += a;        
                    }
                    for (int i = 0; i < aSize; i++) {
                        tempB += b;        
                    }
                    return tempB.compareTo(tempA);
                }       
                return b.compareTo(a);

            }
        });
        String rs = "";
        for (String string : strList) {
            rs += string;
        }
        System.out.println(rs);
     
    }
}