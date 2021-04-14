package Algorithm.Programmers;

import java.util.Stack;

public class 이진변환반복 {
    public static void main(String[] args) {
        solution("01110");
    }

    private static int[] solution(String s) {
        int cnt = 0, len = 0;
        while(s.length() != 1) {
            len += s.length() - s.replace("0", "").length();
            s = s.replace("0", "");
            Integer result = s.length();

            Stack<String> stack = new Stack();
            while(result != 1) {
                if(result % 2 == 1) {
                    result /= 2;
                    stack.push("1");
                } else if(result % 2 == 0) {
                    result /= 2;
                    stack.push("0");
                }
            }
            stack.push("1");

            s = "";
            while(!stack.isEmpty()) {
                s += stack.pop();
            }
            cnt++;
        }
        int[] answer = {cnt + 1, len};
        return answer;
    }
}
