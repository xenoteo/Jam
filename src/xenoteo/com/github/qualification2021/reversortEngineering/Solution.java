package xenoteo.com.github.qualification2021.reversortEngineering;

import java.util.*;

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

    /**
     * Given a size N and a cost C, finds a list of N distinct integers between 1 and N
     * such that the cost of applying Reversort to it is exactly C, or say that there is no such list.
     *
     * Complexity is O(N^2).
     *
     * @param n  the size of the array
     * @param c  the cost of Reversort
     * @return a list of N distinct integers between 1 and N such that the cost of applying Reversort to it is exactly C
     */
    private static String reversortEngine(int n, int c){
        if (c < n - 1 || c > n * (n + 1) / 2 - 1)
            return "IMPOSSIBLE";
        c -= (n - 1);                   // the case for the sorted array
        int[] arr = sortedArray(n);     // starting with sorted array
        // going backward to find the target list
        for (int x = n - 1; x > 0; x--){
            if (c == 0) break;
            int reverseCost = Math.min(c, n - x);
            c -= reverseCost;
            reverse(arr, x - 1, x - 1 + reverseCost);
        }
        return String.join(" ", Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new));
    }

    /**
     * Returns sorted array from 1 to n.
     *
     * @param n  the n
     * @return the sorted array from 1 to n
     */
    private static int[] sortedArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        return arr;
    }

    /**
     * Reverses an array from index i to index j (all inclusive).
     *
     * @param L  the array
     * @param i  the start index
     * @param j  the end index
     */
    private static void reverse(int[] L, int i, int j){
        int half = (j - i) / 2;
        for (int k = 0; k <= half; k++){
            int temp = L[i + k];
            L[i + k] = L[j - k];
            L[j - k] = temp;
        }
    }
}
