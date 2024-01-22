package recursion.tree;

import java.io.*;
import java.util.*;

public class Boj_14267 {

    static List<Integer>[] tree;
    static int[] save;
    void addPoint(int nowNode) {
        List<Integer> nextNodes = tree[nowNode];
        for (int next : nextNodes) {
            save[next] += save[nowNode];
            addPoint(next);
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] parent = new int[n + 1];
        tree = new ArrayList[n + 1];
        save = new int[n + 1];

        for (int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        String[] strParent = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            parent[i] = Integer.parseInt(strParent[i - 1]);
            if (i != 1)
                tree[parent[i]].add(i);
        }

        for (int i = 0; i < m; i++) {
            String[] input2 = br.readLine().split(" ");
            int node = Integer.parseInt(input2[0]);
            int point = Integer.parseInt(input2[1]);
            save[node] += point;
        }

        addPoint(1);

        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++)
            sb.append(save[i] + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
