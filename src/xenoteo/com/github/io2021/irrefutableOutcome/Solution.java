package xenoteo.com.github.io2021.irrefutableOutcome;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        in.nextLine();
        for (int t = 0; t < testCasesNumber; t++){
            String B = in.nextLine();
            System.out.printf("Case #%d: %s\n", t + 1, game(B));
        }
    }

    /**
     * Given the starting board, finds out who wins and what is their score.
     *
     * @param B  the starting board
     * @return the string with an initial letter of winner name and their score
     */
    private static String game(String B){
        char[] b = B.toCharArray();
        int n =  b.length;
        char c = 'I';
        char opp = 'O';
        int l = 0;
        int r = n - 1;
        for (int i = 0; i < n - 1; i++) {
            if (b[l] == c && (b[l + 1] == c || b[r] != c)) {            // II... or I...O (if c == I)
                l++;
            }
            else if (b[r] == c && (b[r - 1] == c || b[l] != c)) {       // O...I or ...II (if c == I)
                r--;
            }
            else if (b[l] != c && b[r] != c) {                          // O...O          (if c == I)
                return String.format("%c %d", opp, r - l + 2);
            }
            else {
                int x = l;
                int y = r;
                while (x < y && b[x] != b[x + 1]) {     // while alternating
                    x++;
                }
                while (y > x && b[y] != b[y - 1]) {     // while alternating
                    y--;
                }
                if (x == y) {
                    return String.format("%c %d", c, 1);
                }
                else if (b[x] == c && b[y] == c) {
                    return String.format("%c %d", c, Math.max(r - x, y - l) + 1);
                }
                else if (b[x] == c) {
                    return String.format("%c %d", c, r - x + 1);
                }
                else if (b[y] == c) {
                    return String.format("%c %d", c, y - l + 1);
                }
                else {
                    return String.format("%c %d", opp, y - x);
                }
            }

            if (c == 'I') {
                c = 'O';
                opp = 'I';
            }
            else {
                c = 'I';
                opp = 'O';
            }
        }

        if (b[l] == c) {
            return String.format("%c %d", c, 1);
        }
        else {
            return String.format("%c %d", opp, 2);
        }
    }

}
