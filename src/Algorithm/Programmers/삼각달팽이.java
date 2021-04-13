package Algorithm.Programmers;

public class 삼각달팽이 {
    public static void main(String[] args) {
        int arr[] = solution(8);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] solution(int n) {
        int[][] arr = new int[n][n];
        int[] answer = new int[factorial(n)];
        int i = 0, j = 0, k = 1;
        arr[i][j] = 1;

        while(k < factorial(n)) {
            while(i + 1 < n && arr[i + 1][j] == 0) {
                arr[++i][j] = ++k;
            }

            while(j + 1 < n && arr[i][j + 1] == 0) {
                arr[i][++j] = ++k;
            }

            while(i - 1 > 0 && arr[i - 1][j - 1] == 0) {
                arr[--i][--j] = ++k;
            }
        }

        k = 0;

        for(i = 0; i < n; i++) {
            for(j = 0; j <= i; j++) {
                if(arr[i][j] != 0) {
                    answer[k++] = arr[i][j];
                }
            }
        }

        return answer;
    }

    private static int factorial(int n) {
        return (n * (n + 1)) / 2;
    }
}
