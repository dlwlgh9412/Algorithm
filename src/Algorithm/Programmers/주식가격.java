package Algorithm.Programmers;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            for(int j = i; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
                answer[i] = j  - i;
            }
        }
        return answer;
    }
}
