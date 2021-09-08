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
            String numOne = checkInput(listEnteredParameters.get(0));
            if (numOne.equals("Vyacheslav")) {
                outPut = templateHandler.getMap(numOne).generateMessage();
                break;
            } else {
                System.out.println("This name is absent ");
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


    public String checkInput(String enteredValue) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁa-zA-Z]");
        Matcher matcher = pattern.matcher(enteredValue);
        for (int i = 0; i < enteredValue.length(); i++) {
            while (!matcher.find()) {
                throw new IllegalArgumentException("Must be only letters");

            }
        }

        if (enteredValue.length() == 0) {
            throw new IllegalArgumentException("Must be only letters");
        }
        return enteredValue;
    }


    public static boolean isContinue(String enteredValue) {
        return (enteredValue.equalsIgnoreCase("y")
                || enteredValue.equalsIgnoreCase("yes"));
    }

    public static void main(String[] args) {
        MessageImplement messageImplement = new MessageImplement();
        System.out.println(messageImplement.checkInput("25"));
    }
}
