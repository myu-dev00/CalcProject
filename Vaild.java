package v3;

public class Vaild {

    public char isItOperator(String operator) {
        char op = ' ';
        if (operator.length() != 1) {
            System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
            return ' ';
        } else {
            op = operator.charAt(0);
            if (op != '+' && op != '-' && op != '*' && op != '/') {
                System.out.println("잘못된 연산자 입니다. +, -, *, / 중 하나만 입력 부탁드립니다.");
                return ' ';
            }
        }
        return op;
    }

    public int isItPositive(String operand) {
        int intValue = 0;
        for (int i = 0; i < operand.length(); i++) {
            char ch = operand.charAt(i);
            if (ch < '0' || ch > '9') {
                System.out.println("0포함의 양의 정수를 입력하여 주세요.");
                return -1;
            }
            else if(i > 10){
                System.out.println("수가 너무 큽니다. 0포함의 양의 정수를 9자리까지만 입력하여 주세요.");
                return -1;
            }
        }
        return Integer.parseInt(operand);
    }
}
