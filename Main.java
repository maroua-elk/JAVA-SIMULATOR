// importation des packages
package project.project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // on traite le cas de 1000 utilisateurs
        int total_iterations = 1000;

        List<time> time_list_jdbc = new ArrayList<>();

        simulateur jdbc_framework = new JDBC_FramWork();

        threads_JDBC jdbc_thread = new threads_JDBC(jdbc_framework, time_list_jdbc, 1, total_iterations);

        jdbc_thread.start();

        try {
            jdbc_thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Finished ");

        for (time te : time_list_jdbc) {
            System.out.println(te);
        }

        System.out.println("Average jdbc : " + jdbc_thread.getAverage_time());

        System.out.println("Total jdbc : " + jdbc_thread.getTotal_time() + " in " + total_iterations + " iterations");

        try {
            FileWriter myWriter = new FileWriter("RESULT.txt");

            myWriter.write("Average jdbc : " + jdbc_thread.getAverage_time() + "\n");

            myWriter.write("Total jdbc : " + jdbc_thread.getTotal_time() + " in " + total_iterations + " iterations\n");

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("ERROR DURING THE PROCESS!!");
            e.printStackTrace();
        }
    }
}
