import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
// 표준편차에 관한 문제

public class BestMultiSetNum {
    public static void main(String[] args) {
        int n = 5;
        int s = 20;
        int sd = s / 2;
        int sm = s % 2;
        int snd = n / s;
        int snm = n / s;
        int[] result;
        if(s < n) {
            result = new int[1];
            result[0] = 1;
        }

        result = new int[n];
        Arrays.fill(result, snd);
        for (int i = 0; i < snm; i++) {
            result[i] += 1;
        }

        Arrays.sort(result);




    }
}
