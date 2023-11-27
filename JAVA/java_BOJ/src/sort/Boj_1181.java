package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Boj_1181 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.length() < b.length()) return -1;
            else if (a.length() > b.length()) return 1;
            return a.compareTo(b);
        });

//        Arrays.sort(arr, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() == o2.length())
//                    return o1.compareTo(o2);
//                return o1.length() - o2.length();
//            }
//        });

//        for (int i = 0; i < n; i++) {
//            int print = 1;
//            for (int j = 0; j < i; j++) {
//                if (Objects.equals(arr[i], arr[j])) {
//                    print = 0;
//                    break;
//                }
//            }
//            if (print == 1) System.out.println(arr[i]);
//        }

        // 아래와 같이 직전 단어만 비교해도 됨.
        System.out.println(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!Objects.equals(arr[i], arr[i-1]))
                System.out.println(arr[i]);
        }
    }
}

