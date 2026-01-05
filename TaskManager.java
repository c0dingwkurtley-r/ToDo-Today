//class to handle all task management
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class TaskManager{
    private ArrayList<Task> list; //the to do list
    private final String filename;

    public TaskManager(String filename){
//      load existing tasks from file
        loadFromFile();
        this.filename = filename;
    }

    private void loadFromFile(){
        File reader = new File(filename);
        list = new ArrayList<>();

        try (Scanner sc = new Scanner(reader)){
            String line,task,status;
            int delimiter;

            while (sc.hasNextLine()){
                line = sc.nextLine();
                delimiter = line.indexOf("*"); //find the character separating the task description and status
                task = line.substring(0,delimiter);
                status = line.substring(delimiter+1);
                list.add(new Task(task, Status.parseStatus(status))); //add tasks to list
            }

        } catch (FileNotFoundException e){
            System.out.println("Error when opening file: " + filename);
            System.exit(1);
        }
    }

//    save all tasks and statuses in the list to the file, overwrites file to account for changes in status of old tasks or removal of them
    public void saveToFile(){
        try (FileWriter writer = new FileWriter(filename)){
            //loop to add all elements of the ArrayList to the file in appropriate format
            for (Task t: list){
                writer.write(t.getTask()+"*"+t.getStatus());
            }

        } catch (IOException e){
            System.out.println("Error writing to file: " + filename);
            System.exit(1);
        }
    }

//    method to add new task to list
    public void addTask(String task){
        list.add(new Task(task,Status.NOT_DONE));
    }

    public void deleteTask(int index){
        list.remove(index);
    }

//    change task status
    public void changeStatus(int index){
        Task t = list.get(index);
        t.setStatus(Status.parseStatus(t.getStatus()));
    }

//    change a current task description
    public void changeTask(int index, String newTask){
        Task t = list.get(index);
        t.setTask(newTask);
    }

//    return a string displaying all tasks, numbered in an appropriate manner
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Task t: list){
            sb.append(String.format("%d. %s : %s%n",i,t.getTask(),t.getStatus()));
            i++;
        }
        return sb.toString();
    }
}