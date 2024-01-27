package recursion;

import java.io.*;
import java.util.*;

public class Boj_16987 {

    static List<Egg> eggs;
    static int n;
    static int ans = 0;

    static class Egg {
        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        void hitEgg(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        void restoreEgg(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }
    }

    void recursion(int now) {
        if (now == n) {
            int cnt = 0;
            for (Egg egg : eggs)
                if (egg.durability <= 0)
                    cnt++;
            ans = Math.max(cnt, ans);
            return ;
        }

        // if picked egg is broken, pick next egg
        if (eggs.get(now).durability <= 0)
            recursion(now + 1);
        else {
            boolean eggExist = false;
            // if egg is not broken, hit the egg.
            for (int i = 0; i < n; i++) {
                // cannot hit myself or broken egg
                if (i == now || eggs.get(i).durability <= 0) continue;
                eggExist = true;
                eggs.get(now).hitEgg(eggs.get(i));
                recursion(now + 1);
                eggs.get(now).restoreEgg(eggs.get(i));
            }
            if (!eggExist) recursion(now + 1);
        }
    }

    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        eggs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int d = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            eggs.add(new Egg(d, w));
        }

        recursion(0);
        System.out.println(ans);
    }
}
