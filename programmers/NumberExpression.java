public class NumberExpression {
    public static void main(String[] args) {
        int input = 15;
        int count = 1;
        if(input == 1 || input == 2) {
            return;
        }

        int sumMax = input / 2 + 1;
        System.out.println(sumMax);

        int tempInput;
        int tempSumMax;
        for (int i = sumMax; i > 0; i--) {
            System.out.println("----------------------------");
            System.out.println(input);
            System.out.println(i);
            System.out.println("----------------------------");
            tempInput  = input;
            tempSumMax = i;

            while (true) {
                System.out.println("----------------------------");
                tempInput -= tempSumMax;
                System.out.println(tempSumMax);
                System.out.println(tempInput);
                tempSumMax--;

                System.out.println("----------------------------");
                if(tempSumMax < 0) {
                    break;
                }

                if(tempInput == 0) {
                    count++;
                    System.out.println(count);
                    break;
                }
                if(tempInput < 0) {
                    break;
                }
            }

        }
        System.out.println(count);
    }


}
