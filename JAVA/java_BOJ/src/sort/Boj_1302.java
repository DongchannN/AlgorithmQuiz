package sort;

import java.util.*;
import java.io.*;

public class Boj_1302 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> sailedBook = new HashMap<>();
        String bestSeller = null;
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            String bookName = br.readLine();
            Integer sailedCnt = sailedBook.get(bookName);
            if (sailedCnt == null) sailedCnt = 0;
            if (sailedCnt + 1 > maxCnt) maxCnt = sailedCnt + 1;
            sailedBook.put(bookName, sailedCnt + 1);
        }

        int flag = 0;
        for (String s : sailedBook.keySet()) {
            if (maxCnt == sailedBook.get(s) && flag == 0) {
                flag = 1;
                bestSeller = s;
            }
            if (maxCnt == sailedBook.get(s) && flag == 1)
                if (bestSeller.compareTo(s) > 0) bestSeller = s;
        }
        System.out.println(bestSeller);
    }
}
