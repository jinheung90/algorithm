import java.util.ArrayList;
import java.util.List;

public class RightBracket {
    public static void main(String[] args) {
        String s = "((()))()";
        int leftCount = 0;
        int rightCount = 0;

        if(s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
//            return false;
        }

        for (int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                leftCount++;
            }
            if(s.charAt(i) == ')') {
                rightCount++;
            }
            if(leftCount == rightCount &&
                    leftCount != 0 && rightCount != 0
            ) {
                continue;
            }

            if(rightCount > leftCount) { // 5번케이스
//                return false;
            }
        }
        if(leftCount != rightCount) {
//            return false;
        }

/*
        return true;*/
    }
}
