package v2;

public class UI {
    //속성 Calculator 객체를 받아옴
    private Calculator calc;
    private Input input;
    private String menu;
    private boolean flag;

    //생성자
    public UI(Calculator calc, Input input) {
        this.calc = calc;
        this.input = input;
    }

    //기능
    public void menuUI() {
        boolean flag = true;
        while (flag) {
            System.out.println("===========메뉴창===========");
            System.out.println("메뉴를 선택해 주십시오. \n1. 더 계산하시겠습니까?\n2. 결과물들을 출력하시겠습니까? (2 입력)\n3. 제일 첫 결과물을 삭제하시겠습니까? (3 입력)\n4. 종료하시겠습니까? (exit 입력)\n");

            menu = input.inputMenu();
            if (menu.isEmpty()) {
                System.out.println("다시 입력하여주세요");
                break;
            }
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
    }

    public String getMenu() {
        return menu;
    }
}
