// importation des packages
package Project;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		// on traite le cas de 1000 utilisateurs
		int total_iterations = 1000;

		List<time> time_list_hibernate = new ArrayList<>();

		simulateur hibernate_fm = new Hibernate_framework();

		threads_hibernate hibernate_thread = new threads_hibernate(hibernate_fm, time_list_hibernate, 1,
				total_iterations);

		hibernate_thread.start();

		try {
			hibernate_thread.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Finished ");

		for (time te : time_list_hibernate) {
			System.out.println(te);
		}

		System.out.println("Average hibernate : " + hibernate_thread.getAverage_time());

		System.out.println(
				"Total hibernate : " + hibernate_thread.getTotal_time() + " in " + total_iterations + " iterations");

		try {
			FileWriter myWriter = new FileWriter("RESULT.txt");

			myWriter.write("Average hibernate : " + hibernate_thread.getAverage_time() + "\n");

			myWriter.write("Total hibernate : " + hibernate_thread.getTotal_time() + " in " + total_iterations
					+ " iterations\n");

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("ERROR DURING THE PROCESS!!");
			e.printStackTrace();
		}
	}
}