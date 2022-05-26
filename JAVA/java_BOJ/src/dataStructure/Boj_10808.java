package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_10808 {
    public  void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] countAlphabet = new int[26];

        String inputStr = scanner.nextLine();

        for (int i = 0; i < inputStr.length(); i++) {
            int asciiAlphabet = (int) inputStr.charAt(i);
            countAlphabet[asciiAlphabet-97] += 1;
        }

        String str = Arrays.toString(countAlphabet).replaceAll("[^0-9 ]","");
        System.out.println(str);

    }
}
