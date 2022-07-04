import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ColoringBook {

    public static int maxArea = 0;
    public static int currentArea = 0;

    public static void move(long[][] arrayImg, int x, int y, long startColor) {
        if(arrayImg[y][x] == 0 || arrayImg[y][x] != startColor) { // 색칠 안되있음
            return;
        }
         
        currentArea++; // 현재 영역 증가
        // 이것좀 위에 올리자 안올리니까 스택 오버플로우 즉 무한 루프 돈다
        arrayImg[y][x] = 0; // 색칠한것 지우기
        
        // 영역 밖 체크
        if(x + 1 < arrayImg[0].length) { // 
            move(arrayImg, x + 1, y, startColor);
        }

        if(y + 1 <  arrayImg.length) {
            move(arrayImg, x , y + 1, startColor);
        }      
        
        if(x  > 0) { // 
            System.out.println(x - 1);
            move(arrayImg, x - 1, y, startColor);
        }

        if(y  > 0) {
            move(arrayImg, x , y - 1, startColor);
        }        

      
    }
    

    public static void main(String[] args) 
    {    

        int[][] picture = {
            {1, 1, 1, 0},
            {1, 2, 2, 0}, 
            {1, 0, 0, 1}, 
            {0, 0, 0, 1}, 
            {0, 0, 0, 3}, 
            {0, 0, 0, 3}
        };
       
        
        int m = 6;
        int n = 4;
        maxArea = 0;
        currentArea = 0;
        int areaCount = 0;
        
        // 2^31 - 1 자료형 함정
        long [][]copy = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = picture[i][j];
            }
        }
      
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if(copy[y][x] != 0) {
                    move(copy, x, y, copy[y][x]);
                    areaCount++;
                    if(maxArea < currentArea) {
                        maxArea = currentArea;
                        
                    }
                    
                    currentArea = 0;
                }
            }
        }
        int rs[] = {areaCount, maxArea};
        System.out.println(rs[0]);
        System.out.println(rs[1]);
    }

}
