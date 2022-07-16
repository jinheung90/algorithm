
import java.util.*;

public class GameMapShortestDist {

    public static class Position {
        private int x,y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    private static TreeSet<Integer> visit = new TreeSet<>(Comparator.reverseOrder());
    private static LinkedList<Position> pos = new LinkedList<>();
    public static void main(String[] args) {
        int[][] map = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}};
        int node = 0;
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(0);

        while (!list.isEmpty()) {
            node = list.peek();
            if(visit.contains(node) ) {
                continue;
            }
            System.out.println();
            for (int i = 0; i < 5; i++) {
                if(map[node][i] == 1) {
                    list.addFirst(i);
                }
            }
       }


    }
}
