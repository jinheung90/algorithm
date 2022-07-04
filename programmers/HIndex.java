import java.util.Arrays;


// 완료
public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 1, 5, 50, 0, 55,  4, 7, 20};
        Arrays.sort(citations); 
        // 0 1 3 5 6
        // 3 5 6
        for (int i : citations) {
            System.out.println(i);
        }

        int size = citations.length;
        int rs = citations[0];
        for (int i = 0; i < size; i++) {
            int val = citations[i];
            if(val > size - i) {
                rs = size - i;
                break;
            }
        }
        System.out.println(rs);
    }
}
