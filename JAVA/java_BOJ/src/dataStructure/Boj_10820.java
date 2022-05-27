package dataStructure;

import java.util.Scanner;

public class Boj_10820 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[4]; //{small letter, capital letter, number, space}
        String str = scanner.nextLine();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            int ascii = (int) str.charAt(i);
            if (64 <ascii && ascii < 91) {
                arr[1] += 1;
            }else if (96 <ascii && ascii < 123) {
                arr[0] += 1;
            }else if (str.charAt(i) == ' ') {
                arr [3] += 1;
            }else if (47 < ascii && ascii < 58) {
                arr[2] += 1;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++){
            ans.append(arr[i]);
            ans.append(' ');
        }
        System.out.println(ans);
    }
}
