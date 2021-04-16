package Algorithm.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {
    static class Pair<L, R> {
        L left;
        R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }
    }
    public static void main(String[] args) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] box = new int[n][m];

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < m; y++) {
                box[x][y] = scanner.nextInt();
                if(box[x][y] == 1) {
                    queue.add(new Pair(x, y));
                }
            }
        }

        int cnt = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int j = 0; j < size; j++) {
                int x = queue.peek().left;
                int y = queue.peek().right;
                queue.remove();

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    try {
                        if (box[nx][ny] == 0) {
                            box[nx][ny] = 1;
                            queue.add(new Pair<>(nx, ny));
                        }
                    } catch (ArrayIndexOutOfBoundsException ignored) {

                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(box[i][j] == 0) {
                    cnt = -1;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
