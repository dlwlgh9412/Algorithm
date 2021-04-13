package Algorithm.codility;

public class CyclicRotation {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, 3));
    }

    private static int[] solution(int[] arr, int k) {
        for(int i = 0; i < k; i++) {
            int tmp = arr[arr.length - 1];
            for(int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
                if(j == 1) {
                    arr[j - 1] = tmp;
                }
            }
        }

        return arr;
    }
}
