package xenoteo.com.github.io2021.introductionsOrganization;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCasesNumber = in.nextInt();
        for (int t = 0; t < testCasesNumber; t++){
            int M = in.nextInt();
            int N = in.nextInt();
            int P = in.nextInt();
            in.nextLine();
            boolean[][] familiarities = new boolean[M + N + 1][M + N + 1];  // the 0 row and column are not used
            for (int i = 1; i <= M + N; i++){
                String line = in.nextLine();
                for (int j = 1; j <= M + N; j++){
                    familiarities[i][j] = line.charAt(j - 1) == 'Y';
                }
            }
            int[][] pairs = new int[P][2];
            for (int i = 0; i < P; i++){
                pairs[i][0] = in.nextInt();
                pairs[i][1] = in.nextInt();
            }
            System.out.printf("Case #%d: %s\n", t + 1, shortestTime(M, N, P, familiarities, pairs));
        }
    }

    /**
     * Finds the shortest time of familiarisation of provided pairs of workers.
     *
     * @param M  the number of managers
     * @param N  the number of non-managers
     * @param P  the number of pairs to investigate
     * @param familiarities  the graph of workers familiarities
     * @param pairs  pairs to investigate
     * @return the shortest time of familiarisation of provided pairs
     */
    private static String shortestTime(int M, int N, int P, boolean[][] familiarities, int[][] pairs){
        int[] times = new int[P];
        for (int i = 0; i < P; i++) {
            int distance = bfs(familiarities, M, pairs[i][0], pairs[i][1]);
            times[i] = countShortestTime(distance);
        }
        return String.join(" ", Arrays.stream(times).mapToObj(String::valueOf).toArray(String[]::new));
    }

    /**
     * Counts the shortest time of familiarisation based on distance,
     * taking into account that people are introduced in 3-persons groups.
     *
     * @param distance  the distance between two nodes in a graph
     * @return the shortest time of familiarisation
     */
    private static int countShortestTime(int distance) {
        if (distance < 0) return distance;
        int steps = 0;
        while (distance > 1) {
            distance = (int) (distance - Math.ceil((distance - 1) / 3.0));
            steps++;
        }
        return steps;
    }

    /**
     * Using BFS counts the distance between nodes a and b, taking into account only paths through managers.
     *
     * @param familiarities  the graph of workers familiarities
     * @param M  the number of managers
     * @param a  the first node
     * @param b  the last node
     * @return the distance between nodes a and b
     */
    private static int bfs(boolean[][] familiarities, int M, int a, int b) {
        int[] distance = new int[familiarities.length];         // distance to nodes from node a
        boolean[] visited = new boolean[familiarities.length];  // nodes visits
        LinkedList<Integer> queue = new LinkedList<>();

        distance[a] = 0;
        visited[a] = true;
        queue.add(a);

        while (!visited[b] && !queue.isEmpty()) {
            int v = queue.poll();
            int dist = distance[v];
            for (int w = 1; w < familiarities.length; w++) {
                if (familiarities[v][w] && !visited[w]) {
                    distance[w] = dist + 1;
                    visited[w] = true;
                    if (w <= M) queue.add(w);
                }
            }
        }

        return visited[b] ? distance[b] : -1;
    }

}
