import java.util.List;

public class SubArray {



    public static void main(String[] args) {

        long right = 5;
        long left = 2;
        int n = 3;
        int[] result = new int[(int) (right - left + 1)];
        long length = right - left;
        for (int i = 0; i <= length; i++) {
            long pos = i + left;
            long y = pos / n;
            long x = pos % n;
            long value = Math.max(x, y) + 1;
            result[i] = (int)value;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
