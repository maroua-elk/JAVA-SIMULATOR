// importation des packages
package Project;

import java.util.ArrayList;
import java.util.List;

public class threads_hibernate extends Thread {
	private simulateur _framework;
	private List<time> _time_list;
	private int _thread_id;

	private int _total_iterations;
	private float average_time;
	private float total_time;

	public threads_hibernate(simulateur framework, List time_list, int thread_id, int total_iterations) {
		_framework = framework;
		_time_list = time_list;
		_thread_id = thread_id;
		_total_iterations = total_iterations;
	}

	public float getAverage_time() {
		return average_time;
	}

	public float getTotal_time() {
		return total_time;
	}

	public void run() {
		average_time = 0;
		total_time = 0;
		long startTime;
		long endTime;
		long duration;

		for (int i = 0; i < _total_iterations; i++) {
			startTime = System.nanoTime();
			_framework.create();
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;
			total_time += duration;
			_time_list.add(new time("Create", duration, _thread_id));

			startTime = System.nanoTime();
			_framework.select();
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;
			total_time += duration;
			_time_list.add(new time("Select", duration, _thread_id));

			startTime = System.nanoTime();
			_framework.update();
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;
			total_time += duration;
			_time_list.add(new time("Update", duration, _thread_id));

			startTime = System.nanoTime();
			_framework.delete();
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;
			total_time += duration;
			_time_list.add(new time("Delete", duration, _thread_id));

		}

		average_time = total_time / _total_iterations;

	}

}
