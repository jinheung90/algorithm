import java.util.*;

public class EatTheGround {
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        int point = 0;
        int preIndex = -1;

        for (int i = 0; i < land.length; i++) {
            int max = land[i][0];
            int currentIdx = 0;

            for (int j = 1; j < 4; j++) {

                if(preIndex == j) {
                    continue;
                }
                if(max < land[i][j]) {
                    max = land[i][j];
                    currentIdx = j;
                }
            }
            preIndex = currentIdx;
            point += max;
        }
        System.out.println(point);
    }

}
