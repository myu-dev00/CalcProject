package Level2_2;

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
            boolean flag = true; //메뉴 나가기 위한 변수

            System.out.print("첫번째 정수를 입력하여주십시오: ");
            calc.setNum();
            System.out.print("두번째 정수를 입력하여주십시오: ");
            calc.setNum();
            System.out.print("수식을 입력하여주십시오: ");
            calc.setOp();

            calc.calc();

            int v1 = calc.getValue(0);
            int v2 = calc.getValue(1);
            char op = calc.getOp();

            System.out.println();
            System.out.println(v1 + " " + op + " " + v2 + " = " + calc.getResult());

            System.out.println();

            while (flag) {
                System.out.println("===========메뉴창===========");
                System.out.println("메뉴를 선택해 주십시오.\n" +
                        "1. 더 계산하시겠습니까?(1 입력)\n" +
                        "2. 결과물들을 출력하시겠습니까? (2 입력)\n" +
                        "3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n" +
                        "4. 종료하시겠습니까? (exit 입력)\n");

                menu = sc.nextLine();
                //trim()을 통하여 불필요한 공백문자들을 비움.
                switch (menu) {
                    case "1":
                        flag = false;
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
                        flag = false;
                        break;
                    default:
                        System.out.println("다시 입력하여 주세요.");
                }
            }

            calc.removeValues();
            calc.removeValues();

        } while (!menu.equals("exit"));
    }
}
