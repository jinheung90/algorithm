import java.util.ArrayList;
import java.util.List;;
public class GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4, 5};
        int[] reserve = {1,3,5};
        //4번 조건 lost랑 reserve랑 같이 있으면 빌려줄 수 없고 본인은 가지고 있는것이다 없는 사람 취급하면 됨
        int answer = 0; 
        int case4 = 0;
        List<Integer> lostList = new ArrayList<>();
        for(int i =0 ; i < lost.length; ++i) {
            for(int j =0 ; j < reserve.length; ++j) {
                if(lost[i] == reserve[j]) {
                    reserve[j] = -1;
                    lost[i] = -10;
                    case4++;
                    break;
                }
            }
        }
        
        for(int i =0 ; i < lost.length; ++i) {
            for(int j =0 ; j < reserve.length; ++j) {
                if(reserve[j] == (lost[i] - 1)) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
                if(reserve[j] == (lost[i] + 1)) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }  
        }   
        System.out.println(answer + n - lost.length + case4);
    }
}
