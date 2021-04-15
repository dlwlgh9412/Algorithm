package Algorithm.baekjoon;

import java.util.Scanner;

public class 동전_0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] list = new int[n];

        int target = scanner.nextInt();

        for(int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }

        int index = n - 1;
        int cnt = 0;
        while(target > 0) {
            if(0 <= index) {
                if(target - list[index] >= 0) {
                    target -= list[index];
                    cnt++;
                } else {
                    index--;
                }
            }
        }
        System.out.println(cnt);
    }
}
