package level_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit;
        System.out.println("===========계산기===========");
        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int sc1 = sc.nextInt();
            while (sc1 < 0) {
                System.out.print("첫 번째 숫자를 0 혹은 양수의 정수로 재입력해주세요: ");
                sc1 = sc.nextInt();
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int sc2 = sc.nextInt();
            while (sc2 < 0) {
                System.out.print("두 번째 숫자를 0 혹은 양수의 정수로 재입력해주세요: ");
                sc2 = sc.nextInt();
            }

            sc.nextLine(); //nextLine떄문임!!!
            System.out.print("사칙연산 기호를 입력하세요: ");
            String op = sc.nextLine();

            System.out.println();
            int result;
            //반영 사항
            switch (op) {
                case "+":
                    result = sc1 + sc2;
                    System.out.println(result);
                    break;
                case "-":
                    result = sc1 - sc2;
                    System.out.println(result);
                    break;
                case "*":
                    result = sc1 * sc2;
                    System.out.println(result);
                    break;
                case "/":
                    if (sc2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    if ((sc1 % sc2) == 0) { //나눗셈할시 몫이 0이면 답이 정수형이므로 정수형으로 나오게 만듦.
                        result = sc1 / sc2;
                        System.out.println(result);
                        break;
                    } else {
                        double result1 = (double) sc1 / (double) sc2; // 그외엔 실수형 result1을 만들어서 출력
                        System.out.println(result1);
                        break;
                    }
                default:
                    System.out.println("잘못된 연산자 입니다.");

            }
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            exit = sc.nextLine();
        } while (!exit.equals("exit")); //exit = "exit"했는데 멈춤 ㅋㅋ

    }
}
