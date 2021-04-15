package Algorithm.Programmers;

import java.util.*;

public class 프로그래밍3 {
    public static void main(String[] args) {
        int[] a = {-9, 3, 2, 1, 2, 1};
        int[][] edges = {{0, 1}, {3, 4}, {2, 3}, {0, 3}, {2, 5}};
        System.out.println(solution(a, edges));
    }
    private static long solution(int[] a, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            for(int j = 0; j < edges[0].length; j++) {
                if(j == 0)
                    graph.get(edges[i][0]).add(edges[i][1]);
                if(j == 1)
                    graph.get(edges[i][1]).add(edges[i][0]);
            }
        }
        int min = 0;
        int max = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min = a[i];
            }

            if(max < a[i]) {
                max = a[i];
            }
        }

        int target;
        if(Math.abs(min) > Math.abs(max)) {
            target = min;
        } else {
            target = max;
        }

        for(int i = 0; i < a.length; i++) {
            if(a[i] == target) {
                target = i;
            }
        }

        Iterator<Integer> nodes = graph.get(target).iterator();
        int cnt = 0;

        while(nodes.hasNext()) {
            Integer nearIdx = nodes.next();
            List<Integer> node = graph.get(nearIdx);
            if(!node.isEmpty()) {
                Iterator<Integer> next = node.iterator();
                while (next.hasNext()) {
                    int idx = next.next();
                    if(target != idx) {
                        a[nearIdx] += a[idx];
                        cnt += a[idx];
                        a[idx] = 0;
                    }
                }
            }
        }

        int before = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] != 0) {
                if(before == 0) {
                    before = a[i];
                } else {
                    before = Math.abs(before) - Math.abs(a[i]);
                    cnt += a[i];
                }
            }
        }

        if(before == 0) {
            return cnt;
        } else {
            return -1;
        }
    }
}
