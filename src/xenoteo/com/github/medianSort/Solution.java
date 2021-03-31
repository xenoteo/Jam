package xenoteo.com.github.medianSort;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        for (int i = 0; i < t; i++){
            medianSort(n, q);
        }
    }

    private static void medianSort(int n, int q){
        int[] indexes = sortedArray(n);
        int i = 2;
        Scanner in = new Scanner(System.in);
        for (int qi = 0; qi < q; qi++){
            if (i >= n)
                i = 2;
            System.out.printf("%d %d %d\n", i - 1, i, i + 1);
            int l = in.nextInt();
            if (i != l){
                swap(indexes, i - 1, l - 1);
            }
            i++;
        }
        System.out.println(String.join(" ", Arrays.stream(indexes).mapToObj(String::valueOf).toArray(String[]::new)));
    }

    private static int[] sortedArray(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
