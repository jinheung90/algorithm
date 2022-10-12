import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.*;

class Point implements Comparable<Point>{
    private int x = 0;
    private int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x && this.y == o.y) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class PuzzlePiece {
    private final HashSet<Point> points = new HashSet<>();

    public HashSet<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {

        System.out.println("points");
        for (Point point: points
        ) {

            System.out.println(point.toString());
        }


        return "PuzzlePiece{" +
                "points=" + points +
                '}';
    }
}

public class FillThePuzzle {
    public static List<PuzzlePiece> emptySpace = new ArrayList<>();
    public static List<PuzzlePiece> puzzlePieces = new ArrayList<>();

    public static void main(String[] args) {
        int[][] game_board = {
            {1,1,0,0,1,0},
            {0,0,1,0,1,0},
            {0,1,1,0,0,1},
            {1,1,0,1,1,1},
            {1,0,0,0,1,0},
            {0,1,1,1,0,0}
        };

        int[][] table = {
            {1,0,0,1,1,0},
            {1,0,1,0,1,0},
            {0,1,1,0,1,1},
            {0,0,1,0,0,0},
            {1,1,0,1,1,0},
            {0,1,0,0,0,0}
        };

        boolean[][] game_board_visit = new boolean[game_board.length][game_board.length];
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board_visit.length; j++) {
                if(game_board_visit[i][j] || game_board[i][j] == 1) {
                    continue;
                }
                PuzzlePiece puzzlePiece = new PuzzlePiece();
                getEmptySpaces(game_board, puzzlePiece, j , i,game_board_visit, 1);
                emptySpace.add(puzzlePiece);
            }
        }

        game_board_visit = new boolean[game_board.length][game_board.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(game_board_visit[i][j] || table[i][j] == 0) {
                    continue;
                }
                PuzzlePiece puzzlePiece = new PuzzlePiece();
                getEmptySpaces(table, puzzlePiece, j , i,game_board_visit, 0);
                puzzlePieces.add(puzzlePiece);
            }
        }


        emptySpace.toString();
        System.out.println(emptySpace.size());
        puzzlePieces.toString();
    }

    public static void getEmptySpaces(int[][] game_board,  PuzzlePiece emptySpace, int rx, int ry, boolean[][] game_board_visit, int flag) {
        System.out.println(rx);
        System.out.println(ry);
        if(game_board_visit[ry][rx] || game_board[ry][rx] == flag) {
            return;
        }
        game_board_visit[ry][rx] = true;
        emptySpace.getPoints().add(new Point(rx, ry));
        if(rx > 0) {
            getEmptySpaces(game_board, emptySpace, rx - 1, ry, game_board_visit, flag);
        }
        if(rx < game_board.length - 1) {
            getEmptySpaces(game_board, emptySpace, rx + 1, ry, game_board_visit, flag);
        }
        if(ry > 0) {
            getEmptySpaces(game_board, emptySpace, rx, ry - 1, game_board_visit, flag);
        }
        if(ry < game_board.length - 1) {
            getEmptySpaces(game_board, emptySpace, rx, ry + 1, game_board_visit, flag);
        }
    }
}
