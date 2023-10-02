package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Boj_11068 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int check = 0;
            int num = Integer.parseInt(br.readLine());
            for (int base = 2; base < 65; base++) {
                int dNum = num;
                List<String> numArr = new ArrayList<>();
                while (dNum > 0){
                    numArr.add(String.valueOf(dNum % base));
                    dNum /= base;
                }
                if (checkNum(numArr) == 1) {
                    check = 1;
                    break;
                }
            }
            System.out.println(check);
        }
    }

    private int checkNum(List<String> num) {
        int rtn = 1;
        for (int i = 0; i < num.size() / 2; i++) {
            if (!Objects.equals(num.get(i), num.get(num.size() - 1 - i)))
                rtn = 0;
        }
        return rtn;
    }
}
