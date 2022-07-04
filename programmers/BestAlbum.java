import java.util.PriorityQueue;
import java.util.Queue;
import java.util.List;
import java.util.Map;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;


// 프로그래머스 해시 베스트 앨범

class MusicInfo  {

    public int id;
    public int count;
    public MusicInfo(int id, int count) {
        this.id = id;
        this.count = count;
    }
    
    

}

class Pair<T1, T2> {
    private T1 t1;
    private T2 t2;

    public void setT1(T1 t1) {
        this.t1 = t1;
    }
    public void setT2(T2 t2) {
        this.t2 = t2;
    }

    public T1 getT1() {
        return this.t1;
    }
    public T2 getT2() {
        return this.t2;
    }
    
    public Pair(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }
}

public class BestAlbum {
    public static void main(String[] args) {

        
        String[] genres= {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Map<String, Pair<List<MusicInfo>, Integer>> map = new HashMap<>();
        for(int i =0; i < genres.length; ++i) {
            if(map.get(genres[i]) == null) {
                List<MusicInfo> musicInfos = new ArrayList<MusicInfo>();
                musicInfos.add(new MusicInfo(i, plays[i]));
                map.put(genres[i],new Pair<List<MusicInfo>, Integer>(musicInfos, plays[i]));
         
            }
            else {
                Pair<List<MusicInfo>, Integer> pair = map.get(genres[i]);
                pair.getT1().add(new MusicInfo(i, plays[i]));
                
                pair.setT2(pair.getT2() + plays[i]);

            }
        }    
        

        
        List<Map.Entry<String,  Pair<List<MusicInfo>, Integer>>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> { 

            return Integer.compare(o2.getValue().getT2(), o1.getValue().getT2()); // 재생을 모두 더한수 비교 
        });
        List<Integer> rs = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < entries.size(); ++i) {
            List<MusicInfo> temp = entries.get(i).getValue().getT1();
            Collections.sort(temp, new Comparator<MusicInfo>() {
                @Override 
                public int compare(MusicInfo o1, MusicInfo o2) {
                    if(o1.count > o2.count) {
                        return -1;
                    }
                    if(o1.count == o2.count) {
                        if(o1.id < o2.id) {
                            return -1;
                        }
                        else {
                            return 1;
                        }
                    }
                    else {
                        return 1;
                    }
            }});
            for(int j =0; j < temp.size(); ++j) {
                System.out.println(temp.get(j).id);
                rs.add(temp.get(j).id);
                if(j >= 1) {
                    break;
                }
            }
        }
        int[] returnInt = new int[rs.size()];
        for(int i =0; i < rs.size(); ++i) {
            returnInt[i] = rs.get(i);
        }
        
    }
    
    

    
}