package greedy;

import java.io.*;

public class Boj_1041 {
    static String[] canCombine3 = {"013", "021","042", "034","513", "521","542", "534"};
    static String[] canCombine2 = {"01", "02","03", "04","51", "52","53", "54", "21", "24","31", "34"};
    static long min1 = 51;
    static long min2 = 51 * 2;
    static long min3 = 51 * 3;

    static void makeCombination(int[] dice) {
        for (int i = 0; i < dice.length; i++) {
            min1 = Math.min(min1, dice[i]);
        }
        for (int i = 0; i < canCombine2.length; i++) {
            String[] s = canCombine2[i].split("");
            int num = dice[Integer.parseInt(s[0])] + dice[Integer.parseInt(s[1])];
            min2 = Math.min(min2, num);
        }
        for (int i = 0; i < canCombine3.length; i++) {
            String[] s = canCombine3[i].split("");
            int num = dice[Integer.parseInt(s[0])] + dice[Integer.parseInt(s[1])] + dice[Integer.parseInt(s[2])];
            min3 = Math.min(min3, num);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(s[i]);
        }

        makeCombination(dice);
        long amount3 = 4;
        long amount2 = 4L * (n - 2) + 4L * (n - 1);
        long amount1 = (long) (n - 2) * (n - 2) + 4L * (n - 2) * (n - 1);

        if (n == 1) {
            int sum = 0;
            int max = 0;
            for (int d : dice) {
                sum += d;
                max = Math.max(max, d);
            }
            System.out.println(sum - max);
        } else {
            System.out.println(amount3 * min3 + amount2 * min2 + amount1 * min1);
        }
    }
}
