//main class which handles user input and output to console
import java.util.Scanner;

public class ToDoList {
    private static Scanner in;
    private static TaskManager manager;
    private static int option = 0;

    public static void main(String[] args){
        in = new Scanner(System.in);
        manager = new TaskManager("tasks.txt");
        System.out.printf("Welcome to ToDo-Today!!%n%n");

        do {
            displayMenu();
        } while (option != 5);

        System.exit(0);
    }

    public static void displayMenu(){
        System.out.printf("Your to do list:%n%s%n",manager.toString()); //print most updated task list
        System.out.printf("1. Add new task%n2. Delete a task%n3. Change task status%n4. Change task description%n5. Close application%n%n");

        if (in.hasNextInt()) {
            option = in.nextInt();
            in.nextLine();
            menuAction();
        } else {
            System.out.println("Error: Please enter a valid menu option (1 - 4).");
        }
    }

    public static void menuAction(){
        switch (option){
            case 1:
//                add new task
                System.out.println("Enter task description:");
                String task = in.nextLine();
                manager.addTask(task);
                System.out.println("Task successfully added!");
                break;
            case 2:
//                delete a task
                System.out.println("Enter task number to delete:");
                if (in.hasNextInt()){
                    int del = in.nextInt();
                    if (del <= manager.getSize()) {
                        manager.deleteTask(del);
                        System.out.println("Task successfully deleted.");
                    } else {
                        System.out.println("Error: Enter a valid task number.");
                    }
                } else {
                    System.out.println("Error: Enter an integer value.");
                }
                break;
            case 3:
//                change task status
                System.out.println("Enter task number to change status: ");
                if (in.hasNextInt()){
                    int change = in.nextInt();
                    if (change <= manager.getSize()) {
                        manager.changeStatus(change);
                        System.out.println("Task status changed successfully.");
                    } else{
                        System.out.println("Error: Enter a valid task number.");
                    }
                } else {
                    System.out.println("Error: Enter an integer value.");
                }
                break;
            case 4:
//                edit task
                System.out.println("Enter task number to edit:");
                if (in.hasNextInt()){
                    int edit = in.nextInt();
                    in.nextLine();
                    if (edit <= manager.getSize()) {
                        System.out.println("Enter new task description:");
                        String newTask = in.nextLine();
                        manager.changeTask(edit, newTask);
                        System.out.println("Task successfully updated.");
                    } else {
                        System.out.println("Error: Enter a valid task number.");
                    }
                } else {
                    System.out.println("Error: Enter an integer value.");
                }
                break;
            case 5:
//                end application
                System.out.println("Thank you for using ToDo-Today.");
                manager.saveToFile();
                break;
            default:
                System.out.println("Error: Please enter a valid menu option (1 - 4).");
                break;
        }
    }


}
