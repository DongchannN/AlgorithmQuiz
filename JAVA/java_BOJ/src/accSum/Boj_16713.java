package accSum;

import java.io.*;

public class Boj_16713{
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);

        int[] arr = new int[n + 1];
        String[] strArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i + 1] = Integer.parseInt(strArr[i]);

        int[] acc = new int[n + 1];
        acc[1] = arr[1];
        for (int i = 2; i < n + 1; i++)
            acc[i] = acc[i - 1] ^ arr[i];

        int[] queryAns = new int[q];
        for (int i = 0; i < q; i++) {
            String[] query = br.readLine().split(" ");
            int xor = acc[Integer.parseInt(query[0]) - 1] ^ acc[Integer.parseInt(query[1])];
            queryAns[i] = xor;
        }

        int ans = 0;
        for (int a : queryAns)
            ans ^= a;
        System.out.println(ans);
    }
}
