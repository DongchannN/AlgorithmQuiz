package binarySearch;

import java.io.*;
import java.util.Arrays;

public class Boj_14425_2 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        String[] comparedArr = new String[n];
        String[] arr = new String[m];
        for (int i = 0; i < n; i++)
            comparedArr[i] = br.readLine();
        for (int i = 0; i < m; i++)
            arr[i] = br.readLine();
        Arrays.sort(comparedArr);

        int ans = 0;
        for (String str : arr)
            if (isExist(comparedArr, str)) ans++;
        System.out.println(ans);
    }

    boolean isExist(String[] comparedArr, String str) {
        int s = 0;
        int l = comparedArr.length - 1;
        while (s <= l) {
            int m = (s + l) / 2;
            int res = comparedArr[m].compareTo(str);
            if (res > 0)
                l = m - 1;
            else if (res < 0)
                s = m + 1;
            else return true;
        }
        return false;
    }
}
