
import java.util.*;

public class GameMapShortestDist {
    private static TreeSet<Integer> visit = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) {
        int[][] map = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        };
        int node = 0;
        final int length = 5 * 5;
        final int maxLow = 5;
        final int maxCol = 5;
        int count = 0;

        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(0);

        while (!list.isEmpty() || count < 100) {

            count ++;
            node = list.peekFirst();

            if(visit.contains(node)) {
                continue;
            }

            visit.stream().forEach(integer -> System.out.println(integer));

            int low = node / maxLow;
            int col = node % maxLow;

            if(low == 4 && col == 4) {
                break;
            }

            for (int i = 0; i < length; i++) {

                if(low + 1 <= 4 && map[low + 1][col] == 1) {
                    list.addLast((low + 1) * maxLow + col);
                }

                if(col + 1 <= 4 &&  map[low][col + 1] == 1) {
                    list.addLast((low) * maxLow + col + 1);
                }

                if(low - 1 > 0 && map[low - 1][col] == 1) {
                    list.addLast((low - 1) * maxLow + col );
                }

                if(col -1 > 0 && map[low][col - 1] == 1) {
                    list.addLast(low * maxLow + col - 1);
                }
            }

        }
    }
}
