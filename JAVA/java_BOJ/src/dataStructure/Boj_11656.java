package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11656 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputGroup = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputGroup[i] = input.substring(i);
        }

        SortingWord(inputGroup);

    }
    private void SortingWord(String[] word) {
        int arrLength = word.length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength - 1; j++) {
                if((int) word[j].charAt(0) > (int) word[j+1].charAt(0)) {
                    String saver = word[j];
                    word[j] = word[j+1];
                    word[j+1] = saver;
                }
                else if((int) word[j].charAt(0) == (int) word[j+1].charAt(0) && word[j].length() > word[j+1].length()) {
                    String saver = word[j];
                    word[j] = word[j+1];
                    word[j+1] = saver;
                }
            }
        }
        for (String s : word) {
            System.out.println(s);
        }
    }
}
