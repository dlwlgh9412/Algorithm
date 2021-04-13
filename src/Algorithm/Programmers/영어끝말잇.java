package Algorithm.Programmers;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇 {

    public static void main(String[] args) {
        int[] result = solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int cnt = 0;
        int level = 1;
        Set<String> wordSet = new HashSet<>(100);
        for(int i = 0; i < words.length; i++) {
            if(cnt == n) {
                cnt = 1;
                level++;
            } else {
                cnt++;
            }
            if(i > 0) {
                if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    answer[0] = cnt;
                    answer[1] = level;
                    break;
                }
            }

            if(!wordSet.add(words[i])) {
                answer[0] = cnt;
                answer[1] = level;
                break;
            }
        }
        return answer;
    }
}
