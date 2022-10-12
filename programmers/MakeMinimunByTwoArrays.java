import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MakeMinimunByTwoArrays {
    public static void main(String[] args) {
        int A[] = {1,4,2};
        int B[] = {5,4,4};
        Arrays.sort(A);
        Arrays.sort(B);
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += A[i] * B[B.length - 1 - i];
        }
    }
}
