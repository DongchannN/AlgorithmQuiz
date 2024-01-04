package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_2805 {
    long getHighestHeight(Long[] arr, long from, long to, long num) {
        long s = from;
        long l = to;
        long rtn = 0;
        while (s <= l){
            long m = (s + l) / 2;
            long treeLength = 0;
            for (Long i : arr)
                treeLength += Math.max(i - m, 0);
            if (treeLength >= num) {
                s = m + 1;
                if (rtn < m) rtn = m;
            } else {
                l = m - 1;
            }
        }
        return rtn;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long m = Integer.parseInt(s[1]);

        String[] s1 = br.readLine().split(" ");
        Long[] trees = new Long[n];
        long highestTree = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Long.parseLong(s1[i]);
            if (highestTree < trees[i]) highestTree = trees[i];
        }
        long ans = getHighestHeight(trees, 0, highestTree, m);
        System.out.println(ans);
    }
}
