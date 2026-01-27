import java.util.Scanner;
public class Week3{
    public static void main(String[] args){
        int rowSize = 3, colSize = 3;
        int[][] table = new int[rowSize][colSize];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers for the table: ");
        for(int r = 0; r < rowSize; r++){
            for(int c = 0; c < colSize; c++){
                table[r][c] = sc.nextInt();
            }

        }

        

    }
}