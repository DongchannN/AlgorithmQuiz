package binarySearch;

import java.util.*;

public class Boj_2295 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        int[] numArr = new int[number];

        for (int i = 0; i < number; i++) {
            numArr[i] = scanner.nextInt();
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int x = numArr[i];
            for (int j = i; j < number; j++) {
                int y = numArr[j];
                list.add(x + y);
            }
        }

        Collections.sort(list);
        int ans = 0;

        for (int i = numArr.length - 1; i >= 0; i--) {
            int k = numArr[i];
            for (int j = i; j >= 0; j--) {
                int z = numArr[j];
                int sub = k - z;

                if (isContain(sub, list) && ans < k) {
                    ans = k;
                }
            }
        }

        System.out.println(ans);


    }

    public boolean isContain(int num, List<Integer> arr) {
        int lastIdx = arr.size() - 1;
        int firstIdx = 0;
        while (firstIdx < lastIdx) {
            int idx = (lastIdx + firstIdx) / 2;

            if (arr.get(idx) == num) {
                return true;
            } else if (arr.get(idx) > num) {
                lastIdx = idx-1;
            } else firstIdx = idx+1;
        }

        return false;
    }
}
