package string;

import java.util.Scanner;

/**
 * SUCCESS
 */
public class Boj_1157 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next().toUpperCase();

        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A'] += 1;
        }

//        int maxIdx = 0;
//        int max = cnt[maxIdx];
//        for (int i = 1; i < 26; i++) {
//            if (max < cnt[i]) {
//                max = cnt[i];
//                maxIdx = i;
//            }
//        }
//
//        int maxCnt = 0;
//        for (int i = 0; i < 26; i++) {
//            if (max == cnt[i]) {
//                maxCnt += 1;
//            }
//        }
//
//        if (maxCnt > 1) {
//            System.out.println("?");
//        } else System.out.println((char)(maxIdx + 'A'));

        int maxCnt = -1;
        char maxAlpha = '?';

        for (int i = 0; i < 26; i++) {
            if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                maxAlpha = (char) ('A' + i);
            } else if (cnt[i] == maxCnt) {
                maxAlpha = '?';
            }
        }
        System.out.println(maxAlpha);
    }
}
