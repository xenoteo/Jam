package xenoteo.com.github.moonsAndUmbrellas;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int x = in.nextInt();
            int y = in.nextInt();
            String s = in.next();
            System.out.printf("Case #%d: %d\n", t + 1, minCost(x, y, s));
        }
    }

    // CJ => x
    // JC => y
    private static int minCost(int x, int y, String s){
        int cost = 0;
        char[] chars = s.toCharArray();
        char prev = '?';
        for (char ch : chars) {
            if (ch == 'C' && prev == 'J') {
                cost += y;
            } else if (ch == 'J' && prev == 'C') {
                cost += x;
            }
            if (ch != '?') {
                prev = ch;
            }
        }
        return cost;
    }

}
