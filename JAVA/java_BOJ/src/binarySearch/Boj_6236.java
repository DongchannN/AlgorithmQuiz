package binarySearch;

import java.io.*;

public class Boj_6236 {
    int countWithdrawTimes(Integer[] arr, int money) {
        int pocket = money;
        int cnt = 1;
        for (int i : arr) {
            if (money - i < 0) return -1;
            if (pocket - i < 0) {
                pocket = money;
                cnt++;
            }
            pocket -= i;
        }
        return cnt;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Integer[] arr = new Integer[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int s = 0;
        int l = sum;
        int ans = sum + 1;
        while (s <= l) {
            int mid = (s + l) / 2;
            int cnt = countWithdrawTimes(arr, mid);
            if (cnt == -1 || cnt > m) {
                s = mid + 1;
            } else {
                l = mid - 1;
                ans = Math.min(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
