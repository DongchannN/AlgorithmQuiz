package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2910 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int c = Integer.parseInt(s1[1]);

        Map<Integer, Integer> cntMap = new HashMap<>();
        String[] s2 = br.readLine().split(" ");
        Integer[] intArr = new Integer[n];
        int idx = 0;
        for (String s : s2) {
            int i = Integer.parseInt(s);
            if (cntMap.get(i) == null || cntMap.get(i) == 0)
                cntMap.put(i, 1);
            else {
                int cnt = cntMap.get(i);
                cntMap.put(i, cnt + 1);
            }
            intArr[idx] = i;
            idx++;
        }
        List<Integer> copiedList = new ArrayList<>(Arrays.asList(intArr));
        Arrays.sort(intArr, (a, b) -> {
            if (cntMap.get(a) == cntMap.get(b))
                return copiedList.indexOf(a) - copiedList.indexOf(b);
            else return cntMap.get(b) - cntMap.get(a);
        });
        for (int i = 0; i < n; i++)
            System.out.printf("%d ", intArr[i]);
    }
}
