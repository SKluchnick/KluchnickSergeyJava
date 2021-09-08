package allTasks.taskThree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayImplement {

    public void getArray() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to write capacity of array? (y/n)");
            String input = scanner.nextLine().toLowerCase().trim();
            if (isContinue(input)) {
                scanner = new Scanner(System.in);
                System.out.println("Write capacity of array");
                int num = checkInput(scanner.nextLine());
                System.out.println("countEven " + countEven(num));
                System.out.println("countOdd " + countOdd(num));
                System.out.println("maxNumber " + maxNumber(num));
                System.out.println("minNumber " + minNumber(num));
                System.out.println("sumNumber " + sumNumber(num));
            } else {
                break;
            }
        }
    }

    public static boolean isContinue(String enteredValue) {
        return (enteredValue.equalsIgnoreCase("y")
                || enteredValue.equalsIgnoreCase("yes"));
    }

    private int[] fill(int num) {
        Random random = new Random();
        int[] array = new int[num];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }

    private int checkInput(String enteredValue) {
        int parsedValue = 0;
        try {
            parsedValue = Integer.parseInt(enteredValue);
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
            System.err.println("Must be digit");

        }
        return parsedValue;
    }


    private int countEven(int num) {
        int[] arrayCountEven = fill(num);
        int countEven = 0;
        for (int i : arrayCountEven) {
            if (i % 2 == 0 && i != 0) {
                countEven++;
            }
        }
        System.out.println(Arrays.toString(arrayCountEven));
        return countEven;
    }

    private int countOdd(int num) {
        int[] arrayCountOdd = fill(num);
        int countOdd = 0;
        for (int i : arrayCountOdd) {
            if (i % 2 != 0 && i != 0) {
                countOdd++;
            }
        }
        System.out.println(Arrays.toString(arrayCountOdd));
        return countOdd;
    }

    private int maxNumber(int num) {
        int[] maxNumber = fill(num);
        int max = 0;
        for (int i : maxNumber) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(Arrays.toString(maxNumber));
        return max;
    }

    private int minNumber(int num) {
        int[] minNumber = fill(num);
        int min = 10;
        for (int i : minNumber) {
            if (i < min) {
                min = i;
            }
        }
        System.out.println(Arrays.toString(minNumber));
        return min;
    }

    private int sumNumber(int num) {
        int[] sumNumber = fill(num);
        int sum = 0;
        for (int i : sumNumber) {
            sum += i;
        }
        System.out.println(Arrays.toString(sumNumber));
        return sum;
    }


}
