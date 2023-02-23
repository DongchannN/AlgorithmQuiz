package dfs;

import java.util.*;

public class Boj_1654 {
    static long[] have;
    static int k;
    static int n;

    static long min;
    static List<Long> ansArr;
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        n = scanner.nextInt();

        have = new long[k];
        ansArr = new ArrayList<>();

        long sum = 0;
        for (int i = 0; i < k; i++) {
            have[i] = scanner.nextInt();
            sum += have[i];
        }
//        802 + 742 + 457 + 539 = 2540
//                2540 / 11 230
        long maxLen = sum / n;
        min = 0;
        searchLen(maxLen+1);

        System.out.println(min-1);
    }

    private void searchLen(long maxLen) {
        long middle = ((min + maxLen) / 2);
        int howMuch = checkNum(middle);
        if (maxLen <= min) {
            return;
        }
        if (howMuch < n) {
            maxLen = middle;
            searchLen(maxLen);
        } else if (howMuch >= n) {
            min = middle + 1;
            searchLen(maxLen);
        }
    }

    private int checkNum(long len) {
        int num = 0;
        for (int i = 0; i < k; i++) {
            num += (have[i] / len);
        }
        return num;
    }
}
