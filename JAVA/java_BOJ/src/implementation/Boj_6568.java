package implementation;

import java.io.*;

import static java.lang.System.exit;

public class Boj_6568 {
    static String[] memories;
    static int pc, sum, exit = 0;

    static int convertLineToCmd(String line) {
        String strCmd = line.substring(0, 3);
        int i = Integer.parseInt(strCmd, 2);
        return i;
    }

    static int convertLineToVal(String line) {
        String strCmd = line.substring(3, 8);
        int val = Integer.parseInt(strCmd, 2);
        return val;
    }

    static String intToEightBitsString(int num) {
        String str = Integer.toBinaryString(num);
        int l = 8 - str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++)
            sb.append("0");
        sb.append(str);
        return sb.toString();
    }

    static void nextJob() {
        String readLine = memories[pc];
        int cmdIdx = convertLineToCmd(readLine);
        int val = convertLineToVal(readLine);
        pc++;
        if (pc == 32) pc = 0;
        if (cmdIdx == 0) {
            memories[val] = intToEightBitsString(sum);
        } else if (cmdIdx == 1) {
            sum = Integer.parseInt(memories[val], 2);
        } else if (cmdIdx == 2 && sum == 0) {
            pc = val;
        } else if (cmdIdx == 3) {
            // nothing
        } else if (cmdIdx == 4) {
            sum--;
            if (sum < 0) sum = 255;
        } else if (cmdIdx == 5) {
            sum++;
            if (sum > 255) sum = 0;
        } else if (cmdIdx == 6) {
            pc = val;
        } else if (cmdIdx == 7) {
            System.out.println(intToEightBitsString(sum));
            exit = 1;
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            memories = new String[32];
            for (int i = 0; i < 32; i++) {
                if ((memories[i] = br.readLine()) == null)
                    exit(0);
            }
            exit = 0;
            pc = 0;
            sum = 0;
            while (exit == 0)
                nextJob();
        }
    }
}
