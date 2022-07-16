import java.util.*;
import java.util.stream.Collectors;

//신고 받은 유저 카카오 문제
public class OpenChatRoom {
    public static void main(String[] args) {
        String record[] = {
                "Enter uid1234 Muzi"
        , "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        List<String> func = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        final String format = "%s님이 %s";
        HashMap<String,String > idNameMapper = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String r : record
             ) {

            String seperated[] = r.split(" ");
            System.out.println(seperated.length);
            func.add(seperated[0]);
            ids.add(seperated[1]);
            if(!seperated[0].equals("Leave")) {
                idNameMapper.put(seperated[1], seperated[2]);
            }

        }
        final String enter = "들어왔습니다.";
        final String left = "나갔습니다.";


        for (int i = 0; i < func.size(); i++) {
            String f = "";
            if(func.get(i).equals("Enter")) {
                f = enter;
                result.add(String.format(
                        format,
                        idNameMapper.get(ids.get(i)),
                        f
                ));
            } else if (func.get(i).equals("Leave")) {
                f = left;
                result.add(String.format(
                        format,
                        idNameMapper.get(ids.get(i)),
                        f
                ));
            } else {
                System.out.println("error or change");
            }

        }
    }



}
