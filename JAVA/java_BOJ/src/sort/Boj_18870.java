package sort;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Boj_18870 {
    public void solution() throws IOException { // 해당 숫자보다 작은 원소의 개수 카운트
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        /**
         * 아래 방법 O(N^2) -> 시간 초과
         */
        // -10 -9 2 4 4
//        String[] s = br.readLine().split(" ");
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++)
//            set.add(Integer.parseInt(s[i]));
//
//        List<Integer> list = set.stream().sorted().collect(Collectors.toList());

//        for (String str : s)
//            System.out.printf("%d ", list.indexOf(Integer.parseInt(str)));
//        System.out.println();

        /**
          * 새로운 방법 -> 이중 배열을 이용하여 숫자와 들어온 순서를 동시에 저장
          */
        String[] s = br.readLine().split(" ");
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(s[i]);
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        int idx = 0;
        ans[arr[0][1]] = idx;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] != arr[i - 1][0]) idx++;
            ans[arr[i][1]] = idx;
        }

        for (int a : ans)
            System.out.printf("%d ", a);
        System.out.println();

        for (int a : ans) {
            bw.write(a + '0');
            bw.write(" ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
