import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isTrue = false;
        Set<Integer> temp = new HashSet<>();
        
        for(int i =2; i <= n; ++i) {
            isTrue = false;
            for(int j = 2; j * j <= i; ++j) {
                if(i % j == 0) {
                    isTrue = true;
                    break;
                }            
            }
            if(!isTrue) {
                answer++;
                //store.add(i);
            }
        }
       // System.out.println(store.toString());
        return answer;// store.size();
    }
}