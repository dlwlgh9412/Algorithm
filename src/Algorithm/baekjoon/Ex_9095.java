package Algorithm.baekjoon;

import java.util.Scanner;

public class Ex_9095 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        int[] memo = new int[max + 1];
        for(int i = 1; i <= max; i++) {
            if(i == 1) {
                memo[i] = 1;
            } else if(i == 2) {
                memo[i] = 2;
            } else if(i == 3) {
                memo[i] = 4;
            } else {
                memo[i] += memo[i - 1] + memo[i - 2] + memo[i - 3];
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(memo[arr[i]]);
        }
    }
}
