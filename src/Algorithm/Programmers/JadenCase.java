package Algorithm.Programmers;

public class JadenCase {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }

    public static String solution(String s) {
        String answer = "";
        StringBuffer words = new StringBuffer(s);

        if(96 < words.charAt(0) && words.charAt(0) < 123) {
            words.setCharAt(0, (char) (words.charAt(0) - 32));
        }

        for(int i = 1; i < words.length(); i++) {
            if(words.charAt(i - 1) == ' ') {
                if(96 < words.charAt(i) && words.charAt(i) < 123) {
                    words.setCharAt(i, (char) (words.charAt(i) - 32));
                }
            } else if(64 < words.charAt(i) && words.charAt(i) < 91) {
                words.setCharAt(i, (char) (words.charAt(i) + 32));
            }
        }

        answer = words.toString();
        return answer;
    }
}
