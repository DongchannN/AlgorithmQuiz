package dataStructure;
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj_10820 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while (true) {
            str = reader.readLine();
            //if (str == null) break;  -- doesn't work why??
            int[] arr = new int[4]; //{small letter, capital letter, number, space}
            int length = str.length();
            for (int i = 0; i < length; i++) {

                int ascii = (int) str.charAt(i);
                if (64 < ascii && ascii < 91) {
                    arr[1] += 1;
                } else if (96 < ascii && ascii < 123) {
                    arr[0] += 1;
                } else if (str.charAt(i) == ' ') {
                    arr[3] += 1;
                } else if (47 < ascii && ascii < 58) {
                    arr[2] += 1;
                }
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0 && arr[3] == 0) break;
            StringBuilder ans = new StringBuilder();

            for (int i = 0; i < 4; i++){
                ans.append(arr[i]);
                ans.append(' ');
            }
            System.out.println(ans);

        }

    }
}
