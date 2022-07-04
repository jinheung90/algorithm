import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int prePrice = prices[0];
        int time = 2;
        List<Integer> rs = new ArrayList<>();
        for(int i =1; i < prices.length; ++i) {
            if(prePrice >= prices[i]) {
                time++;
            }
            else {
                rs.add(time);
                time = 1;
            }
            prePrice = prices[i];
        }
        System.out.println(rs.toString());
        
    }
}
