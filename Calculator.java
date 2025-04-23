package v3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    //속성
    private Double operationResult; // 스위치 연산문에 들어갈 계산이 가능한 피연산자
    private List<String> results = new ArrayList<>();
    private int operand;
    private char operator;
    private String result;

    //생성자 - 기본 생성자 사용중

    //기능
    public void calc(int v1, int v2, char op) {
        switch (op) {
            case '+':
                operationResult = (double) v1 + v2; //int로 받았기 때문에 double형으로 바꿔주고, 업캐스팅시켜줌.
                break;
            case '-':
                operationResult = (double) v1 - v2;
                break;
            case '*':
                operationResult = (double) v1 * v2;
                break;
            case '/':
                if (v2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다."); // 수학적 예외처리
                    break;
                }
                operationResult = (double) v1 / v2;
                break;
            default:
                System.out.println("op = " + op);
                System.out.println("switch-default error.");
        }
        saveOutput(operationResult);
    }


    private void saveOutput(Double operationResult) {
        String stringResult = Double.toString(operationResult);
        int naturalNumIdx = stringResult.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
        int decimalDigit = stringResult.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'

        // 자릿수 갯수 및 정수에 따른 출력 변화
        if ((decimalDigit == 1) && (stringResult.charAt(naturalNumIdx + 1) == '0')) { //소수점이 '0'인 정수일때
            stringResult = String.format("%d", (int) (double) operationResult);
        } else if (decimalDigit == 1) {
            stringResult = String.format("%.1f", operationResult);
        } else if (decimalDigit == 2) {
            stringResult = String.format("%.2f", operationResult);
        } else {
            stringResult = String.format("%.3f", operationResult);
            if (decimalDigit == 3 && stringResult.charAt(stringResult.length() - 1) == '0') {
                System.out.println();
                System.out.println("**반올림 결과 입니다. 정확하지 않을 수 있습니다.**");
                stringResult = String.format("%.2f", operationResult);
            }
            if (stringResult.equals("0.000")) {
                System.out.println();
                System.out.println("**너무 작은 숫자는 표현 힘들수 있습니다.**");
                stringResult = String.format("%.9e", operationResult);
            }
        }
        results.add(stringResult);
        result = stringResult;
    }

    public void setOperator(char operator) {

        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperand(int operand) {
        this.operand = operand;
    }

    public int getOperand() {
        return operand;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else System.out.println("저장 결과가 비어있습니다. 삭제 가능한 결과가 없습니다.");
    }


    public List<String> getResults() {
        return results;
    }

    public String getResult() {
        return result;
    }
}