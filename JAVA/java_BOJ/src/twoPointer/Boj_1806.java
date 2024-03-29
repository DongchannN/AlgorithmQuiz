package twoPointer;

import java.io.*;

public class Boj_1806 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);

        Integer[] arr = new Integer[n];
        String[] stringArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringArr[i]);

        int ans = 100000;
        int j = 0;
        long sum = arr[0];
        for (int i = 0; i < n; i++) {
            while (i <= j && j < n - 1) {
                if (sum < s) {
                    j++;
                    sum += arr[j];
                } else {
                    ans = Math.min(ans, j - i + 1);
                    sum -= arr[i];
                    break;
                }
            }
            if (i <= j && j == n - 1 && sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= arr[i];
            }
        }

        if (ans == 100000) ans = 0;
        System.out.println(ans);
    }

    /**
     * solution() 조금 더 보기 쉽게 만든 코드.
     */
    public void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int s = Integer.parseInt(inputs[1]);

        Integer[] arr = new Integer[n];
        String[] stringArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(stringArr[i]);

        int ans = n + 1;
        int rightIdx = 0;
        int currentSum = arr[0];
        for (int i = 0; i < n; i++) {
            while (currentSum < s && rightIdx < n - 1)
                currentSum += arr[++rightIdx];
            if (currentSum >= s)
                ans = Math.min(ans, rightIdx - i + 1);
            currentSum -= arr[i];
        }
        if (ans > n) ans = 0;
        System.out.println(ans);
    }
}
