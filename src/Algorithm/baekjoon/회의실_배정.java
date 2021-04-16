package Algorithm.baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 회의실_배정 {
    public static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Time> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(new Time(scanner.nextInt(), scanner.nextInt()));
        }

        list.sort(new Comparator<Time>() {
            @Override
            public int compare(Time left, Time right) {
                if(left.end == right.end) {
                    return left.start - right.start;
                } else {
                    return left.end - right.end;
                }
            }
        });

        int cnt = 0;
        int end = 0;
        for(int i = 0; i < list.size(); i++) {
            if(end <= list.get(i).start) {
                end = list.get(i).end;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
