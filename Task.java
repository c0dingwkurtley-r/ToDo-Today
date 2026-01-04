//this object represents a single task and it's state

public class Task {
    private String task;
    private Status status;

//    constructor used when adding a new task
    public Task(String task) {
        this.task = task;
        this.status = Status.NOT_DONE;
    }

//    constructor used when reading existing tasks from text file
    public Task(String task, Status status){
        this.task = task;
        this.status = status;
    }

//    return task completion status
    public String getStatus() {
        return status.toString();
    }

    public String getTask(){
        return task;
    }

    public void setStatus(){
        status = Status.DONE;
    }

//    edit task description
    public void setTask(String task){
        this.task = task;
    }

    public String toString(){
        return String.format("%s: %s",this.task, this.status);
    }
}