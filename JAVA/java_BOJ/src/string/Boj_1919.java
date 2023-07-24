package string;

import java.util.Scanner;

/**
 * SUCCESS
 */
public class Boj_1919 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

//        int[] cnt1 = new int[26];
//        int[] cnt2 = new int[26];

//        for (int i = 0; i < str1.length(); i++) {
//            cnt1[str1.charAt(i) - 'a'] += 1;
//        }
//        for (int i = 0; i < str2.length(); i++) {
//            cnt2[str2.charAt(i) - 'a'] += 1;
//        }
        int[] cnt1 = getAlphabetCnt(str1);
        int[] cnt2 = getAlphabetCnt(str2);

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(cnt1[i] - cnt2[i]);
        }

        System.out.println(ans);
    }

    public static int[] getAlphabetCnt(String str) {
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a'] += 1;
        }
        return cnt;
    }
}
