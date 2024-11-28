import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String title;
    private String description;
    private String priority;
    private boolean isCompleted;

    public Task(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Priority: " + priority + ", Status: " + (isCompleted ? "Completed" : "Pending");
    }
}

class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String title, String description, String priority) {
        tasks.add(new Task(title, description, priority));
        System.out.println("Task added successfully.");
    }

    public void listTasks(boolean completed) {
        System.out.println("\n" + (completed ? "Completed Tasks:" : "Pending Tasks:"));
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                System.out.println(task);
            }
        }
    }

    public void markTaskAsCompleted(String title) {
        for (Task task : tasks) {
            if (task.toString().contains(title) && !task.isCompleted()) {
                task.markAsCompleted();
                System.out.println("Task \"" + title + "\" marked as completed.");
                return;
            }
        }
        System.out.println("Task not found or already completed.");
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Management System");
            System.out.println("1. Add Task");
            System.out.println("2. View Pending Tasks");
            System.out.println("3. View Completed Tasks");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task priority (High, Medium, Low): ");
                    String priority = scanner.nextLine();
                    manager.addTask(title, description, priority);
                    break;
                case 2:
                    manager.listTasks(false);
                    break;
                case 3:
                    manager.listTasks(true);
                    break;
                case 4:
                    System.out.print("Enter task title to mark as completed: ");
                    String completedTask = scanner.nextLine();
                    manager.markTaskAsCompleted(completedTask);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

