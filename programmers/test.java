import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class test {

    public static int maxArea = 0;
    public static int currentArea = 0;
    public static final int PAGE_NUM_INDEX = 2;
    public static final int PAGE_REQUEST_INDEX = 1;
    public static void main(String[] args) {
        int[][] data =
                {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};

        Comparator<int[]> comp = (int[] o1, int[] o2) -> {
            if(o1[PAGE_NUM_INDEX] > o2[PAGE_NUM_INDEX]) { // 대기중인 페이지 수가 적은것 부터 앞으로
                return 1;
            } else if(o1[PAGE_NUM_INDEX] < o2[PAGE_NUM_INDEX]) {
                return -1;
            } else { // 대기중인 페이지 수가 같은경우
                // 먼저 요청한 페이지 부터
                return Integer.compare(o1[PAGE_REQUEST_INDEX],o2[PAGE_REQUEST_INDEX]);
            }



        };
        TreeSet<int[]> docQueue = new TreeSet<>(comp);
        TreeSet<Integer> temp = new TreeSet<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        int timeStart = 0;
        int timeEnd = 0;
        docQueue.add(data[0]);
        timeStart = data[0][PAGE_REQUEST_INDEX];
        timeEnd = timeStart + data[0][PAGE_NUM_INDEX];
        resultList.add(data[0][0]);
        int iCount = 0;
        while (iCount < data.length) {
            iCount++;
            if(data[iCount][PAGE_REQUEST_INDEX] <= timeEnd) { // 작거나 같다 인데 이게 요구사항이 먼저 대기열에 넣고라고했으므로 같다가 맞음
                docQueue.add(data[iCount]);
            } else { // 크면 대기열에 있던 데이터를 모두 결과에 넣어준다
                resultList.addAll(docQueue.stream().map(t -> t[0]).collect(Collectors.toList()));
                System.out.println((data[iCount][PAGE_REQUEST_INDEX]));
                docQueue.add(data[iCount]);
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        System.out.println(result);
    }
}
