package Algorithm.baekjoon;

import java.util.Scanner;

public class Ex_1003 {
    static int[] zero = new int[41];
    static int[] one = new int[41];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }

        for(int i = 0; i < n; i++) {
            fibo(list[i]);
        }
    }

    public static void fibo(int n) {
        for(int i = 0; i <= n; i++) {
            if(i == 0) {
                zero[i] = 1;
                one[i] = 0;
            } else if(i == 1) {
                zero[i] = 0;
                one[i] = 1;
            } else if(i == 2) {
                zero[i] = 1;
                one[i] = 1;
            } else {
                zero[i] = zero[i - 1] + zero[i - 2];
                one[i] = one[i - 1] + one[i - 2];
            }
        }

        System.out.println(zero[n] + " " + one[n]);
    }
}
