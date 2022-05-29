package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_10824 {
    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str[] = bf.readLine().split(" ");
        String a = str[0];
        String b = str[1];
        String c = str[2];
        String d = str[3];

        long num1 = Long.parseLong(a + b);
        long num2 = Long.parseLong(c + d);
        System.out.println(num1+num2);
    }
}
