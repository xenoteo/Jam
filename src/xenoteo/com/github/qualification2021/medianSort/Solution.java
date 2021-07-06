package xenoteo.com.github.qualification2021.medianSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        for (int i = 0; i < t; i++){
            int result = medianSort(n);
            if (result == -1) break;
        }
    }

    /**
     * Performs an interactive median sort and prints the order of indexes in the sorted array.
     *
     * @param n  the length of the array
     * @return whether sort was successful (1) or not (-1)
     */
    private static int medianSort(int n){
        List<Integer> indexes = new ArrayList<>();
        indexes.add(1);
        indexes.add(2);
        for (int i = 3; i <= n; i++) {
            int left = 0;
            int right = indexes.size() - 1;
            while (left < right) {
                int mid1 = left + (right - left) / 3;
                int mid2 = right - (right - left) / 3;
                int l = askForMedian(indexes.get(mid1), indexes.get(mid2), i);
                if (l == -1) return -1;
                if (l == indexes.get(mid1)) {
                    right = mid1 - 1;
                    if (left == right) right++;
                } else if (l == indexes.get(mid2)) {
                    left = mid2 + 1;
                    if (left == right) left--;
                } else {
                    left = mid1 + 1;
                    right = mid2 - 1;
                    if (left == right) left--;
                }
            }
            indexes.add(left, i);
        }
        System.out.println(String.join(" ", indexes.stream().map(String::valueOf).toArray(String[]::new)));
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    /**
     * Given three indexes returns the index of the median element.
     *
     * @param i  the first index
     * @param j  the second index
     * @param k  the third index
     * @return the index of the median element
     */
    private static int askForMedian(int i, int j, int k){
        Scanner in = new Scanner(System.in);
        System.out.printf("%d %d %d\n", i, j, k);
        return in.nextInt();
    }
}
