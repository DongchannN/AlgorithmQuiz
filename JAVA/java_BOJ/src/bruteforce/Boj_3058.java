package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Boj_3058 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String[] input = br.readLine().split(" ");
            List<Integer> list = Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList());
            int minEven = 0;
            int sum = 0;
            for (Integer integer : list) {
                if (integer % 2 == 0) {
                    sum += integer;
                    if (minEven == 0 || minEven > integer)
                        minEven = integer;
                }
            }
            System.out.printf("%d %d\n", sum, minEven);
        }
    }
}
