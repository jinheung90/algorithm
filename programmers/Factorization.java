import java.util.*;
import java.util.stream.Collectors;

public class Factorization {
    public static void main(String[] args) {
        int result = 0;
        int n = 123;
        for(int i = 2; i <  Math.sqrt(n); i++) {	// 또는 i * i <= N
            while(n % i == 0) {
                result += i;
            }
        }


    }
}
