package binarySearch;

import java.io.*;

public class Boj_1654 {
    long cutLines(Long[] arr, long lineLen) {
        long amount = 0L;
        if (lineLen == 0)
            return (2^32)-1;
        for (long line : arr)
            amount += (line / lineLen);
        return amount;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int k = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        Long[] lines = new Long[k];
        Long longestLine = 0L;
        for (int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
            if (longestLine < lines[i]) longestLine = lines[i];
        }

        long ans = 0;
        long a = 0;
        long b = longestLine;
        while (a <= b) {
            long m = (a + b) / 2;
            long amount = cutLines(lines, m);
            if (amount < n) {
                b = m - 1;
            } else {
                a = m + 1;
                ans = Math.max(ans, m);
            }
        }
        System.out.println(ans);
    }
}
