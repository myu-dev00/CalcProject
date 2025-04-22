package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private Scanner sc = new Scanner(System.in);
    private Double result = null;
    private List<String> results = new ArrayList<>();
    private char op = ' ';

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */

    //    public 반환타입 calculate(...매개변수) {
//        /* 위 요구사항에 맞게 구현 */
//        /* return 연산 결과 */
//    }


    void calc(int v1, int v2, char op) {
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


    void save_output(Double result) {
        String rtStr = Double.toString(result);
        int naturalNumIdx = rtStr.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
        int decimalDigit = rtStr.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'
        String string_result;
        // 자릿수 갯수 및 정수에 따른 출력 변화
        if ((decimalDigit == 1) && (rtStr.charAt(naturalNumIdx + 1) == '0')) { //소수점이 '0'인 정수일때
            System.out.println("정수연산");
            string_result = String.format("%d", (int) (double) result);
        } else if (decimalDigit < 3) {
            System.out.println("소수점 3자리 연산");
            string_result = String.format("%f", result);
        } else {
            System.out.println("소수점 3자리 이상 연산");
            string_result = String.format("%.3f", result);
            if (string_result.equals("0.000")){
                System.out.println("와중에 수가 너무 적어요");
                string_result = String.format("%6f", result);
            }
        }
        results.add(string_result);
    }


    int inputNum() {
        String string_value = sc.nextLine();
        return isItPositive(string_value);
    }

    int isItPositive(String string_value) {
        for (int i = 0; i < string_value.length(); i++) {
            char ch = string_value.charAt(i);
            if (ch < '0' || ch >= '9') {
                System.out.println("0포함의 양의 정수를 입력하여 주세요.");
                return inputNum();
            }
        }
        return Integer.valueOf(string_value);
    }

    char inputOp() {
        String operator = sc.nextLine(); //char, 제일 처음만 받는 함수
        return isItOp(operator);
    }

    char isItOp(String operator) {
        if (operator.length() != 1) {
            System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
            inputOp();
        } else {
            op = operator.charAt(0);
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
                inputOp();
            }
        }
        return op;
    }

    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(0);
        } else System.out.println("저장 결과가 비어있습니다. 삭제 가능한 결과가 없습니다.");
    }


    String menu() {

        System.out.println("===========메뉴창===========");
        System.out.println("메뉴를 선택해 주십시오.\n" +
                "1. 더 계산하시겠습니까?(1 입력)\n" +
                "2. 결과물들을 출력하시겠습니까? (2 입력)\n" +
                "3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n" +
                "4. 종료하시겠습니까? (exit 입력)\n");

        String read_menu = sc.nextLine().trim();
        //리턴때도 null이 되니 오류가 뜸.
        System.out.println("read_menu = " + read_menu);
        switch (read_menu) {
            case "1":
                return "1";
            case "2":
                System.out.println(getResults());
                return menu();
            case "3":
                System.out.print("삭제 전 결과 저장 내역: ");
                System.out.println(getResults());
                removeResult();
                System.out.print("삭제 후 결과 저장 내역: ");
                System.out.println(getResults());
                return menu();
            case "exit":
                return read_menu;
            default:
                System.out.println("다시 입력하여 주세요.");
                return menu();
        }
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

    public void setResults(List<String> newResults) {
        this.results = newResults;
    }
}