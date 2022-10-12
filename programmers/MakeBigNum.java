import java.util.*;

public class MakeBigNum {

    public static class Point implements Comparable<Point> {
        public int i = -1;
        public int value = -1;

        @Override
        public int compareTo(Point o) {
            return Integer.compare(value, o.value);
        }
    }
    public static void main(String[] args) {
        String number = "4177252841346345735784584524623473252346234672346347345634634653463463453453455345346734734563463456363463473473474573457346585645632452341235136363467346345346347347347347316713724352356";
        int k = 100;
        StringBuilder stringBuilder = new StringBuilder(number);

        int count = 0;
        while (count < k) {
            int minValue = stringBuilder.charAt(0) - '0';

            int minIdx = 0;
            int i = 0;
            int whileCount = k;
            if(stringBuilder.length() < k) {
                whileCount =stringBuilder.length();
            }

            while (i < whileCount) {
                int tempNum = stringBuilder.charAt(i) - '0';
                if(minValue > tempNum) {
                    minValue = tempNum;
                    minIdx = i;
                }
                i++;

            }
            stringBuilder.deleteCharAt(minIdx);
            System.out.println(stringBuilder);
            count++;
        }

        System.out.println(stringBuilder.toString());
    }
}