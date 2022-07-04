public class IsNumber {


    public static void main(String[] args) {
        String s = "a234";
        boolean isNum = true;
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            isNum = false;
        } finally {
           
        }
        
        System.out.println(isNum);
        
        //return answer;
    }
}
