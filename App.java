package v3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Input input = new Input(calc);
        UI ui = new UI(calc,input);
        String menu = " ";

        System.out.println("===========계산기===========");


        do {
            System.out.print("첫번째 정수를 입력하여주십시오: ");
            calc.setOperand(input.inputOperand());
            int v1 = calc.getOperand();
            System.out.print("두번째 정수를 입력하여주십시오: ");
            calc.setOperand(input.inputOperand());
            int v2 = calc.getOperand();
            System.out.print("수식을 입력하여주십시오: ");
            calc.setOperator(input.inputOperator());
            char op = calc.getOperator();

            calc.calc(v1, v2, op);

            System.out.println();
            System.out.println("연산 결과: " + v1 + " " + op + " " + v2 + " = " + calc.getResult());

            System.out.println();

            ui.menuUI();

            menu = ui.getMenu();

        } while (!menu.equals("exit"));
    }

}
