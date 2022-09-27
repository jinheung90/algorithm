



public class OneTwoFourContry {
    public static void main(String[] args) {
        String str ="";
        int n = 5;
        StringBuffer stringBuffer = new StringBuffer();
        int tempDiv = 0;
        int tempOther;
        while(true) {
            if(n == 0) {
                break;
            }
            tempOther = n % 3;
            n = n/3;
            if(tempOther == 0) {
                n--;
                tempOther = 4;
            }
            stringBuffer.append(tempOther);
        }
        stringBuffer.reverse().toString();
    }

}
