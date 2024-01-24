package recursion;

import java.io.*;
import java.util.*;

public class Boj_1182 {

    static int[] arr;
    static List<Integer> temp;
    static boolean[] visited;
    static int cnt;
    static int n;
    static int s;

    void checkS() {
        int sum = 0;
        for (int i : temp) {
            sum += i;
        }
        if (sum == s)
            cnt++;
    }

    void search(int depth, int beforeIdx) {
        if (depth != 0) checkS();
        if (depth == n) return ;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && beforeIdx < i) {
                temp.add(arr[i]);
                visited[i] = true;
                int idx = temp.size() - 1;
                search(depth + 1, i);
                temp.remove(idx);
                visited[i] = false;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        n = Integer.parseInt(input1[0]);
        s = Integer.parseInt(input1[1]);

        visited = new boolean[n];
        arr = new int[n];
        temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(input2[i]);


        cnt = 0;
        search(0, -1);

        System.out.println(cnt);
    }
}
