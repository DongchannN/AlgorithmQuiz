package dataStructure;

import java.io.*;
import java.util.*;

public class Boj_1068 {
    static List<Integer>[] map;

    static void deleteNode(int deletedNode) {
        for (int i = 0; i < map[deletedNode].size(); i++) {
            deleteNode(map[deletedNode].get(i));
        }
        map[deletedNode].clear();
        map[deletedNode].add(-1);
    }
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int deletedNode = Integer.parseInt(br.readLine());
        List<Integer> rootNodes = new ArrayList<>();
        map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int pNode = Integer.parseInt(input[i]);
            if (pNode == -1) {
                rootNodes.add(i);
                continue;
            }
            map[pNode].add(i);
        }
        deleteNode(deletedNode);

        int ans = 0;
        for (List<Integer> list : map) {
            if (list.isEmpty()) {
                ans++;
                continue;
            }
            if (list.size() == 1 && list.get(0) == deletedNode) ans++;
        }
        for (int rootNode : rootNodes) {
            if (ans == 0
                    && !(map[rootNode].size() == 1 && map[rootNode].get(0) == -1)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
