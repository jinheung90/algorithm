public class SecretMap {
    public static String toBinaryStringByDigit(int digit, int n) {
        String temp = Integer.toBinaryString(n);
        int length = temp.length();
        length = digit - length;
        for(int i =0; i < length; ++i) {
            temp = "0" + temp;
        }
        return temp;
    }

  
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String temp1;
        String temp2;
        String temp3 = "";

        String[] answer = new String[n];
        for(int i =0; i < n; ++i) {
            temp1 = toBinaryStringByDigit(n, arr1[i]);
            temp2 = toBinaryStringByDigit(n, arr2[i]);
            for(int j = 0; j < n; ++j) {
                if(temp1.charAt(j) == '1' || temp2.charAt(j) == '1') {
                    temp3 +="#";
                    continue;
                } 
                temp3 += " ";
                
            }
            answer[i] = temp3;
            temp3 ="";
            
        }
        
    
        
    }
}
