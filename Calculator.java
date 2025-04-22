package Level2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private Scanner sc = new Scanner(System.in);
    private Double result = null;
    private List<String> results = new ArrayList<>();
    private char op = ' ';
    private List<Integer> values = new ArrayList<>();


    /*사칙연산 메서드*/
    public void calc() {
        int v1 = values.get(0);
        int v2 = values.get(1);

        switch (op) {
            case '+':
                result = (double) v1 + v2;
                break;
            case '-':
                result = (double) v1 - v2;
                break;
            case '*':
                result = (double) v1 * v2;
                break;
            case '/':
                if (v2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                result = (double) v1 / v2;
                break;
            default:
                System.out.println("op = " + op);
                System.out.println("switch-default error.");
        }
        save_output(result);
    }

    /*결과 저장 메서드*/
    private void save_output(Double result) {
        String string_result = Double.toString(result);
        int naturalNumIdx = string_result.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
        int decimalDigit = string_result.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'

        // 자릿수 갯수 및 정수에 따른 출력 변화
        if ((decimalDigit == 1) && (string_result.charAt(naturalNumIdx + 1) == '0')) { //소수점이 '0'인 정수일때
            string_result = String.format("%d", (int) (double) result);
        } else if (decimalDigit == 1) {
            string_result = String.format("%.1f", result);
        } else if (decimalDigit == 2) {
            string_result = String.format("%.2f", result);
        } else {
            string_result = String.format("%.3f", result);
            if(string_result.charAt(string_result.length() - 1) == '0') {
                System.out.println("**반올림 결과 입니다. 정확하지 않을 수 있습니다.**");
                string_result = String.format("%.2f", result);
            }
            if (string_result.equals("0.000")) {
                System.out.println("**너무 작은 숫자는 표현 힘들수 있습니다.**");
                string_result = String.format("%e", result);
            }
        }
        results.add(string_result);
    }

    /*숫자 넣는 것 + 유효성 검사*/
    public void setNum() {
        boolean flag = true;
        while (flag) {
            String string_value = sc.nextLine();
            if (string_value.isEmpty()) {
                System.out.print("0 포함의 양의 정수를 입력해주세요: ");
                flag = true;
                continue;
            }
            if (isItPositive(string_value)) {
                values.add(Integer.parseInt(string_value));
                flag = false;
            }
        }
    }

    private boolean isItPositive(String string_value) {
        for (int i = 0; i < string_value.length(); i++) {
            char ch = string_value.charAt(i); //idx넘버가 필요하여 클래식 for문 사용
            if (ch < '0' || ch > '9') {
                System.out.print("0포함의 양의 정수를 입력하여 주세요: ");
                return false;
            }
        }
        return true;
    }



    public void setOp() {
        boolean flag = true;
        while (flag) {
            String string_operator = sc.nextLine();
            if (string_operator.isEmpty()) {
                System.out.print(" +, -, *, / 중 하나를 입력 부탁드립니다: ");
                flag = true;
                continue;
            }
            if (isItOp(string_operator)) {
                op = string_operator.charAt(0);
                flag = false;
            }
        }
    }

    private boolean isItOp(String operator) {
        if (operator.length() != 1) {
            System.out.print("잘못된 연산자 입니다. +, -, *, / 중 하나를 입력 부탁드립니다: ");
            return false;
        } else {
            op = operator.charAt(0);
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.print("잘못된 연산자 입니다. +, -, *, / 중 하나를 입력 부탁드립니다: ");
                return false;
            }
        }
        return true;
    }


    // remove / getter / setter
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else System.out.println("저장 결과가 비어있습니다. 삭제 가능한 결과가 없습니다.");
    }

    public void removeValues() {
        if (!values.isEmpty()) {
            values.remove(0);
        } else System.out.println("저장 결과가 비어있습니다. 삭제 가능한 결과가 없습니다.");
    }

    public List<String> getResults() {
        if (results.isEmpty()) {
            return null;
        }
        return new ArrayList<>(results);
    }

    public String getResult() {
        if (results.isEmpty()) {
            return null;
        }
        return results.get(results.size() - 1);
    }

    public Integer getValue(int idx) {
        if (values.isEmpty()) {
            return null;
        }
        return values.get(idx);
    }

    public char getOp() {
        return op;
    }
}