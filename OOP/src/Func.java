import java.util.Scanner;

public class Func {
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int a = askUserInput();
        int b = askUserInput();
        int op = displayMenu();
        int ans = calculate(a,b,op);
        displayAns(ans);
    }

    static void displayAns(int ans){
        System.out.println("-----------------");
        System.out.println("Answer is :" + ans);
        System.out.println("-----------------");
    }
    static int askUserInput(){
        System.out.print("Enter number:");
        int a = sc.nextInt();
        System.out.println();
        return a;
    }

    static int calculate(int a, int b, int op){
        int ans = 0;
        switch (op){
            case 1:
                ans = add(a,b);
                break;
            case 2:
                ans = sub(a,b);
                break;
            case 3:
                ans = div(a,b);
                break;
            case 4:
                ans = mul(a,b);
                break;
            case 5:
                ans = mod(a,b);
                break;
        }

        return ans;
    }


    static int displayMenu(){
        System.out.println("menu");
        System.out.println("1. add");
        System.out.println("2. sub");
        System.out.println("3. div");
        System.out.println("4. mul");
        System.out.println("5. mod");
        System.out.print("Enter operation: ");
        int operation = sc.nextInt();
        System.out.println();
        return operation;
    }



    static int add(int a, int b){
        return a+b;
    }


    static int sub(int a, int b){
        return a-b;
    }

    static int div(int a, int b) {
        return a / b;
    }

    static int mul(int a, int b) {
        return a * b;
    }

    static int mod(int a, int b) {
        return a % b;
    }



}
