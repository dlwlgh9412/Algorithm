package Algorithm.baekjoon;

import java.util.Scanner;

public class MakeOne {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();

        int[] arr = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) {
                arr[i] = arr[i / 2] + 1 < arr[i] ? arr[i / 2] + 1 : arr[i];
            }

            if(i % 3 == 0) {
                arr[i] = arr[i / 3] + 1 < arr[i] ? arr[i / 3] + 1 : arr[i];
            }

        }

        System.out.println(arr[n]);
    }
}
