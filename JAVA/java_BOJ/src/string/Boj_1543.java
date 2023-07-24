package string;

import java.util.Objects;
import java.util.Scanner;

/**
 * SUCCESS
 */
public class Boj_1543 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String word = scanner.nextLine();

        int ans = 0;
        int wordLength = word.length();
        for (int i = 0; i < str.length() - (wordLength - 1); i++) {
            String substring = str.substring(i, i + wordLength);
            if (Objects.equals(word, substring)) {
                ans += 1;
                i += (wordLength - 1);
            }
        }

        System.out.println(ans);
//        SOLUTION 1
//        Scanner sc = new Scanner(System.in);
//        String doc = sc.nextLine();
//        String w = sc.nextLine();
//
//        int count = 0;
//        int startIdx = 0;
//        while (true) {
//            int findIdx = doc.indexOf(word, startIdx);
//            if (findIdx < 0) {
//                break;
//            }
//            count++;
//            startIdx = findIdx + wordLength;
//        }
//        System.out.println(count);


    }
}
