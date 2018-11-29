import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Eggz {
    private static double countDistance(int[] xArray, int[] yArray, int i, int j) {
        return (xArray[i] - xArray[j]) * (xArray[i] - xArray[j]) + (yArray[i] - yArray[j]) * (yArray[i] - yArray[j]);
    }

    private static double findResult(int[] xArray, int[] yArray) {
        double minOptimal = 0;
        double maxOptimal = findMaxDistance(xArray, yArray);

        while (minOptimal + maxOptimal != minOptimal) {
            double temp = minOptimal + maxOptimal;
            boolean[][] booleanGraph = new boolean[xArray.length][yArray.length];

            booleanGraph = evaluateDistances(xArray, yArray, booleanGraph, temp);

            booleanGraph = floydWarshallAlgo(booleanGraph);

            boolean ok = true;

            for (boolean[] aBooleanGraph : booleanGraph) {
                for (boolean aBoolean : aBooleanGraph) {
                    if (!aBoolean) {
                        ok = false;
                    }
                }
            }

            if (!ok) {
                minOptimal += maxOptimal;
            }

            maxOptimal /= 2;
        }

        return Math.sqrt(minOptimal);
    }

    private static boolean[][] evaluateDistances(int[] xArray, int[] yArray, boolean[][] booleanGraph, double temp) {
        for (int i = 0; i < booleanGraph.length; i++) {
            for (int j = 0; j < booleanGraph.length; j++) {
                double distance = countDistance(xArray, yArray, i, j);
                if (distance <= temp) {
                    booleanGraph[i][j] = true;
                }
            }
        }

        return booleanGraph;
    }

    private static boolean[][] floydWarshallAlgo(boolean[][] booleanGraph) {
        for (int k = 0; k < booleanGraph.length; k++) {
            for (int i = 0; i < booleanGraph.length; i++) {
                for (int j = 0; j < booleanGraph.length; j++) {
                    if (booleanGraph[i][k] && booleanGraph[k][j]) {
                        booleanGraph[i][j] = true;
                    }
                }
            }
        }
        return booleanGraph;
    }

    private static double findMaxDistance(int[] xArray, int[] yArray) {
        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < xArray.length; i++) {
            for (int j = 0; j < yArray.length; j++) {
                double distanceSquare = countDistance(xArray, yArray, i, j);

                distances.add(Math.sqrt(distanceSquare));
            }
        }

        return Collections.max(distances);
    }

    public static void main(String[] args) {
        int[] xArray = {3, 3, 3, 3, 3, 3, 3};
        int[] yArray = {2, 3, 4, 3, 9, 8, 1};

        System.out.println(findResult(xArray, yArray));
    }
}