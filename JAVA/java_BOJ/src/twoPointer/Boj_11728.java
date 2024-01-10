package twoPointer;

import java.io.*;

public class Boj_11728 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        String[] stringArr1 = br.readLine().split(" ");
        String[] stringArr2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++)
            arr1[i] = Integer.parseInt(stringArr1[i]);
        for (int i = 0; i < m; i++)
            arr2[i] = Integer.parseInt(stringArr2[i]);

        StringBuffer sb = new StringBuffer();
        int p1 = 0;
        int p2 = 0;
        while (p1 + p2 < n + m) {
            int num1;
            if (p1 < n) num1 = arr1[p1];
            else num1 = Integer.MAX_VALUE;
            int num2;
            if (p2 < m) num2 = arr2[p2];
            else num2 = Integer.MAX_VALUE;

            int pNum;
            if (num1 <= num2) {
                pNum = num1;
                p1++;
            } else {
                pNum = num2;
                p2++;
            }
            sb.append(pNum).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
