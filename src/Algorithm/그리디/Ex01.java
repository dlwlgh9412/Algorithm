package Algorithm.그리디;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(solution(25, 3));
    }

    private static int solution(int n, int k) {

        int cnt = 0;
        while(n != 1) {
            if(n % k == 0) {
                n /= k;
                cnt++;
            } else {
                n--;
                cnt++;
            }
        }

        return cnt;
    }
}
