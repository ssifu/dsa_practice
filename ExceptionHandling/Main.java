package ExceptionHandling;

import java.util.Scanner;

public class Main {
    private static void validateAge(int age) throws AgeLessThanZeroException {
        if (age < 0) {
            throw new AgeLessThanZeroException("Hello World");
        }
    }
    public static void main(String[] args) {
        try {
            validateAge(-1);
        } catch (AgeLessThanZeroException e) {
            e.printMessage();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name? ");
        String name = scanner.nextLine();
        System.out.println("What is your age?");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is your favourite food?");
        String food = scanner.nextLine();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favourite Food: " + food);

    }
}
