package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Boj_10814 {

    static class Info implements Comparable<Info>{
        int age;
        String name;

        public Info(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Info o) { // Arrays.sort(info); 와 같이 간단하게 정렬 가능함.
            return this.age - o.age;
        }
    }

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Info[] arr = new Info[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i] = new Info(Integer.parseInt(s[0]), s[1]);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a.age));

        for (int i = 0; i < n; i++) {
            System.out.printf("%d %s\n", arr[i].age, arr[i].name);
        }
    }
}
