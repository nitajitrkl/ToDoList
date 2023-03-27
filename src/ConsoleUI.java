import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {
    private TaskManager taskManager;
    private Scanner scanner;

    public ConsoleUI(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Display all tasks");
        System.out.println("2. Add a new task");
        System.out.println("3. Remove a task");
        System.out.println("4. Mark a task as done");
        System.out.println("5. Mark a task as not done");
        System.out.println("6. Display task details");
        System.out.println("0. Exit");
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (Task task : taskManager.getTasks()) {
            System.out.println(task.getName());
        }
    }

    public void addTask() {
        System.out.println("Enter task name:");
        String name = scanner.nextLine();
        System.out.println("Enter task description:");
        String description = scanner.nextLine();
        System.out.println("Enter task due date (yyyy-mm-dd):");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        Task task = new Task(name, description, dueDate);
        taskManager.addTask(task);
        System.out.println("Task added.");
    }

    public void removeTask() {
        System.out.println("Enter the index of the task to remove:");
        int index = Integer.parseInt(scanner.nextLine());
        taskManager.removeTask(index);
        System.out.println("Task removed.");
    }
}