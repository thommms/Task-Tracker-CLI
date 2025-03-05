//package com.tasktracker.Helper;
//
//import com.fasterxml.jackson.databind.DatabindException;
//import com.tasktracker.model.Task;
//import com.tasktracker.util.FileUtil;
//import com.tasktracker.util.TaskStatus;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class TaskManager {
//    private List<Task> tasks;
//
//    public TaskManager() {
//        tasks = FileUtil.loadTasksFromFile();
//    }
//
//    public void addTask(String description) throws DatabindException {
//        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
//        Task task = new Task(newId, description, TaskStatus.TODO);
//        tasks.add(task);
//        FileUtil.saveTasksToFile(tasks);
//        System.out.println("Task added successfully (ID: " + newId + ")");
//    }
//
//    public void updateTask(int id, String description) throws DatabindException {
//        Task task = findTaskById(id);
//        if (task != null) {
//            task.setDescription(description);
//            task.setUpdatedAt(LocalDateTime.now());
//            FileUtil.saveTasksToFile(tasks);
//            System.out.println("Task updated successfully.");
//        } else {
//            System.out.println("Task not found.");
//        }
//    }
//
//    public void deleteTask(int id) throws DatabindException {
//        Task task = findTaskById(id);
//        if (task != null) {
//            tasks.remove(task);
//            FileUtil.saveTasksToFile(tasks);
//            System.out.println("Task deleted successfully.");
//        } else {
//            System.out.println("Task not found.");
//        }
//    }
//
//    public void markTaskInProgress(int id) throws DatabindException {
//        Task task = findTaskById(id);
//        if (task != null) {
//            task.setStatus(TaskStatus.IN_PROGRESS);
//            task.setUpdatedAt(LocalDateTime.now());
//            FileUtil.saveTasksToFile(tasks);
//            System.out.println("Task marked as in progress.");
//        } else {
//            System.out.println("Task not found.");
//        }
//    }
//
//    public void markTaskDone(int id) throws DatabindException {
//        Task task = findTaskById(id);
//        if (task != null) {
//            task.setStatus(TaskStatus.DONE);
//            task.setUpdatedAt(LocalDateTime.now());
//            FileUtil.saveTasksToFile(tasks);
//            System.out.println("Task marked as done.");
//        } else {
//            System.out.println("Task not found.");
//        }
//    }
//
//    public void listTasks() {
//        tasks.forEach(System.out::println);
//    }
//
//    public void listTasksByStatus(TaskStatus status) {
//        tasks.stream()
//                .filter(task -> task.getStatus() == status)
//                .forEach(System.out::println);
//    }
//
//    private Task findTaskById(int id) {
//        return tasks.stream()
//                .filter(task -> task.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//}
