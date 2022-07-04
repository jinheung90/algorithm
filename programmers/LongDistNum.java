
import java.util.*;

class IdxPair {
    public int idx;
    public int depth;

    public IdxPair(int idx, int depth) {
        this.idx = idx;
        this.depth = depth;
    }

	public IdxPair() {
	}

}

public class LongDistNum {


    public static void main(String[] args) {
        
        int[][] edge = {
            {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        int n =6;
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            graph.add(new LinkedList<Integer>());
        }
           
        for(int i = 0; i < edge.length; ++i) {
            graph.get(edge[i][0] - 1).add(edge[i][1] - 1);
            graph.get(edge[i][1] - 1).add(edge[i][0] - 1);// 양방향
        }
        
        for(int i =0; i < n; ++i) {
            System.out.println("-------------------------");
            for(int j = 0; j <   graph.get(i).size(); ++j) {
               System.out.print(" "+ (graph.get(i).get(j)  + 1));
            }
            System.out.println();
        }
        boolean[] visit = new boolean[n];
        int[] depth = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
    
        LinkedList<Integer> tempList = null;
        
        
        visit[0] = true; // 시작지점 
        queue.addLast(0); // 시작을 넣고
        int count = 1;
        depth[0] = 1;
        while(!queue.isEmpty()) {
            System.out.println("-------queue-----------");
            System.out.println("-------------------------");
            for(int j = 0; j < queue.size(); ++j) {
                System.out.print(" "+ (queue.get(j) + 1));
            }
            System.out.println();
            
            int parent = queue.pollFirst(); // 노드 가져오고 
            tempList = graph.get(parent); // 그 노드의 인접리스트 가져오고
            int temp = 0;
            for(int j = 0; j < tempList.size(); ++j) {
                count = depth[parent];
                temp = tempList.get(j);
                if(!visit[temp]) { // 방문된 노드가 아니면 
                    queue.addLast(temp); // 넣고
                    visit[temp] = true; // 방문 체크
                    depth[temp] = ++count; // 뎁스 증가
                    System.out.println("-1111111-----------");
                    System.out.println(depth[temp]);
                    
                }
                count = 0;
            }
           
            
        }
        
        Arrays.sort(depth);
        int maxDist = depth[depth.length - 1];
        count = 0;
        for (int i = depth.length - 1; i >= 0 ; i--) {
            if(maxDist == depth[i]) {
                count++;
            }
        }
        System.out.println(count);
    } 
}
