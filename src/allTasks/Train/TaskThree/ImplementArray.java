package allTasks.Train.TaskThree;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ImplementArray {

    public void getArray(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write");
        String enter = scanner.nextLine().trim().toLowerCase();
        while (true){
            if (isContinue(enter)){
                System.out.println("Write");
                enter = scanner.nextLine().trim().toLowerCase();
                int num = chekInput(enter);
                System.out.println(countEven(num));

            }else {
                break;
            }
        }

    }




    public int[]fill(int num){
        int [] array = new int[num];
        Random random = new Random();
        for (int i = 0; i<array.length; i++){
            array[i]= random.nextInt(10);
        }
        return array;
    }

    public int countEven(int num){
        int [] array = fill(num);
        System.out.println(Arrays.toString(array));
        int count = 0;
        for(int i : array){
            if(i % 2 ==0){
                count++;
            }
        }
        return count;
    }



    public boolean isContinue(String enter) {
        return enter.trim().equalsIgnoreCase("y") || enter.trim().equalsIgnoreCase("yes");
    }

    public int chekInput(String enter) {
        int num = 0;
        try {
            num = Integer.parseInt(enter);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Incorrect format dates");
        }
        return num;
    }

}
