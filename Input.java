package v3;

import java.util.Scanner;

public class Input {
    //속성
    private Scanner sc = new Scanner(System.in);
    private Vaild vaild;
    private Calculator calc;

    //생성자 Calculator 객체를 받아옴
    public Input(Calculator calc) {
        this.calc = calc;
        this.vaild = new Vaild(this);
    }

    //기능
    public char inputOp() {
        String operator;
        char op = ' ';

        while (true) {
            operator = sc.nextLine().trim(); // 입력 받은 후, 공백을 제거

            if (operator.isEmpty()) {
                System.out.println("연산자는 비어있을 수 없습니다. 다시 입력해 주세요.");
                continue;  // 비어있는 경우 다시 입력을 받도록 반복
            }

            op = vaild.isItOp(operator);
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

    public String menu() {
        System.out.println("===========메뉴창===========");
        System.out.println("메뉴를 선택해 주십시오. \n1. 더 계산하시겠습니까?\n2. 결과물들을 출력하시겠습니까? (2 입력)\n3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n4. 종료하시겠습니까? (exit 입력)\n");

        String read_menu = sc.nextLine();
        String menu = null; //리턴때도 null이 되니 오류가 뜸.
        switch (read_menu) {
            case "1":
                return menu = read_menu;
            case "2":
                menu = read_menu;
                System.out.println(calc.getResults());
                return menu();
            case "3":
                menu = read_menu;
                System.out.print("삭제 전 결과 저장 내역: ");
                System.out.println(calc.getResults());
                calc.removeResult();
                System.out.print("삭제 후 결과 저장 내역: ");
                System.out.println(calc.getResults());
                return menu();
            case "exit":
                return menu = read_menu;
            default:
                System.out.println("다시 입력하여 주세요.");
                menu = read_menu;
                return menu();
        }
    }


}
