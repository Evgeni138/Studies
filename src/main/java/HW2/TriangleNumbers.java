package HW2;

import java.util.Scanner;

public class TriangleNumbers {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Input TriangleNumber: ");
        int number = iScanner.nextInt();
        int result = number * (number + 1) / 2;
        System.out.println("Answer: " + result);
    }
}
