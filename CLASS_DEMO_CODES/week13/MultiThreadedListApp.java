import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class MultiThreadedListApp {
    List<String> data = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {

        //load data
        

        // thread 1
        Thread saver = new Thread(()->{
            //this is the run method, put here the things you want to do
            while(true){
                //save the list
                saveToDisk();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        Thread fetcher = new Thread(()->{
            while(true){
                //read file
                readFile();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        //set both as daemon so they close whem main is terminated
        saver.setDaemon(true);
        fetcher.setDaemon(true);
        saver.start();
        fetcher.start();

        //MENU


    }

    public static void saveToDisk(){
        //write to file
    }

    public static void readFile(){
        //read from file
    }
}
