package level_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exit;
        System.out.println("===========계산기===========");
        do {
            //첫번째 정수 입력받기
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int sc1 = sc.nextInt(); //문자가 들어오면 강제로 꺼짐
            while (sc1 < 0) {
                System.out.print("양수의 정수로 재입력해주세요: ");
                sc1 = sc.nextInt();
            }
            System.out.println();

            //두번째 정수 입력 받기
            System.out.print("두 번째 숫자를 입력하세요: ");
            int sc2 = sc.nextInt();
            while (sc2 < 0) {
                System.out.print("양수의 정수로 재입력해주세요: ");
                sc2 = sc.nextInt();
            }
            System.out.println();

            //사칙연산 기호 입력 받기
            System.out.print("사칙연산 기호를 입력하세요: ");
            char op = sc.next().charAt(0); //char, 제일 처음만 받는 함수
            System.out.println();
            int result;

            //계산기능 구현
            switch (op) {
                case '+':
                    result = sc1 + sc2;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = sc1 - sc2;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = sc1 * sc2;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    if (sc2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        break;
                    }
                    if ((sc1 % sc2) == 0) { //나눗셈할시 나머지가 0이면 답이 정수형이므로 정수형으로 나오게 만듦.
                        result = sc1 / sc2;
                        System.out.println("결과: " + result);
                        break;
                    } else {
                        double result1 = (double) sc1 / (double) sc2; // 그외엔
                        //1. printf를 사용함. System.out.printf("%.3f\n",result1); //print는 안됨 (why?)
                        /* 2. print에서 Stinrg.format을 사용한 기법
                        String rt1 = String.format("%.3f",result1);
                        System.out.print(rt1);
                        */
                        //소수점의 갯수에 따라 올림 할지 말지 정하기 Double.toString() 사용하기


                        //구현한 기능: 소수점이 세자릿수 이상이면 반올림혹은 반내림 시키는 기능

                        //소수점 계산 자릿수 계산
                        /*구현방법: double형 result1을 문자열로 바꾼뒤, 소수점 전까지
                         계산하고, 전체 문자열길이에서 소수점 이전까지의 수를 빼어 ('.'포함) 자릿수 찾기
                         자릿수가 3 미만이면 그대로 전체출력하고 아닐경우 String.format()을 이용하여 반올림/반내림 진행*/
                        String rtStr = Double.toString(result1);
                        int naturalNumIdx = rtStr.indexOf("."); //'.'이 찍힌 곳의 idx를 찾아서 반영 (idx는 0부터 시작하기 떄문에 유의)
                        int decimalDigit = rtStr.length() - naturalNumIdx - 1; //전체 문자열 수 - 자연수 - '.'

                        if (decimalDigit < 3) {
                            System.out.println("결과: " + result1);
                        } else {
                            String rt1 = String.format("%.3f", result1);
                            System.out.println("결과: " + rt1);
                        }
                        break;

                    }
                default:
                    System.out.println("잘못된 연산자 입니다.");
            }

            sc.nextLine(); //아래의 nextLine떄문임!!!
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            exit = sc.nextLine();
        } while (!exit.equals("exit") && !exit.equals("Exit")); //||이 아닌 &&여야함!!!! 보고서 참고

    }
}