package Algorithm.codility;

import java.util.HashSet;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 3, 9, 9, 3, 9, 1};
        System.out.println(solution(arr));
    }

    private static int solution(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            temp = temp ^ arr[i];
        }

        return temp;

        /*
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                set.remove(arr[i]);
            } else {
                set.add(arr[i]);
            }
        }
        return set.iterator().next();

         */
    }
}
