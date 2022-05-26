package dataStructure;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_10809 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int[] indexAlphabet = new int[26];

        String inputAlphabet = scanner.nextLine();

        for (int i = 0; i < 26; i++){
            indexAlphabet[i] = -1;
        }
        for (int i = 0; i < inputAlphabet.length(); i++) {
            int ascii = (int) inputAlphabet.charAt(i);
            if(indexAlphabet[ascii-97] == -1) {
                indexAlphabet[ascii-97] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < indexAlphabet.length; i++){
            ans.append(indexAlphabet[i]);
            ans.append(" ");
        }
        System.out.println(ans);
    }
}
