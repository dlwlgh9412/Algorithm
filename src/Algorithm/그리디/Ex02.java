package Algorithm.그리디;

public class Ex02 {
    public static void main(String[] args) {
        System.out.println(solution("5167"));
    }

    private static int solution(String str) {
        int result = 1;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 49) {
                result += (int) str.charAt(i) - '0';
            } else if(str.charAt(i) != 48) {
                result *= (int) str.charAt(i) - '0';
            }
        }

        return result;
    }
}
