package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.lang.StringIndexOutOfBoundsException;

public class Boj_11656 {
    public void solution() throws IOException, StringIndexOutOfBoundsException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        String[] inputGroup = new String[input.length()];

        for (int i = 0; i < input.length(); i++) {  // 접미사 단어 inputGroup 에 넣음.
            inputGroup[i] = input.substring(i);
        }

        SortingWord(inputGroup);

    }
    private void SortingWord(String[] word) {
        int arrLength = word.length;             //배열의 크기 = arrLength

        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength - 1; j++) {

                //앞자리에 따른 단어 분류
                if((int) word[j].charAt(0) > (int) word[j+1].charAt(0)) {
                    String saver = word[j];
                    word[j] = word[j+1];
                    word[j+1] = saver;
                }

                //앞자리가 같을 시
                else if((int) word[j].charAt(0) == (int) word[j+1].charAt(0)) {

                    //"word[j]의 길이 > word[j+1]의 길이" 이며 짧은 단어가 긴단어 앞부분에 포함 될 시 짧은 단어를 앞으로  EX) ON, ONLY (ON이 앞부분에 포함)
                    if ( word[j].length() > word[j+1].length()  &&  word[j+1] == word[j].substring(0, word[j+1].length() + 1) ){ // Objects.equals(word[j+1], word[j].substring(0, word[j+1].length() + 1))
                        String saver = word[j];
                        word[j] = word[j + 1];
                        word[j + 1] = saver;
                    }

                    else { //"word[j]의 길이 < word[j+1]의 길이"일 때 "OR word[j]의 길이 > word[j+1]의 길이"이지만 순서를 바꿀 필요가 없을 경우 EX) ORUNE, OGKDF 또는 ONLY, ON.
                        int index = 1;  //이미 첫자리 비교했으므로 두번째 알파뱃부터 비교.
                        //다른 글자가 나오면 index 에 저장 후 탈출. index 가 word의 인덱스를 넘어가면 break.
                        while ((int) word[j].charAt(index) == (int) word[j+1].charAt(index)) { //StringIndexOutOfBoundException.
                            index += 1;
                            if( index >= word[j].length() -1 || index >= word[j + 1].length() -1) break;
                        }
                        //저장된 인덱스 이용해 알파뱃 우선을 비교
                        if((int) word[j].charAt(index) > (int) word[j+1].charAt(index)) {
                            String saver = word[j];
                            word[j] = word[j+1];
                            word[j+1] = saver;
                        }
                    }
                }
            }
        }
        for (String s : word) {
            System.out.println(s);
        }
    }
}
