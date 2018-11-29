import java.util.*;

public class Eggs {
    private static List<Vector<Integer>> createVectorList(int[] xArray, int[] yArray) throws Exception {
        List<Vector<Integer>> vectorList = new ArrayList<>();

        if (xArray.length != yArray.length) {
            throw new Exception("The length should be equal!");
        }

        for (int i = 0; i < xArray.length; i++) {
            Vector<Integer> vector = new Vector<>();
            vector.add(xArray[i]);
            vector.add(yArray[i]);
            vectorList.add(vector);
        }

        for (Vector vector : vectorList) {
            System.out.println(vector);
        }

        return vectorList;
    }

    private static double countBiggestDistance(List<Vector<Integer>> vectorList) {
        List<Double> distances = new ArrayList<>();
        for (int i = 0; i < vectorList.size(); i++) {
            for (int j = 0; j < vectorList.size(); j++) {
                if (i == j) {
                    continue;
                }

                Vector<Integer> oneVector = vectorList.get(i);
                Vector<Integer> anotherVector = vectorList.get(j);

                double distanceSquare = Math.pow((anotherVector.get(0) - oneVector.get(0)), 2) + Math.pow((anotherVector.get(1) - oneVector.get(1)), 2);

                distances.add(Math.sqrt(distanceSquare));
            }
        }

        return Collections.max(distances);
    }

    public static void main(String[] args) {
        int[] xArray = {-2000, -2000};
        int[] yArray = {3000, 3000};

        List<Vector<Integer>> vectors = new ArrayList<>();

        try {
            vectors = createVectorList(xArray, yArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(countBiggestDistance(vectors));

    }
}