package miniProject.JEE;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // on traite le cas de 1000 utilisateurs
        int total_iterations = 1000;

        List<time> time_list_dao = new ArrayList<>();

        simulateur dao_framework = new DAO_FramWork();

        threads_DAO dao_thread = new threads_DAO(dao_framework, time_list_dao, 1, total_iterations);

        dao_thread.start();

        try {
            dao_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished ");

        for (time te : time_list_dao) {
            System.out.println(te);
        }

        System.out.println("Average dao : " + dao_thread.getAverage_time());

        System.out.println("Total dao : " + dao_thread.getTotal_time() + " in " + total_iterations + " iterations");

        try {
            FileWriter myWriter = new FileWriter("RESULT.txt");

            myWriter.write("Average dao : " + dao_thread.getAverage_time() + "\n");

            myWriter.write("Total dao : " + dao_thread.getTotal_time() + " in " + total_iterations + " iterations\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("ERROR DURING THE PROCESS!!");
            e.printStackTrace();
        }
    }
}
