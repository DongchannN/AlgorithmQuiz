package dp_2;

import java.io.*;

public class Boj_2011 {
    static int[][] dp;
    static int len;
    static String str;
    static boolean canBeAlphabet(int i, int idx) {
        String s;
        if (i == 0)
            s = str.substring(idx, idx + 1);
        else
            s = str.substring(idx - 1, idx + 1);
        if (s.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(s);
        return (1 <=num && num <= 26);
    }

    static int recursion(int i, int j) {
        if (j < 0 || j > len)
            return 0;
        if (j > 0 && !canBeAlphabet(i, j - 1))
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (j == len) {
            return 1;
        }
        dp[i][j] = recursion(0, j + 1) + recursion(1, j + 2);
        return (dp[i][j] % 1000000);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
        dp = new int[2][len + 1];
        int ans = recursion(0, 0);
        System.out.println(ans);
    }
}
