package bruteforce;

import java.util.*;

public class Boj_14584 {
    public void solution() {
        int alphaNum = 25;
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        char[] inputList = inputString.toCharArray();

        int wordNum = scanner.nextInt();
        String[] wordList = new String[wordNum];
        for (int i = 0; i < wordNum; i++) {
            wordList[i] = scanner.next();
        }

        for (String word : wordList) {
            if (String.valueOf(inputList).contains(word)) {
                System.out.println(String.valueOf(inputList));
                break;
            }
        }
        for (int i = 0; i < alphaNum; i++) {
            for (int j = 0; j < inputList.length; j ++) {
                int num = (int) inputList[j];
                num += 1;
                if (num > 122) {
                    num -= 26; 
                }
                inputList[j] = (char) num;
            }
            String changedString = String.valueOf(inputList);
            for (String word : wordList) {
                if (changedString.contains(word)) {
                    System.out.println(changedString);
                    break;
                }
            }

        }
    }
}
