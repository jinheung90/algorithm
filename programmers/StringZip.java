import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StringZip {
    /*

    */

    public static void main(String[] args) {
        String s = "aabbaccc";
        int halfLength = s.length() /2;
        
        int length = s.length();
        List<Integer> rs = new ArrayList<>();
        int divider = 1;
        String pre = " ";
        String temp = " ";
        int sumCount = 0;
        int tempCount = 0;
        Set<Integer> st = new HashSet<>();
        
        while(divider <= halfLength) {
            for(int i =0; i < length - divider ; i += divider) {
           
              
                temp = s.substring(i, divider + i);
            
       
                System.out.println("------------------");
                System.out.println(temp);
                System.out.println(pre);
    
                if(pre.equals(temp)) {
                    System.out.println("yes");
                    tempCount += divider;
                } 
                else {
                    System.out.println("not");
                    sumCount += divider;
                    if(tempCount != 0) {
                        String strCount = tempCount + "";
                        sumCount += strCount.length();
                    }
                   
                    
                    tempCount = 0;
                }
    
                pre = temp;

            }
            System.out.println("------------------");
            System.out.println("------------------");
            System.out.println(sumCount);
            divider++;
            rs.add(sumCount);
            sumCount =0;
        }
        Collections.sort(rs);
        System.out.println(rs.get(0));
        System.out.println(rs.toString());
        // 12 -4
        
        
        /*
        while(divider < halfLength) {
            int count = 0;
         
         
            divider++;
            count++;
            
        }*/
        

    }
}
