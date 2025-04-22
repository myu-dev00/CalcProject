package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    Scanner sc = new Scanner(System.in);
    Double result = null;
    List<Double> results = new ArrayList();
    //   private Scanner sc;

    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */

    //    public 반환타입 calculate(...매개변수) {
//        /* 위 요구사항에 맞게 구현 */
//        /* return 연산 결과 */
//    }
//    public Calculator1(Scanner sc) {
//        this.sc = sc;
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
        results.add(result);
        beau_output(result);
    }

    void beau_output(Double result) {
        String rtStr = Double.toString(result);
        int naturalNumIdx = rtStr.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
        int decimalDigit = rtStr.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'

        // 자릿수 갯수 및 정수에 따른 출력 변화
        if ((decimalDigit == 1) && (rtStr.charAt(naturalNumIdx + 1) == '0')) { //소수점이 '0'인 정수일때
            int intResult = (int) (double) result; //Double -> double -> int int 형으로 바꾼다.
            System.out.println("결과: " + intResult);
        } else if (decimalDigit < 3) {
            System.out.println("결과: " + result);
        } else {
            String rt1 = String.format("%.3f", result);
            if (rt1.equals("0.000")) System.out.println("수가 너무 작아 계산이 명확하지 않을 수 있습니다, 결과: " + result);
            else System.out.println("결과: " + rt1);
        }
    }


    int input_num() {
        String string_value = sc.next();

        int int_value = is_it_positive(string_value);

        return int_value;
    }

    int is_it_positive(String string_value) {
        int int_value = 0;
        for (int i = 0; i < string_value.length(); i++) {
            char ch = string_value.charAt(i);
            if (ch < '0' || ch >= '9') {
                System.out.println("0포함의 양의 정수를 입력하여 주세요.");
                return input_num();
            }
        }
        int_value = Integer.valueOf(string_value);
        return int_value;
    }

    char input_op() {
        String operator = sc.next(); //char, 제일 처음만 받는 함수

        char op = is_it_op(operator);

        return op;
    }

    char is_it_op(String operator) {
        char op = ' ';
        if (operator.length() != 1) {
            System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
            input_op();
        } else {
            op = operator.charAt(0);
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
                input_op();
            }
        }
        return op;
    }

    public void removeResult() {
        results.remove(results.get(0));
    }

    public void printResult() {
        System.out.println("results = " + results);
    }

    String menu() {
        System.out.println("===========메뉴창===========");
        System.out.println("메뉴를 선택해 주십시오. \n1. 더 계산하시겠습니까?\n2. 결과물들을 출력하시겠습니까? (2 입력)\n3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n4. 종료하시겠습니까? (exit 입력)\n");

        String read_menu = sc.nextLine();
        String menu = null; //리턴때도 null이 되니 오류가 뜸.
        switch (read_menu) {
            case "1":
                return menu = read_menu;
            case "2":
                menu = read_menu;
                printResult();
                return menu();
            case "3":
                menu = read_menu;
                System.out.print("삭제 전 결과 저장 내역: ");
                printResult();
                removeResult();
                System.out.print("삭제 후 결과 저장 내역: ");
                printResult();
                return menu();
            case "exit":
                return menu = read_menu;
            default:
                System.out.println("다시 입력하여 주세요.");
                menu = read_menu;
                return menu();
        }
//        switch (read_menu) {   - null값을 없애기 위해 함.
//            case "1":
//                menu = read_menu;
//                break;
//            case "2":
//                menu = read_menu;
//                printResult();
//                break;
//            case "3":
//                menu = read_menu;
//                char op = input_op();
//                break;
//            case "exit":
//                menu = read_menu;
//                break;
//            default:
//                System.out.println("다시 입력하여 주세요.");
//                menu = read_menu;
//                menu();
//        }
    }
}