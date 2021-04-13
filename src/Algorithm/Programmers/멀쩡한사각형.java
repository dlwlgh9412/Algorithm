package Algorithm.Programmers;

public class 멀쩡한사각형 {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    private static long solution(int w, int h) {
        long answer = 0;
        answer = (long) w * h - ((w + h) - gcd(w, h));
        return answer;
    }

    private static int gcd(int a, int b) {
        if(b > a) {
            int temp = 0;
            temp = a;
            a = b;
            b = temp;
        }
        while(true) {
            if(a % b == 0) {
                return b;
            } else {
                int temp = a;
                a = b;
                b = temp % b;
            }
        }
    }
}
