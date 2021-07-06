package xenoteo.com.github.qualification2021.cheatingDetection;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        int probability = in.nextInt();
        int playersNumber = 100;
        int questionsNumber = 10000;
        in.nextLine();
        for (int t = 0; t < testCasesNumber; t++){
            char[][] answers = new char[playersNumber][questionsNumber];
            for (int i = 0; i < playersNumber; i++){
                answers[i] = in.nextLine().toCharArray();
            }
            System.out.printf("Case #%d: %d\n", t + 1, detectCheater(answers));
        }
    }

    /**
     * Detects the cheater (returns his ID).
     *
     * @param answers  the array of players' answers
     * @return the cheater ID
     */
    private static int detectCheater(char[][] answers){
        int playersNumber = 100;
        int questionsNumber = 10000;
        double[] playersRate = new double[playersNumber];       // percent of right answers
        double[] questionsRate = new double[questionsNumber];   // percent of players given the right answers

        // counting the players and questions rate
        for (int i = 0; i < playersNumber; i++){
            for (int j = 0; j < questionsNumber; j++){
                if (answers[i][j] == '1') {
                    playersRate[i]++;
                    questionsRate[j]++;
                }
            }
            playersRate[i] /= 1.0 * questionsNumber;
        }
        for (int j = 0; j < questionsNumber; j++){
            questionsRate[j] /= 1.0 * playersNumber;
        }

        // counting the "cheating" index
        int[] cheatingIndex = new int[playersNumber];
        for (int i = 0; i < playersNumber; i++){
            for (int j = 0; j < questionsNumber; j++){
                if (answers[i][j] == '0') {
                    cheatingIndex[i] += Math.pow((1.0 / (1 - playersRate[i])), 2) * Math.pow(questionsRate[j], 4.0);
                }
            }
        }

        // finding the player with maximum cheating index
        int cheaterId = 0;
        for (int i = 0; i < playersNumber; i++){
            if (cheatingIndex[i] > cheatingIndex[cheaterId]){
                cheaterId = i;
            }
        }

        return cheaterId + 1;
    }
}
