import java.util.*;
//재귀 폴더구조 만들기
public class testA {
   public static TreeSet<Integer> results = new TreeSet<>();
   public static HashMap<Integer, ArrayList<Integer>> dataMap = new HashMap<>();
   static ArrayList<Integer> nameLength = new ArrayList<Integer>();
    public static void main(String[] args) {
        String dirname[] = new String[1];
        int[][] relation = new int[0][];


        for(int i = 0; i < dirname.length; ++i) {
            nameLength.add(dirname[i].length());
        }
        for(int i =0 ; i < relation.length; ++i) {
            ArrayList<Integer> list = dataMap.get(relation[i][0]);
            if(list == null) {
                dataMap.put(relation[i][0],  new ArrayList<Integer>());
                list = dataMap.get(relation[i][0]);
            }
            list.add(relation[i][1]);
        }

        next(dataMap, 1, nameLength, 0);
//        results.last() - 1;
    }

    public static void next(HashMap<Integer, ArrayList<Integer>> dataMap,int next,  ArrayList<Integer> nameLength, int nextMove) {
        ArrayList<Integer> list = dataMap.get(next);
        nextMove += nameLength.get(next - 1) + 1;
        if(list == null || list.isEmpty()) {
            results.add(nextMove);
            return;
        }
        for (Integer i: list) {
            next(dataMap, i, nameLength, nextMove);
        }
    }

}
