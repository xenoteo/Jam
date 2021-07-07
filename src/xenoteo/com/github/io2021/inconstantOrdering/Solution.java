package xenoteo.com.github.io2021.inconstantOrdering;

import java.util.Scanner;

public class Solution {

    /**
     * The English alphabet.
     */
    private static final char[] alphabet = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int N = in.nextInt();
            int[] L = new int[N];
            for (int i = 0; i < N; i++){
                L[i] = in.nextInt();
            }
            System.out.printf("Case #%d: %s\n", t + 1, firstValidString(N, L));
        }
    }

    /**
     * Returns the valid string that comes first in alphabetical order in the list of all valid strings.
     *
     * @param N  the number of blocks
     * @param L  the number of letters each block must have
     * @return the first valid string
     */
    private static String firstValidString(int N, int[] L){
        StringBuilder str = new StringBuilder();
        str.append('A');
        for (int i = 0; i < N; i++){
            if ((i + 1) % 2 == 1){
                // acc
                for (int k = 1; k < L[i]; k++){
                    str.append(alphabet[k]);
                }
                if (i < N - 1 && L[i] < L[i + 1]){
                    str.append(alphabet[L[i + 1]]);
                }
                else {
                    str.append(alphabet[L[i]]);
                }
            }
            else {
                // desc
                for (int k = L[i] - 1; k >= 0; k--){
                    str.append(alphabet[k]);
                }
            }
        }
        return str.toString();
    }
}
