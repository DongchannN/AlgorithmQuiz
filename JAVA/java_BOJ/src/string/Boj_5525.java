package string;

import java.util.*;

public class Boj_5525 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int compareLen = (2 * n) + 1;

        int len = scanner.nextInt();

        String input = scanner.next();

        List<Integer> ansArr = new ArrayList<>();

        int cnt = 1;
        for (int i = 0; i < len-1 ; i++) {
            if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'I') {
                if (cnt >= (2 * n) + 1) {
                    ansArr.add(cnt);
                }
                cnt = 1;
            } else if (input.charAt(i) == 'O' && input.charAt(i + 1) == 'I' && i == len - 2) {
                cnt += 1;
                if (cnt >= (2 * n) + 1) {
                    ansArr.add(cnt);
                }
            } else if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && i == len - 2) {
                if (cnt >= (2 * n) + 1) {
                    ansArr.add(cnt);
                }
            } else if (input.charAt(i) == 'O' && input.charAt(i + 1) == 'I') {
                cnt += 1;
            } else if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O') {
                cnt += 1;
            } else if (input.charAt(i) == 'O' && input.charAt(i + 1) == 'O') {
                if (cnt >= (2 * n) + 1) {
                    ansArr.add(cnt - 1);
                }
                cnt = 0;
            }
        }
        int ans = 0;
        for (int i = 0; i < ansArr.size(); i++) {
            int plus = ((ansArr.get(i) - compareLen) / 2) + 1;
            ans += plus;
        }
        System.out.println(ans);
    }
}
