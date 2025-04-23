package v3;

public class Vaild {

    public char isItOp(String operator) {
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

    public int isItPositive(String string_value) {
        int intValue = 0;
        for (int i = 0; i < string_value.length(); i++) {
            char ch = string_value.charAt(i);
            if (ch < '0' || ch > '9') {
                System.out.println("0포함의 양의 정수를 입력하여 주세요.");
                return -1;
            }
            else if(i > 10){
                System.out.println("수가 너무 큽니다. 0포함의 양의 정수를 9자리까지만 입력하여 주세요.");
                return -1;
            }
        }
        intValue = Integer.parseInt(string_value);
        return intValue;
    }
}
