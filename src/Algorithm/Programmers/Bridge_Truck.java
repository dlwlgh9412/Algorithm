package Algorithm.Programmers;

import java.util.*;


public class Bridge_Truck {
    private class Truck {
        int weight = 0;
        int distance = 0;

        public Truck(int weight) {
            this.weight = weight;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> truckList = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            truckList.add(new Truck(truck_weights[i]));

            if (!truckList.isEmpty()) {
                for (int j = 0; j < bridge_length; j++) {
                    // 큐안의 요소들의 거리 값이 증가하면서 경과시간 증가
                    answer += increaseDistance(truckList);
                    // 거리 증가후 맨앞의 요소가 bridge_length값과 같으면 요소 삭제
                    checkDistance(truckList, bridge_length);
                    // 큐안의 요소들의 무게값과 weight 값을 비교하여 weight 값보다 작으면 True 크거나 같으면 False
                    if(checkWeight(truckList, weight)) {
                        // weight 값보다 작으면 다음 요소가 들어갈 수도 있으므로 다음요소의 무게값과 요소안의 무게값을 더하여 weight 값과 비교
                        if(i < truck_weights.length - 1) {
                            // 참일 경우 반복문을 탈출 하여 다음 요소 삽입
                            if(nextWeight(truckList, weight, truck_weights[i + 1])) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        answer++;
        return answer;
    }

    private void checkDistance(Queue<Truck> trucks, int bridge_length) {
        if(!trucks.isEmpty()) {
            if (trucks.peek().distance == bridge_length) {
                trucks.remove();
            }
        }
    }

    private boolean nextWeight(Queue<Truck> trucks, int weight, int nextVal) {
        int result = nextVal;
        for(Truck truck : trucks) {
            result += truck.weight;
        }
        return result <= weight;
    }

    private boolean checkWeight(Queue<Truck> trucks, int weight) {
        int result = 0;
        for(Truck truck : trucks) {
            result += truck.weight;
        }

        return result < weight;
    }

    private int increaseDistance(Queue<Truck> trucks) {
        for(Truck truck : trucks) {
            truck.distance += 1;
        }
        return 1;
    }
}
