package Algorithm.codility;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(561892 ));
    }

    public static int solution(int n) {
        StringBuffer buf = new StringBuffer();

        while(1 < n) {
            if(n % 2 == 1) {
                buf.append("1");
                n = n / 2;
            } else if(n % 2 == 0) {
                buf.append("0");
                n = n / 2;
            }
        }

        buf.append(n);
        buf = buf.reverse();
        int cnt = 0;
        int len = 0;
        for(int i = 0; i < buf.length(); i++) {
            if(buf.charAt(i) == '1') {
                if(len < cnt) {
                    len = cnt;
                }
                cnt = 0;
            } else {
                cnt++;
            }
        }

        return len;
    }
}
