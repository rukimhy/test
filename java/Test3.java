import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("star mountain");
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter number you want : ");
        int number = sc.nextInt();

        for (int i = 0; i < number; i++) {
            for (int j = number - 1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
