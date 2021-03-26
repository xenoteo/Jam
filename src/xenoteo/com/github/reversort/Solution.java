package xenoteo.com.github.reversort;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int size = in.nextInt();
            int[] L = new int[size];
            for (int i = 0; i < size; i++){
                L[i] = in.nextInt();
            }
            System.out.printf("Case #%d: %d\n", t + 1, reverseCost(L));
        }
    }

    private static int reverseCost(int[] L){
        int cost = 0;
        for (int i = 0; i < L.length - 1; i++){
            int j = minPosition(L, i);
            reverse(L, i, j);
            cost += j - i + 1;
        }
        return cost;    }

    private static int minPosition(int[] L, int i){
        int min = L[i];
        int minPos = i;
        for (int k = i; k < L.length; k++){
            if (L[k] < min){
                min = L[k];
                minPos = k;
            }
        }
        return minPos;
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
