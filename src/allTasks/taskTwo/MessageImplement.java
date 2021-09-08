package allTasks.taskTwo;


import allTasks.taskTwo.rangeOfNames.TemplateHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageImplement {

    Scanner scanner = new Scanner(System.in);
    private TemplateHandler templateHandler = new TemplateHandler();
    private InputDataFromConsole inputDataFromConsole = new InputDataFromConsole();
    private String enteredString;


    public String getString() {
        String outPut = "";
        while (true) {
            System.out.println("Would you like to write number? (y/n)");
            String input = scanner.nextLine().toLowerCase().trim();
            if (!isContinue(input)) {
                break;
            }
            List<String> listEnteredParameters = splitEnteredParameters();
            String numOne = checkInputSecond(listEnteredParameters.get(0));
            if (numOne.equalsIgnoreCase("Vyacheslav")) {
                outPut = templateHandler.getMap(numOne).generateMessage();
                break;
            }

        }

        return outPut;

    }

    public List<String> splitEnteredParameters() {
        List<String> listEnteredParameters = new ArrayList<>();
        int number = 1;
        boolean flag = false;
        while (!flag) {
            System.out.println("Please write 1 name <name> only string");
            enteredString = inputDataFromConsole.getParameters();
            listEnteredParameters = Arrays.asList(enteredString.trim().split(" "));
            if (listEnteredParameters.size() != number) {
                inputDataFromConsole.getParameters();
            } else {
                flag = true;
            }
        }
        return listEnteredParameters;
    }


    public String checkInputFirst(String enteredValue) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]");
        Matcher matcher = pattern.matcher(enteredValue);
        for (int i = 0; i < enteredValue.length(); i++) {
            while (!matcher.find()) {
                throw new IllegalArgumentException("Must be only one word");
            }
        }
        if (enteredValue.length() == 0) {
            throw new IllegalArgumentException("Must be only one word");
        }
        return enteredValue;
    }

    public String checkInputSecond(String enteredValue) {
        outer:while (true) {
            Pattern pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]");
            Matcher matcher = pattern.matcher(enteredValue);
            for (int i = 0; i < enteredValue.length(); i++) {
                while (!matcher.find()) {
                    System.err.println("Must be only one word");
                    break outer;
                }
            }
            if (enteredValue.length() == 0) {
                System.err.println("Must be only one word");
                break;
            }
            if ( !enteredValue.equalsIgnoreCase("Vyacheslav")) {
                System.err.println("Name does not exist");
                break;
            }
            else {
                break;
            }
        }

        return enteredValue;
    }


    public static boolean isContinue(String enteredValue) {
        return (enteredValue.equalsIgnoreCase("y")
                || enteredValue.equalsIgnoreCase("yes"));
    }

}
