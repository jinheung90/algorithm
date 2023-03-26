import java.util.Arrays;
import java.util.LinkedList;

public class CoupleRemove {
    public static void main(String[] args) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> temp = new LinkedList<>();
        String s = "babbaa";
        StringBuilder stringBuilder = new StringBuilder(s);
        for (Character c: s.toCharArray()
             ) {
            stack.addLast(c);
        }

        while (!stack.isEmpty()) {
            Character character = stack.removeFirst();
            if(temp.isEmpty()) {
                temp.add(character);
            } else {
                Character tempFirst = temp.getFirst();
                if(character.equals(tempFirst)) {
                    temp.pop();
                } else {
                    temp.push(character);
                }
            }
        }
        if(!temp.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

//        int i = 0;
//        Character character = b.charAt(i);
//
//        while (i < b.length() - 1) {
//            i++;
//            System.out.println(character);
//            if(!character.equals(b.charAt(i))) {
//                break;
//            } else {
//                i++;
//            }
        }

    }


