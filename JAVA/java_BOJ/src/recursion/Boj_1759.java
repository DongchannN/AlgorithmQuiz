package recursion;

import java.io.*;
import java.util.*;

public class Boj_1759 {
    static char[] arr;
    static List<Character> vowel = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static List<Character> temp = new ArrayList<>();
    static int l;
    static int c;
    static int vowelCnt = 0;
    static int consonantCnt = 0;

    void recursion(int idx) {
        if (vowelCnt >= 1 && consonantCnt >= 2 && temp.size() == l) {
            for (char c : temp)
                System.out.printf("%c", c);
            System.out.println();
            return ;
        }
        if (idx == c) return;
        if (vowel.contains(arr[idx])) vowelCnt++;
        else consonantCnt++;
        temp.add(arr[idx]);
        int i = temp.size() - 1;
        recursion(idx + 1);
        temp.remove(i);
        if (vowel.contains(arr[idx])) vowelCnt--;
        else consonantCnt--;

        recursion(idx + 1);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        l = Integer.parseInt(input1[0]);
        c = Integer.parseInt(input1[1]);

        arr = new char[c];
        for(int i = 0; i < c; i++)
            arr[i] = input2[i].charAt(0);

        Arrays.sort(arr);

        recursion(0);
    }
}
