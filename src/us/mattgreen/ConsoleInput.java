package us.mattgreen;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public void readTalkable(List<Talkable> animals) {
        System.out.println("Please enter the number for the type of animal you want to add.");
        System.out.println("1) Cat");
        System.out.println("2) Dog");
        System.out.println("3) Teacher");
        Talkable talkable = null;
        while (talkable == null) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    talkable = makeCat();
                    break;
                case "2":
                    talkable = makeDog();
                    break;
                case "3":
                    talkable = makeTeacher();
                    break;
                default:
                    System.out.println("Invalid input! Pick 1, 2, or 3.");
                    break;
            }
        }
        animals.add(talkable);
    }

    private Cat makeCat() {
        String name = readName();
        System.out.println("How many mouses has it killed?");
        int mousesKilled = readPositiveInteger();
        return new Cat(mousesKilled, name);
    }

    private Dog makeDog() {
        String name = readName();
        System.out.println("Is the dog friendly? (Y/N)");
        String response = scanner.nextLine().toUpperCase();
        boolean friendly = response.charAt(0) == 'Y';
        return new Dog(friendly, name);
    }

    private Teacher makeTeacher() {
        String name = readName();
        System.out.println("What is the teacher's age?");
        int age = readPositiveInteger();
        return new Teacher(age, name);
    }

    private String readName() {
        System.out.println("What is the name?");
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Invalid name! A name needs at least one character.");
            } else {
                return name;
            }
        }
    }

    private int readPositiveInteger() {
        while (true) {
            try {
                String response = scanner.nextLine();
                int number = Integer.parseInt(response);
                if (number < 0) {
                    System.out.println("Please enter a positive number.");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input is not a number! Try again.");
            }
        }
    }
}
