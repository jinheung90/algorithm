import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

class TestPoint {
    private int id;
    private int point;

    public TestPoint(int id, int point) {
        this.id = id;
        this.point = point;
    }

    @Override
    public boolean equals(Object obj) {
        TestPoint converted = (TestPoint) obj;
        if(this.id == converted.id && converted.point == this.point) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}


public class testB {

    public static int maxArea = 0;
    public static int currentArea = 0;
    public static final int PAGE_NUM_INDEX = 2;
    public static final int PAGE_REQUEST_INDEX = 1;
    public static void main(String[] args) {
        String[] logs = new String[20];
        String[][] parsedData = new String[logs.length][3];
        HashMap<String, TreeSet<TestPoint>> logMap = new HashMap<>();
        TreeSet<String> resultSet = new TreeSet<>(Comparator.naturalOrder());
        Comparator<TestPoint> comp = (TestPoint o1,TestPoint o2) -> {
            if(o1.getId() > o2.getId()) { // 대기중인 페이지 수가 적은것 부터 앞으로
                return 1;
            } else return -1;
        };

        for (int i = 0; i < logs.length; i++) {
            String[] temp = logs[i].split(" ");
            TreeSet<TestPoint> set = logMap.computeIfAbsent(temp[0], k -> new TreeSet<>(comp));
            set.add(new TestPoint(Integer.valueOf(temp[1]), Integer.valueOf(temp[2])));
        }

        logMap.entrySet().removeIf(e -> {
            if(e.getValue().size() < 5) {
                return true;
            }
            return false;
        });
        List<String> keys = new ArrayList<>(logMap.keySet());
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.size(); j++) {
                if(i == j) {
                    continue;
                }
                List<TestPoint> a = logMap.get(keys.get(i)).stream().collect(Collectors.toList());
                List<TestPoint> b = logMap.get(keys.get(j)).stream().collect(Collectors.toList());
                if(a.size() != b.size()) {
                    continue;
                }
                boolean same = true;
                for (int k = 0; k < a.size(); k++) {
                    if(a.get(k).getId() != b.get(k).getId() || a.get(k).getPoint() != b.get(k).getPoint()) {
                        same = false;
                        continue;
                    }
                }
                if(same) {
                    resultSet.add(keys.get(i));
                    resultSet.add(keys.get(j));
                }
            }
        }
        String[] result = new String[resultSet.size()];
        List<String> list = new ArrayList<>(resultSet);
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
    }

}
