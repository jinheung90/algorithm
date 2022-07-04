//타겟 넘버

public class TargetNumber {
    public static int count = 0;
    public static void wrapper(int start, int i, int[] store, int target) {
     
        int start1 = start - store[i];
        int start2 = start + store[i];
        if(i == store.length - 1) {

            if(start1 == target ) {
                System.out.print("afgawetg");
                System.out.println(count);
                count++;
                System.out.println(count);
            }
            if(start2 == target ) {
                System.out.print("afgawetg");
                System.out.println(count);
                count++;
                System.out.println(count);
            }
   
        } else {
            ++i;
            wrapper(start1,i, store,target);
            wrapper(start2,i, store, target);
        }
    }
    public int solution(int[] numbers, int target) {     
        wrapper(0, 0,numbers,target);
        return count;
    }
}
