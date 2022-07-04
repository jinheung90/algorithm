import java.util.HashSet;
import java.util.Set;

public class MakePrimeNum {
    public static void main(String[] args) {
        int[] nums ={8,1,2,3,6,7};
        int answer = 0;
        boolean isTrue = false;
        
  
        int count =0;
        for(int i =0; i < nums.length - 2; ++i) {
             for(int j = i + 1; j < nums.length - 1; ++j) {
                for(int m = j + 1; m < nums.length; ++m) {
                    isTrue = false;
                    int n = nums[i] + nums[j] + nums[m];
                   
                    System.out.println(n);
                    for(int k = 2; k * k <= n; ++k) {
                        if(n % k == 0) {
                            isTrue = true;
                            break;
                        }            
                    }
                    if(!isTrue) {
                        System.out.println("true");
                        count++;
                    }
            
                }
            }
        }
        System.out.println(count);
       
        
    }
}
