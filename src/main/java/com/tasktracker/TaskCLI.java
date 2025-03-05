package com.tasktracker;


import com.fasterxml.jackson.databind.DatabindException;
import com.tasktracker.service.TaskService;
import com.tasktracker.util.TaskStatus;

import java.util.Scanner;

public class TaskCLI {

    public static void main(String[] args) throws DatabindException {
        try {
            System.out.println("Starting TaskCLI...");
            // Your task logic here
        } catch (Exception e) {
            e.printStackTrace();  // This will help log any exceptions that occur during execution
        }
        TaskService taskManager = new TaskService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTask Tracker CLI");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task as In Progress");
            System.out.println("5. Mark Task as Done");
            System.out.println("6. List All Tasks");
            System.out.println("7. List Tasks by Status");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskManager.addTask(description);
                    break;

                case 2:
                    System.out.print("Enter task ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();
                    taskManager.updateTask(updateId, newDescription);
                    break;

                case 3:
                    System.out.print("Enter task ID: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    taskManager.deleteTask(deleteId);
                    break;

                case 4:
                    System.out.print("Enter task ID: ");
                    int inProgressId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    taskManager.markTaskInProgress(inProgressId);
                    break;

                case 5:
                    System.out.print("Enter task ID: ");
                    int doneId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    taskManager.markTaskDone(doneId);
                    break;

                case 6:
                    taskManager.listTasks();
                    break;

                case 7:
                    System.out.print("Enter status (TODO, IN_PROGRESS, DONE): ");
                    String statusInput = scanner.nextLine().toUpperCase();
                    TaskStatus status = TaskStatus.valueOf(statusInput);
                    taskManager.listTasksByStatus(status);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}