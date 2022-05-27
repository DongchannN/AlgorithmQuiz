package dataStructure;

import java.util.Scanner;

public class Boj_11655 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder buildingInput = new StringBuilder();
        buildingInput.append(input);
        for (int i = 0; i < input.length(); i++) {
            int nowAsciiNumber = input.charAt(i);
            int changedAsciiNumber;
            char changedAlphabet;
            if ((64 < nowAsciiNumber && nowAsciiNumber < 78) || (96 < nowAsciiNumber && nowAsciiNumber < 110)){
                changedAsciiNumber = nowAsciiNumber + 13;
                changedAlphabet = (char) changedAsciiNumber;
                buildingInput.setCharAt(i, changedAlphabet);

            }else if ((77 < nowAsciiNumber && nowAsciiNumber < 91) || (109 < nowAsciiNumber && nowAsciiNumber < 123)) {
                changedAsciiNumber = nowAsciiNumber - 13;
                changedAlphabet = (char) changedAsciiNumber;
                buildingInput.setCharAt(i, changedAlphabet);
            }else {
                continue;
            }
        }
        System.out.println(buildingInput);
    }
}
