package validators;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    public static int checkIsNum(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            try{
                int type = scanner.nextInt();
                return type;
            }catch (InputMismatchException e){
                System.err.println("Неверный ввод");
                scanner.next();
            }
        }
    }
}
