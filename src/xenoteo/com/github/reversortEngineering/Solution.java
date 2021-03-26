package xenoteo.com.github.reversortEngineering;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int n = in.nextInt();
            int c = in.nextInt();
            System.out.printf("Case #%d: %s\n", t + 1, reversortEngine(n, c));
        }
    }

    private static String reversortEngine(int n, int c){
        if (c < n - 1 || c > ((n + 1 - n / 2) * (n / 2) +  n - n / 2 - 1))
            return "IMPOSSIBLE";
        c -= (n - 1);
        int[] arr = sortedArray(n);
        reverse(arr, 0, c);
        return String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new));
    }

    private static int[] sortedArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        return arr;
    }

    private static void reverse(int[] L, int i, int j){
        int half = (j - i) / 2;
        for (int k = 0; k <= half; k++){
            int temp = L[i + k];
            L[i + k] = L[j - k];
            L[j - k] = temp;
        }
    }
}
