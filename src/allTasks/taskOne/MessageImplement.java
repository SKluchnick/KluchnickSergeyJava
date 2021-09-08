package allTasks.taskOne;


import allTasks.taskOne.rangeFromOneToSeven.TemplateHandlerOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MessageImplement {

    Scanner scanner = new Scanner(System.in);
    private TemplateHandlerOne templateHandlerOne = new TemplateHandlerOne();
    private InputDataFromConsole inputDataFromConsole = new InputDataFromConsole();
    private String enteredString;

    public String getNumber() {
        String outPut = "";
        while (true) {
            System.out.println("Would you like to write number? (y/n)");
            String input = scanner.nextLine().toLowerCase().trim();
            if (!isContinue(input)) {
                break;
            }
            List<String> listEnteredParameters = splitEnteredParameters();
            int numOne = checkInput(listEnteredParameters.get(0));
            if (numOne > 0 && numOne <= 7) {
                outPut = templateHandlerOne.getMap(numOne).generateMessage();
                break;
            }
            if (numOne > 7) {
                outPut = "Hello";
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
            System.out.println("Please write 1 digits <first digits>, must be positive digit");
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

    public int checkInput(String enteredValue) {
        int parsedValue = 0;
        while (true){
            try {
                parsedValue = Integer.parseInt(enteredValue);
            }
            catch (NumberFormatException nfe) {
                System.err.println("Must be positive  digit");
                break;
            }if(parsedValue<=0){
                System.err.println("Must be positive  digit");
                break;
            }else {
                break;
            }
        }
        return parsedValue;
    }

    public  boolean isContinue(String enteredValue) {
        return (enteredValue.equalsIgnoreCase("y")
                || enteredValue.equalsIgnoreCase("yes"));
    }

  }
