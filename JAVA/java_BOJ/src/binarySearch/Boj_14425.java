package binarySearch;

import java.util.*;
import java.io.*;

public class Boj_14425 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Set<String> groupS = new TreeSet<>();
        for (int i = 0; i < n; i++)
            groupS.add(br.readLine());

        String[] groupM = new String[m];
        for (int i = 0; i < m; i++)
            groupM[i] = br.readLine();

        int cnt = 0;
        for (int i = 0; i < m; i++)
            if (groupS.contains(groupM[i]))
                cnt++;
        System.out.println(cnt);
    }
}
