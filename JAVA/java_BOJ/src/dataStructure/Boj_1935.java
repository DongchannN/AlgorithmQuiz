package dataStructure;

import java.io.IOException;
import java.util.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;


public class Boj_1935 {
    public void solution() throws IOException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Scanner scanner = new Scanner(System.in);

        List<String> operators = new ArrayList<String>(Arrays.asList("+","-","/","*")); //사칙연산자
        List<String> listInputExpression = new ArrayList<>();

        HashMap<String,String> variableNumber = new HashMap<String, String>();

        int variableAmount;        //amount of variable

        String inputExpression;    //Expression
        String expressionSaver;
        String afterExpression;

        //input
        variableAmount = Integer.parseInt(scanner.nextLine());  //변수의 갯수 입력
        inputExpression = scanner.nextLine();                   //후위표기식 입력

        for (int i = 0; i < variableAmount; i+=1) {             //변수 (variableNumber)에 저장
            String inputNumber = scanner.nextLine();
            int asciiNumber = 65 + i;
            char ascii = (char)asciiNumber;
            variableNumber.put(Character.toString(ascii),inputNumber);
        }

        for (int index = 0; index < inputExpression.length(); index+=1) {
            listInputExpression.add(String.valueOf(inputExpression.charAt(index)));
        }

        int checkingIndex = 0;
        while (true) {
            if (operators.contains(listInputExpression.get(checkingIndex))) {  //(listInputExpression)의 (checkingIndex)번쨰 값이 사칙연산자이면
                expressionSaver = "("+listInputExpression.get(checkingIndex-2) + listInputExpression.get(checkingIndex) + listInputExpression.get(checkingIndex-1)+")";
                listInputExpression.remove(checkingIndex);
                listInputExpression.remove(checkingIndex-1);
                listInputExpression.remove(checkingIndex-2);
                listInputExpression.add(checkingIndex-2, expressionSaver);
                checkingIndex = 0;
            }else {
                checkingIndex += 1 ;
            }
            if (listInputExpression.size() == 1) {
                afterExpression = listInputExpression.get(0);
                break;
            }
        }

        for (int i = 0; i < variableAmount; i +=1) {
            int asciiNumber = 65 + i;
            char ascii = (char)asciiNumber;
            afterExpression = afterExpression.replaceAll(Character.toString(ascii), variableNumber.get(Character.toString(ascii)));
        }
        System.out.println(afterExpression);
        try {
            int result = (int) engine.eval(afterExpression);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
