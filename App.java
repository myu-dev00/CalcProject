package level_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit = " ";
        System.out.println("===========계산기===========");
        do {
            //첫번째 정수 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int sc1 = sc.nextInt(); //문자가 들어오면 강제로 꺼짐
            while (sc1 < 0) {
                System.out.print("양수의 정수로 재입력해주세요: ");
                sc1 = sc.nextInt();
            }

            //두번째 정수 입력 받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            int sc2 = sc.nextInt();
            while (sc2 < 0) {
                System.out.print("양수의 정수로 재입력해주세요: ");
                sc2 = sc.nextInt();
            }

            //사칙연산 기호 입력 받기
            System.out.print("사칙연산 기호를 입력하세요(+, -, *, /): ");
            String operator = sc.next(); //char, 제일 처음만 받는 함수
            if (operator.length() != 1) {
                System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
            } else {
                System.out.println();
                char op = operator.charAt(0);
                Double result = null; //예외의 경우 입력을 위해서 null을 사용가능한 double의 객체버전 Double을 사용하였음.

                //계산기능 구현
                switch (op) {
                    case '+':
                        result = (double) sc1 + sc2;
                        break;
                    case '-':
                        result = (double) sc1 - sc2;
                        break;
                    case '*':
                        result = (double) sc1 * sc2;
                        break;
                    case '/':
                        if (sc2 == 0) {
                            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                            break;
                        }
                        result = (double) sc1 / sc2;
                        break;
                    default:
                        System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
                        break;
                }

                //자릿수 갯수 파악
                if (result != null) {
                    String rtStr = Double.toString(result);
                    int naturalNumIdx = rtStr.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
                    int decimalDigit = rtStr.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'

                    // 자릿수 갯수 및 정수에 따른 출력 변화
                    if ((decimalDigit == 1) && (rtStr.charAt(naturalNumIdx + 1) == '0')) {
                        int intResult = (int) (double) result; //Double -> double -> int
                        System.out.println("결과: " + intResult);
                    } else if (decimalDigit < 3) {
                        System.out.println("결과: " + result);
                    } else {
                        String rt1 = String.format("%.3f", result);
                        if (rt1.equals("0.000")) System.out.println("수가 너무 작아 계산이 명확하지 않을 수 있습니다, 결과: " + result);
                        else System.out.println("결과: " + rt1);
                    }
                }
            }


            System.out.println();
            sc.nextLine(); //아래의 nextLine떄문임!!!
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            exit = sc.nextLine();
        } while (!exit.equals("exit") && !exit.equals("Exit")); //||이 아닌 &&여야함!!!! 보고서 참고

    }
}
