package Algorithm.baekjoon;

import java.util.Scanner;

public class 설탕배달 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int cnt = 0;
        while(0 < n) {
            if(n % 5 == 0) {
                cnt += n / 5;
                break;
            }
            n -= 3;
            cnt++;
        }

        if(n < 0) {
            cnt = -1;
        }
        System.out.println(cnt);
    }
}