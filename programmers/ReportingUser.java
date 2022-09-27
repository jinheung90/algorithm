import java.util.*;
//신고 받은 유저 카카오 문제
public class ReportingUser {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        int[] result = new int[id_list.length];
        String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        HashMap<String, HashSet<String>> reportHasUser = new HashMap<>(); // 리포트 한 애들 value 리스트로 저장
        HashMap<String, Integer> userHasReportCount = new HashMap<>(); // 리포터 한 사람과 해당 카운트 증가
        for (String id :id_list
             ) {
            reportHasUser.put(id, new HashSet<>());
            userHasReportCount.put(id, 0);
        }

        Arrays.stream(report).forEach(r -> {
            int empty = r.indexOf(" ");
            Set<String> item = reportHasUser.get(r.substring(empty+1)); //
            item.add(r.substring(0, empty));
        });

        reportHasUser.forEach((key, value) -> value.forEach(
            v -> {
                if(value.size() >= k) {
                    userHasReportCount.put(v, userHasReportCount.get(v) + 1);
                }
            }
        ));
        for (int i = 0; i < id_list.length; i++) {
            result[i] = userHasReportCount.get(id_list[i]);
        }
        for (int i = 0; i <result.length; i++) {
            System.out.println(result[i]);
        }
        return;
    }


}
