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
        // 1). 비교하는 단어가 비교되는 단어의 앞 부분과 일치하는지 비교   EX) 일치하는 경우 예 : EXAM , EXAMPLE
        // 2). 1.에 해당되면 짧은 문자를 앞으로 정렬.
        // 3). 1.에 해당되지 않으면 첫번째 자리부터 문자를 비교. 문자가 같으면 그 다음 문자 비교해서 정렬.



        int arrLength = word.length;             //배열의 크기 = arrLength

        //word[0]를 word[i]와 i++하며 비교 후 자리 옮기기
        for (int i = 0; i < arrLength; i++) {
            for (int j = 0; j < arrLength - 1; j++) {

                //1). 비교하는 문자가 비교되는 문자보다 더 길며 1.에 해당되는 경우 자리 바꾸기 // 바꾼후 continue.
                if (word[j].length() > word[j + 1].length() && Objects.equals(word[j].substring(0, word[j+1].length()), word[j+1])) {
                    String saver = word[j];
                    word[j] = word[j + 1];
                    word[j + 1] = saver;
                    continue;
                }

                //3). 어느 부분에서 최초로 같은자리의 문자가 다른지 검사.  //errorCheck 값을 통한 에러 검사
                int index = 0;
                int errorCheck = 0; //StringIndexOutOfBoundException 검사 에러가 나는 경우 errorCheck에 1값을 넣어 다음 if문 진입 방해.
                while (true) {
                    if( index >= word[j].length() || index >= word[j + 1].length()) {
                        errorCheck = 1;
                        index -= 1;
                        break;
                    }
                    else if( word[j].charAt(index) == word[j + 1].charAt(index)) {
                        index += 1;

                    }

                    else if( word[j].charAt(index) != word[j + 1].charAt(index)) {

                        break;
                    }



                }
                //앞자리에 따른 단어 분류
                if(errorCheck != 1 && (int) word[j].charAt(index) > (int) word[j+1].charAt(index)) {     //StringIndexOutOfBoundException.
                    String saver = word[j];
                    word[j] = word[j+1];
                    word[j+1] = saver;
                }

            }
        }
        for (String s : word) {
            System.out.println(s);
        }
    }
}
