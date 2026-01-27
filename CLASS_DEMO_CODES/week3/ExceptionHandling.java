public class ExceptionHandling {
    public static void main(String[] args) {
        int number = 5;

        try{
            int q = 5 / 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

        System.out.println("End!");

    }
}
