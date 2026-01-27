import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionHandling2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number;
        try{
            number = sc.nextInt();
            int sum = number + 5;
        }catch(Exception e){
            System.out.println("Invalid number.");
        }

        System.out.print("Enter another number: ");
        number = inputNumber();

        System.out.println("Thanks for using the program. Good bye.");
        sc.close();
    }

    public static int inputNumber(){
        int number = 0;

        Scanner input = new Scanner(System.in);

        for(;;){
            try{
                number = input.nextInt();
                input.close();
                
                return number;
            }catch(Exception e){
                input.nextLine();
                System.out.println("Invalid number...try again! \n\n Enter a number: ");
            }
        }
        
    }

}
