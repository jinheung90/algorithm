import java.util.Arrays;

//전화번호 목록
public class PhoneNumList {
    public boolean solution(String[] phone_book) {
        int rs1;
           int rs2;
             for(int i =0; i < phone_book.length; ++i) {
                 for(int j = i + 1; j < phone_book.length; ++j) {
                     rs1 = phone_book[i].indexOf(phone_book[j]);
                      rs2 = phone_book[j].indexOf(phone_book[i]);
                     if(rs1 == 0 || rs2 == 0)
                     {
                         return false;
                     }
                 
                 }
             }
           return true;
       }
}
