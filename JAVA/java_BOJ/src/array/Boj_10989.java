package array;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Boj_10989 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int k = 0; k < 10001; k++) {
            while (arr[k] != 0) {
                bw.write(String.valueOf(k));
                bw.newLine();
                arr[k]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
