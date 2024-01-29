package recursion;

import java.io.*;
import java.util.*;

public class Boj_10597 {

    boolean[] check;
    int[] nums;
    int[] output;
    int max;
    int len;
    boolean printed = false;

    void recursion(int depth, int idx) {
        if (printed) return ;
        if (depth == max || idx == len) {
            boolean canPrint = true;
            for (boolean b : check)
                if (!b) {
                    canPrint = false;
                    break;
                }
            if (canPrint) {
                for (int i : output)
                    System.out.printf("%d ", i);
                System.out.println();
                printed = true;
            }
            return ;
        }

        int now = nums[idx];
        if (now > 0 && !check[now - 1]){
            check[now - 1] = true;
            output[depth] = now;
            recursion(depth + 1, idx + 1);
            output[depth] = 0;
            check[now - 1] = false;
        }

        if (idx < len - 1){
            now = nums[idx] * 10 + nums[idx + 1];
            if (now <= max && now > 0 && !check[now - 1]){
                check[now - 1] = true;
                output[depth] = now;
                recursion(depth + 1, idx + 2);
                output[depth] = 0;
                check[now - 1] = false;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        len = input.length();
        if (len <= 9)
            max = len;
        else
            max = 9 + (len - 9) / 2;

        nums = new int[len];
        output = new int[max];
        check = new boolean[max];

        for (int i = 0; i < len; i++)
            nums[i] = Integer.parseInt(String.valueOf(input.charAt(i)));

        recursion(0, 0);
    }
}
