package sort;

import java.io.*;
import java.util.*;

public class Boj_7785 { // Set 이용

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>(); // TreeSet 을 사용하게 되면 정렬을 할 수 있음.

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            if (Objects.equals(s[1], "enter")) set.add(s[0]);
            else set.remove(s[0]);
        }
        Object[] objects = set.toArray();
        Arrays.sort(objects, (a, b) -> -a.toString().compareTo(b.toString()));
        for (int i = 0; i < objects.length; i++)
            System.out.println(objects[i].toString());
    }
}
