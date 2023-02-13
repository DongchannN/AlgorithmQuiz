package string;

import java.util.*;
public class Boj_2149 {
    static int depth;
    static int length;
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        String key = scanner.next();
        String input = scanner.next();
        char[] changedKeyArr = key.toCharArray();

        length = key.length();
        depth = input.length() / key.length();
        char[][] arr = new char[depth+1][length];

        Arrays.sort(changedKeyArr);

        String changedKey = new String(changedKeyArr);

        for (int i = 0; i < depth+1; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (i == 0) {
                    arr[i][j] = changedKey.charAt(j);
                } else {
                    int idx = ((depth) * (j)) + (i-1);
                    arr[i][j] = input.charAt(idx);
                }
            }
        }

        for (int i = 0; i < key.length(); i++) {
            int originIdx = i;
            for (int j = i; j < key.length(); j++) {
                if (key.charAt(i) == arr[0][j]) {
                    int movedIdx = j;
                    swapArr(movedIdx, originIdx, arr);
                    break;
                }
            }
        }

        String[] ansList = new String[depth];
        for (int i = 1; i < depth + 1; i++) {
            ansList[i - 1] = new String(arr[i]);
        }
        String ans = String.join("", ansList);
        System.out.println(ans);

//        for (int i = 1; i < depth+1; i++) {
//            for (int j = 0; j < length; j++) {
//                System.out.print(arr[i][j]);
//            }
//        }

    }

    public void swapArr(int nowIdx, int insertIdx, char[][] arr) {
        if (nowIdx == insertIdx) {
            return;
        }
        int totalDepth = depth + 1;
        for (int i = 0; i < totalDepth; i++) {
            char temp = arr[i][nowIdx];
            for (int j = nowIdx; j > insertIdx; j--) {
                arr[i][j] = arr[i][j - 1];
            }
            arr[i][insertIdx] = temp;
        }
    }
}
