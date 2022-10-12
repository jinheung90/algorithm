import java.util.*;

public class NumberPartner {
    public static void main(String[] args) {
        String x = "42331111156235626634624673124512356234622323462322462424623463557345734563456534634563466246234";
        String y = "5323463467347345734573456345346345234246511111114357458745873453213463453453463463";
        int[] storeX = new int[10];
        int[] storeY = new int[10];
        for (int i = 0; i < x.length(); i++) {
            final int num = x.charAt(i) - '0';
            storeX[num]++;
        }
        for (int i = 0; i < y.length(); i++) {
            final int num = y.charAt(i) - '0';
            storeY[num]++;
        }
        int checkAnyMatch = 0;
        for (int i = 0; i < 10; i++) {
            int min = Math.min(storeX[i],storeY[i]);
            storeX[i] = min;
            System.out.print(storeX[i]);
            if(storeX[i] == 0) {
                checkAnyMatch++;
            }

        }
        System.out.println(checkAnyMatch);


        System.out.println();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if(storeX[i] < 1) continue;
            stringBuffer.append(String.valueOf(i).repeat(Math.max(0, storeX[i])));
        }



        System.out.println(stringBuffer.toString());
    }
}
