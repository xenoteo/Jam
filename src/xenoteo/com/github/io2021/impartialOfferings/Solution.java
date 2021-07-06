package xenoteo.com.github.io2021.impartialOfferings;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int n = in.nextInt();
            int[] animals = new int[n];
            for (int i = 0; i < n; i++){
                animals[i] = in.nextInt();
            }
            System.out.printf("Case #%d: %d\n", t + 1, minTreats(animals));
        }
    }

    /**
     * Given the sizes of all pets, computes the minimum number of treats needed to buy to be able to offer at least
     * one treat to all pets while complying with impartiality rules.
     *
     * @param animals  the sizes of all pets
     * @return the minimum number of treats
     */
    private static int minTreats(int[] animals){
        Map<Integer, Integer> sizeCounter = new HashMap<>();
        for (int size : animals){
            sizeCounter.put(size, sizeCounter.getOrDefault(size, 0) + 1);
        }
        List<Integer> sizes = new ArrayList<>(sizeCounter.keySet());
        Collections.sort(sizes);
        int treat = 1;
        int count = 0;
        for (int size : sizes){
            count += sizeCounter.get(size) * treat;
            treat++;
        }
        return count;
    }
}
