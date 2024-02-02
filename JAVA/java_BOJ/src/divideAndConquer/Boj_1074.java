package divideAndConquer;

import java.io.*;
import java.util.*;

public class Boj_1074 {

    int r;
    int c;
    int startRow = 1;
    int endRow;
    int startCol = 1;
    int endCol;
    int rangeStart = 1;
    int rangeEnd;

    void updateRange() {
        int len = endCol - startCol + 1;
        int range = rangeEnd - rangeStart + 1;
        // 1사분면인 경우
        if (r <= startRow + (len / 2) - 1
                && c <= startCol + (len / 2) - 1) {
            endRow = startRow + (len / 2) - 1;
            endCol = startCol + (len / 2) - 1;
            rangeEnd = rangeStart + (range / 4) - 1;
        }
        // 2사분면인 경우
        if (r <= startRow + (len / 2) - 1
                && c > startCol + (len / 2) - 1) {
            endRow = startRow + (len / 2) - 1;
            startCol = startCol + (len / 2);
            rangeStart = rangeStart + (range / 4);
            rangeEnd = rangeStart +  ((range / 4) - 1);
        }
        // 3사분면인 경우
        if (r > startRow + (len / 2) - 1
                && c <= startCol + (len / 2) - 1) {
            startRow = startRow + (len / 2);
            endCol = startCol + (len / 2) - 1;
            rangeStart = rangeStart + (range / 4) * 2;
            rangeEnd = rangeStart + ((range / 4) - 1);
        }
        // 4사분면인 경우
        if (r > startRow + (len / 2) - 1
                && c > startCol + (len / 2) - 1) {
            startRow = startRow + (len / 2);
            startCol = startCol + (len / 2);
            rangeStart = rangeStart + (range / 4) * 3;
            rangeEnd = rangeStart + ((range / 4) - 1);
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
        r++;
        c++;

        endRow = (int) Math.pow(2, n);
        endCol = (int) Math.pow(2, n);
        rangeEnd = endRow * endCol;

//        System.out.println("rangeStart : " + rangeStart + ", rangeEnd : " + rangeEnd + ", range : " + (rangeEnd - rangeStart + 1));
        while (rangeStart != rangeEnd) {
            updateRange();
//            System.out.println("rangeStart : " + rangeStart + ", rangeEnd : " + rangeEnd + ", range : " + (rangeEnd - rangeStart + 1));
        }
        System.out.println(rangeEnd - 1);
    }
}
