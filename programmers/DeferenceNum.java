import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DeferenceNum {
   
    public static void main(String[] args) 
    {    
        int arr[] = {1,1,3,3,0,1,1};
        List<Integer> arrayList =  new ArrayList<>();
        int temp = arr[0];
        arrayList.add(temp);
        for(int i = 1; i< arr.length; ++i) {
            if(arr[i] == temp) {
                continue;                
            }
            else {
                temp = arr[i];
                arrayList.add(temp);
            }
        }
        int listSize = arrayList.size();
        int[] answer = new int[listSize];
        for(int i =0; i < listSize; ++i) {
            answer[i] = arrayList.get(i);
        }
        System.out.println(answer);
        
    }


}
