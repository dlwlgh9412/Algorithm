package Algorithm.Programmers;

import java.util.Scanner;

public class kakaofreinds {
    static int[][] arr;
    static boolean[][] visited;
    static int colLen;
    static int rowLen;
    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int currentSize = 0;

    public static void main(String[] args) {
        System.out.print("크기 입력: ");
        int m = new Scanner(System.in).nextInt();
        int n = new Scanner(System.in).nextInt();
        arr = new int[m][n];
        visited = new boolean[m][n];
        // 열 길이
        colLen = m;
        // 행 길이
        rowLen = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new Scanner(System.in).nextInt();
            }
        }


        for (int col = 0; col < m; col++) {
            for (int row = 0; row < n; row++) {
                if (!visited[col][row] && arr[col][row] != 0) {
                    dfs(col, row);
                    numberOfArea++;
                    if (maxSizeOfOneArea < currentSize) {
                        maxSizeOfOneArea = currentSize;
                    }
                    currentSize = 0;
                }
            }
        }
        System.out.println("maxSizeOfOneArea: " + maxSizeOfOneArea);
        System.out.println("numberOfArea: " + numberOfArea);
    }

    public static void dfs(int col, int row) {
        int flag = arr[col][row];
        if (!visited[col][row]) {
            visited[col][row] = true;
            currentSize++;
            // 아래쪽 방향 탐색
            if (col < colLen - 1 && !visited[col + 1][row]) {
                if (flag == arr[col + 1][row]) {
                    dfs(col + 1, row);
                }
            }
            // 위쪽 방향 탐색
            if (0 < col && !visited[col - 1][row]) {
                if (flag == arr[col - 1][row]) {
                    dfs(col - 1, row);

                }
            }
            // 오른쪽방향 탐색
            if (row < rowLen - 1 && !visited[col][row + 1]) {
                if (flag == arr[col][row + 1]) {
                    dfs(col, row + 1);
                }
            }
            // 왼쪽 방향 탐색
            if (0 < row && !visited[col][row - 1]) {
                if (flag == arr[col][row - 1]) {
                    dfs(col, row - 1);

                }
            }
        }
    }
}
