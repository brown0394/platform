import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

enum Command {
    ADD, LIST, AVG, QUIT, INVALID, SUM, STD;
};

public class ArrayEnum {
    private static Command getCommand(Scanner scanner){
        String str = scanner.next();
        switch(str.toLowerCase()){
            case "add":{return Command.ADD;}
            case "list":{return Command.LIST;}
            case "avg":{return Command.AVG;}
            case "quit":{return Command.QUIT;}
            case "sum":{return Command.SUM;}
            case "std":{return Command.STD;}
            default: break;
        }
        return Command.INVALID;
    }
    private static int getValue(Scanner scanner){
        return scanner.nextInt();
    }
    private static void printList(int[] values, int index){
        for(int i = 0; i < index; ++i){
            System.out.print(values[i]);
            if(i < index-1){
                System.out.print(' ');
            }
            else{
                System.out.print('\n');
            }
        }
    }
    private static float getAvg(int[] values, int index){
        int sum = 0;
        for(int i = 0; i < index; ++i){
            sum += values[i];
        }
        return (float)sum / index;
    }
    private static int getSum(int[] values, int index){
        int sum = 0;
        for(int i = 0; i < index; ++i){
            sum += values[i];
        }
        return sum;
    }
    private static double getStd(int[] values, int index){
        double avg = getAvg(values, index);
        double std = 0.0f;
        for(int i = 0; i < index; ++i){
            double val = values[i] - avg;
            std += Math.pow(val, 2);
        }
        return Math.sqrt(std / index);
    }
    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        int index = 0;
        final int[] values = new int[100];

        while(true){
            final Command command = getCommand(scanner);
            if(command == Command.QUIT){
                System.out.println("Bye!");
                break;
            }
            switch(command){
                case ADD:{
                    final int newValue = getValue(scanner);
                    values[index] = newValue;
                    ++index;
                    break;
                }
                case LIST:{
                    printList(values, index);
                    break;
                }
                case AVG:{
                    System.out.printf("%.2f%n", getAvg(values, index));
                    break;
                }
                case SUM:{
                    System.out.println(getSum(values, index));
                    break;
                }
                case STD:{
                    System.out.printf("%.2f%n", getStd(values, index));
                    break;
                }
                case INVALID:{
                    System.out.println("Invalid Command");
                    break;
                }
            }
        }
        scanner.close();
    }
}
