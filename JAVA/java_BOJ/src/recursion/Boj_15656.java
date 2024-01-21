package recursion;

import java.io.*;
import java.util.Arrays;

public class Boj_15656 {

    int n, m;
    static int[] arr;
    static int[] print;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    void printArr(int depth) throws IOException{
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : print)
                sb.append(i + " ");
            sb.append("\n");
            bw.write(sb.toString());
            return ;
        }

        for (int i = 0; i < n; i++) {
            print[depth] = arr[i];
            printArr(depth + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        String[] strArr = br.readLine().split(" ");
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);

        Arrays.sort(arr);
        print = new int[m];
        printArr(0);

        bw.flush();
        bw.close();
    }
}
