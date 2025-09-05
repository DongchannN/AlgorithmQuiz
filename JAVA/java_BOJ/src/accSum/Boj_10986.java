package accSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10986 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] lineInfo = br.readLine().split(" ");
        final int n = Integer.parseInt(lineInfo[0]);
        final int m = Integer.parseInt(lineInfo[1]);
        final long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        final long[] accArr = new long[arr.length];
        final long[] cnts = new long[m];
        accArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            accArr[i] = accArr[i - 1] + arr[i];
        }
        for (int i = 0; i < accArr.length; i++) {
            int modular = (int) (accArr[i] % m);
            cnts[modular]++;
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            long cnt = cnts[i];
            final long sum = (cnt * (cnt - 1)) / 2;
            ans += sum;
        }
        ans += cnts[0];
        System.out.println(ans);
    }
}
