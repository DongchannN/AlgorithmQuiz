package recursion;

import java.util.*;
import java.io.*;

public class Boj_14888 {

    static boolean[] visited;
    static List<Character> temp;
    List<Character> operatorArr;
    static int[] arr;
    static int min;
    static int max;
    static int n;

    int calculateArr() {
        int ret = arr[0];
        for (int i = 1; i < n; i++) {
            int now = arr[i];
            char operator = temp.get(i - 1);
            if (operator == '+') ret += now;
            else if (operator == '-') ret -= now;
            else if (operator == '*') ret *= now;
            else ret /= now;
        }
        return ret;
    }
    void findMinAndMax(int depth) {
        if (depth == n - 1) {
            int ret = calculateArr();
            min = Math.min(ret, min);
            max = Math.max(ret, max);
            return ;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!visited[i]) {
                temp.add(operatorArr.get(i));
                visited[i] = true;
                int idx = temp.size() - 1;

                findMinAndMax(depth + 1);
                temp.remove(idx);
                visited[i] = false;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        String[] strOperators = br.readLine().split(" ");

        arr = new int[n];
        visited = new boolean[n - 1];
        int[] operatorAmount = new int[4];
        temp = new ArrayList<>();
        operatorArr = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(strArr[i]);
        for (int i = 0; i < 4; i++)
            operatorAmount[i] = Integer.parseInt(strOperators[i]);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operatorAmount[i]; j++) {
                if (i == 0) operatorArr.add('+');
                else if (i == 1) operatorArr.add('-');
                else if (i == 2) operatorArr.add('*');
                else operatorArr.add('/');
            }
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        findMinAndMax(0);

        System.out.println(max);
        System.out.println(min);
    }
}
