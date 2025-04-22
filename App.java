package Level2;

//계산된 결과 값들을 기록하는 컬렉션을 만든다.
//컬렉션의 가장 먼저 저장된 데이터를 삭제하는 기능을 만든다.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator1 calc = new Calculator1();
        String menu = " ";

        System.out.println("===========계산기===========");


        do {
            System.out.println("첫번째 정수를 입력하여주십시오: ");
            int v1 = calc.input_num();
            System.out.println("두번째 정수를 입력하여주십시오: ");
            int v2 = calc.input_num();
            System.out.println("수식을 입력하여주십시오: ");
            char op = calc.input_op();

            calc.calc(v1, v2, op);

            System.out.println();

            sc.nextLine();
            menu = calc.menu();


        } while (!menu.equals("exit"));
    }
}
