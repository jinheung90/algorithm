import java.util.*;
import java.util.stream.Collectors;

public class WordChange {
    public static HashSet<Integer> counts = new HashSet<>();
    public static void main(String[] args) {
         String begin = "hit";
         String target = "cog";
         String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        TreeMap<String,Set<String>> wordsTreeMap = new TreeMap<>();
        TreeMap<String,Boolean> visit = new TreeMap<>();

        wordsTreeMap.put(begin, new HashSet<>());
        visit.put(begin, false);
        for (String w: words
        ) {
            wordsTreeMap.put(w, new HashSet<>());
            visit.put(w, false);
        }
        wordsTreeMap.forEach((s, strings) -> {
            int deferenceCharCount = 0;
            for (String word : words) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) != word.charAt(j)) {
                        deferenceCharCount++;
                        if (deferenceCharCount >= 2) {
                            continue;
                        }
                    }
                }
                if (deferenceCharCount == 1) {
                    strings.add(word);
                }
                deferenceCharCount = 0;
            }
        });
        next(0, wordsTreeMap, visit, begin, target);
        if(counts.size() == 0) {
//            return 0;
        }
//        return counts.stream().sorted().collect(Collectors.toList()).get(0);
    }

    public static void next(int count, TreeMap<String,Set<String>> wordsTreeMap, TreeMap<String,Boolean> visit, String begin, String target) {
        if(visit.get(begin)) {
            return;
        }
        visit.put(begin, true);
        System.out.println(begin);
        System.out.println("values");

        Set<String> strings = wordsTreeMap.get(begin);
        strings.forEach(System.out::println);
        Iterator<String> iterator = strings.iterator();
        count++;

        while (iterator.hasNext()) {
            String nextString = iterator.next();
            if(nextString.equals(target)) {
                counts.add(count);
                return;

            }
            next(count, wordsTreeMap,visit, nextString, target);
        }
    }


}
