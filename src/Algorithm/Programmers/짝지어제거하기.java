package Algorithm.Programmers;


import java.util.Stack;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));

    }

    private static int solution(String s) {
        int answer = 0;
        Stack<Character> words = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(!words.isEmpty() && words.peek() == s.charAt(i)) {
                words.pop();
            } else {
                words.push(s.charAt(i));
            }
        }

        if(words.isEmpty()) {
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}
