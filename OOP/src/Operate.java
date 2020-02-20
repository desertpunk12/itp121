import java.util.*;

public class Operate {
    Scanner sc;
    private int a;
    private int b;
    private int ans;
    private int operation;//1 add, 2 sub, 3 div, 4 mul, 5 mod

    public Operate() {
        sc = new Scanner(System.in);
    }

    private void askUserOperation() {
        System.out.println("menu");
        System.out.println("1. add");
        System.out.println("2. sub");
        System.out.println("3. div");
        System.out.println("4. mul");
        System.out.println("5. mod");
        System.out.print("Enter operation: ");
        this.operation = sc.nextInt();
        System.out.println();
    }

    private void askUserInput(){
        System.out.print("Enter number 1:");
        this.a = sc.nextInt();
        System.out.println();
        System.out.print("Enter number 2:");
        this.b = sc.nextInt();
        System.out.println();
    }

    public void compute(){
        askUserInput();
        askUserOperation();
        switch (operation){
            case 1:
                this.ans = a+b;
                break;
            case 2:
                this.ans = a-b;
                break;
            case 3:
                this.ans = a/b;
                break;
            case 4:
                this.ans = a*b;
                break;
            case 5:
                this.ans = a%b;
                break;
        }

        System.out.println("Answer is :" + this.ans);
    }


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }


}


