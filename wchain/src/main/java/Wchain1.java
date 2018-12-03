import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Wchain1 {
    private static class Word {
        int id;
        String label;

        Word derivedWord;

        Word(int id, String label) {
            this.id = id;
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private static int wordCount;
    private static Word[] words;

    private static Word[] readFromFile(String fileName) {
        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String label = bufferedReader.readLine();
            wordCount = Integer.parseInt(label);

            words = new Word[wordCount];
            Map<String, Word> wordMap = new HashMap<>();
            for (int i = 0; i < wordCount; i++) {
                label = bufferedReader.readLine();
                Word word = new Word(i, label);
                words[i] = word;
                wordMap.put(label, word);
            }

            for (Word w : words) {
                label = w.label;
                for (int i = 0; i < label.length(); i++) {
                    String target = removeChar(label, i);
                    if (wordMap.containsKey(target)) {
                        w.derivedWord = wordMap.get(target);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return words;
    }

    private static int DFS(Word word) {
        boolean[] visited = new boolean[wordCount];
        Stack<Word> stack = new Stack<>();
        stack.push(word);

        int count = 0;

        while (!stack.isEmpty()) {
            Word word1 = stack.pop();
            if (word1 == null) {
                return count;
            }

            count++;

            if (!visited[word1.id]) {
                visited[word1.id] = true;
                stack.push(word1.derivedWord);
            }
        }
        return count;
    }

    private static int getMaxChainLength(int[] chainLength) {
        Arrays.sort(chainLength);
        return chainLength[chainLength.length - 1];
    }

    private static int[] getChainLength(Word[] words) {
        int[] chainLength = new int[wordCount];
        for (Word word : words) {
            chainLength[word.id] = DFS(word);
        }
        return chainLength;
    }

    private static String removeChar(String word, int position) {
        StringBuilder stringBuilder = new StringBuilder(word);
        stringBuilder.delete(position, position + 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Word[] words = readFromFile("wchain.in");
        int[] chainLength = getChainLength(words);
        int maxChainLength = getMaxChainLength(chainLength);

        System.out.println(maxChainLength);
    }
}