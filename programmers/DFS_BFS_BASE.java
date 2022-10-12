import java.util.*;
public class DFS_BFS_BASE {
    public static void main(String args[]){
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
//
        Scanner scanner = new Scanner(System.in);
        String line = "1 2";
        int A = line.charAt(0) - '0';
        int B = line.charAt(2) - '0';
        System.out.println(B);
//        int n = scanner.nextInt();
//        int m = scanner.nextInt();
//        int v = scanner.nextInt();
        int[] input = {5, 4, 5, 2, 1, 2, 3, 4, 3, 1};
//        Boolean[] visit = new Boolean[n];
        int n = 5;
        int m = 5;
        int v = 3 - 1;
        for(int i = 0; i < n; ++i) {
            map.put(i, new TreeSet<>(Comparator.reverseOrder()));
        }
        for(int i = 0; i < input.length; i += 2) {

            TreeSet<Integer> listA = map.get(input[i] - 1);
            TreeSet<Integer> listB = map.get(input[i + 1] - 1);
            listA.add(input[i + 1] - 1);
            listB.add(input[i] - 1);

        }


        boolean[] visit = new boolean[n];

        //
//        for(int i = 0; i < m; ++i) {
//            List<Integer> list = map.get(scanner.nextInt() - 1);
//            if(list == null) {
//                list = new ArrayList<>();
//            }
//
//            list.add(scanner.nextInt() - 1);
//        }
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.push(v);
        List<Integer> resultList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int current = linkedList.pop();
            if(visit[current]) {
                continue;
            }
            resultList.add(current + 1);
            System.out.println(Arrays.toString(resultList.toArray()));
            visit[current] = true;
            TreeSet<Integer> nextList = map.get(current);
            for (int i : nextList
                 ) {
                System.out.println(i);
                linkedList.push(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i : resultList
             ) {
            stringBuilder.append(i).append(" ");
        }
        System.out.println();
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);

        linkedList.push(v);
        visit = new boolean[n];
        resultList = new ArrayList<>();
        while (!linkedList.isEmpty()) {
            int current = linkedList.poll();
            if(visit[current]) {
                continue;
            }
            resultList.add(current + 1);
            visit[current] = true;
            TreeSet<Integer> nextList = map.get(current);
            Iterator<Integer> iterator = nextList.descendingIterator();
            while (iterator.hasNext()) {
                linkedList.addLast(iterator.next());
            }
        }
        stringBuilder =  new StringBuilder();
        for (int i : resultList
        ) {
            stringBuilder.append(i);
            stringBuilder.append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        System.out.println(stringBuilder);
    }
}
