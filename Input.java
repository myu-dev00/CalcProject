package v2;

import java.util.Scanner;

public class Input {
    //속성
    private Scanner sc = new Scanner(System.in);
    private Vaild vaild  = new Vaild();


    //기능

    public char inputOperator() {
        String operator;
        char op = ' ';

        while (true) {
            operator = sc.nextLine().trim(); // 입력 받은 후, 공백을 제거

            if (operator.isEmpty()) {
                System.out.println("연산자는 비어있을 수 없습니다. 다시 입력해 주세요.");
                continue;  // 비어있는 경우 다시 입력을 받도록 반복
            }

            op = vaild.isItOperator(operator);
            if (op != ' ') {
                break;  // 올바른 연산자가 입력되면 반복 종료
            }
        }
        return op;
    }

    public int inputOperand() {
        String stringOperand;
        int intOperand = 0;

        while (true) {
            stringOperand = sc.nextLine().trim();  // 입력 후 공백 제거

            if (stringOperand.isEmpty()) {
                System.out.println("피연산자는 비어있을 수 없습니다. 다시 입력해 주세요.");
                continue;  // 비어있는 경우 다시 입력을 받도록 반복
            }

            intOperand = vaild.isItPositive(stringOperand);
            if (intOperand >= 0) {
                break;  // 유효한 정수 값이 입력되면 반복 종료
            }
        }
        return intOperand;
    }

    public String inputMenu() {
        return sc.nextLine();
    }

}
