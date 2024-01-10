package twoPointer;

import java.io.*;

public class Boj_17609 {
    boolean checkPalindrome(String str) {
        int p1 = 0;
        int p2 = str.length() - 1;
        while (p1 < p2) {
            if (str.charAt(p1) == str.charAt(p2)) {
                p1++;
                p2--;
            } else return false;
        }
        return true;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            int ans = 0;
            int p1 = 0;
            int p2 = str.length() - 1;
            while (p1 < p2) {
                if (str.charAt(p1) == str.charAt(p2)) {
                    p1++;
                    p2--;
                } else {
                    if (checkPalindrome(str.substring(p1 + 1, p2 + 1)) || checkPalindrome(str.substring(p1, p2)))
                        ans = 1;
                    else ans = 2;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
