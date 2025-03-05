package com.tasktracker.util;

import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tasktracker.model.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtil {
    private static final String FILE_PATH = "src/resources/tasks.json";
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        // Register the JavaTimeModule to support Java 8 date/time types
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static List<Task> loadTasksFromFile() throws DatabindException {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            // If the file doesn't exist or is empty, create it with an empty array
            saveTasksToFile(Collections.emptyList());
            return Collections.emptyList();
        }
        try {
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Task.class));
        } catch (IOException e) {
            System.err.println("Error reading tasks from file: " + e.getMessage());
            return Collections.emptyList(); // Return an empty list in case of failure
        }
    }

    public static void saveTasksToFile(List<Task> tasks) throws DatabindException {
        try {
            objectMapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
