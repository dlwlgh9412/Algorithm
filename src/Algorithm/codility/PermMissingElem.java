package Algorithm.codility;

import java.util.Arrays;
import java.util.HashSet;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{6}));
    }

    private static int solution(int[] arr) {
        if(arr.length != 0) {
            Arrays.sort(arr);
        }

        int[] newArr = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }


        int result = 0;
        for(int i = 0; i < newArr.length; i++) {
            if(newArr[i] + 1 != newArr[i + 1]) {
                result = newArr[i] + 1;
                break;
            }
        }

        return result;
    }
}
