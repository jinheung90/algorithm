public class Fibonacci {
    public static void main(String[] args) {
        int pp = 0;
        int p = 1;
        int current = 0;
        int n = 200000;
        for(int i = 1; i <= n - 1; i++) {
            current = (pp + p) % 1234567;
            pp = p;
            p = current;
        }

    }
}
