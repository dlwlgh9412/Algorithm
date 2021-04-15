package Algorithm.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] list = new int[n];

        for(int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        Arrays.sort(list);
        int result = 0;
        int tmp = 0;
        for(int i = 0; i < list.length; i++) {
            if(i == 0) {
                tmp = list[i];
                result += tmp;
            } else {
                tmp = tmp + list[i];
                result += tmp;
            }
        }

        System.out.print(result);
    }
}
