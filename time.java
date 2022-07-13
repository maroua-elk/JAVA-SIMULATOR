// importation des packages
package project.project;

public class time {
    public String operation;
    public float duration;
    public int thread_id;

    public time(String operation, float duration, int thread_id) {
        this.operation = operation;
        this.duration = duration;
        this.thread_id = thread_id;
    }

    @Override
    public String toString() {
        return "time{" +
                "operation = '" + operation + " \' " +
                ", duration = " + duration +
                ", thread_id = " + thread_id +
                " }";
    }
}