package Level2;

//계산된 결과 값들을 기록하는 컬렉션을 만든다.
//컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        String menu = " ";


        System.out.println("===========계산기===========");


        do {
            int flag =1;
            System.out.println("첫번째 정수를 입력하여주십시오: ");
            int v1 = calc.inputNum();
            System.out.println("두번째 정수를 입력하여주십시오: ");
            int v2 = calc.inputNum();
            System.out.println("수식을 입력하여주십시오: ");
            char op = calc.inputOp();

            calc.calc(v1, v2, op);
            System.out.println("결과: "+calc.getResult());

            System.out.println();

            while (flag == 1) {
                System.out.println("===========메뉴창===========");
                System.out.println("메뉴를 선택해 주십시오.\n" +
                        "1. 더 계산하시겠습니까?(1 입력)\n" +
                        "2. 결과물들을 출력하시겠습니까? (2 입력)\n" +
                        "3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n" +
                        "4. 종료하시겠습니까? (exit 입력)\n");

                menu = sc.nextLine().trim();
                //리턴때도 null이 되니 오류가 뜸.
                switch (menu) {
                    case "1":
                        flag = 0;
                        break;
                    case "2":
                        System.out.println(calc.getResults());
                        break;
                    case "3":
                        System.out.print("삭제 전 결과 저장 내역: ");
                        System.out.println(calc.getResults());
                        calc.removeResult();
                        System.out.print("삭제 후 결과 저장 내역: ");
                        System.out.println(calc.getResults());
                        break;
                    case "exit":
                        flag = 0;
                        break;
                    default:
                        System.out.println("다시 입력하여 주세요.");
                }
            }


        } while (!menu.equals("exit"));
    }
}
