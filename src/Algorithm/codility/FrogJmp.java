package Algorithm.codility;

public class FrogJmp {
    public static void main(String[] args) {
        System.out.println(solution(10, 85, 30));
    }

    private static int solution(int x, int y, int d) {
        y -= x;
        int cnt = 0;
        if(0 < y % d && y % d < d) {
            cnt = y / d;
            cnt++;
        } else {
            cnt = y / d;
        }

        return cnt;
    }
}
