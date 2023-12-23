package com.example.lifemanagementsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Activity {
    private String name;
    private LocalDate date;
    private String description;

    public Activity(String name, LocalDate date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
    }

    public abstract void displayDetails();

    @Override
    public String toString() {
        return name + " - " + date + " - " + description;
    }
}

class Task extends Activity {
    private int priority;
    private String status;

    public Task(String name, LocalDate date, int priority, String status, String description) {
        super(name, date, description);
        this.priority = priority;
        this.status = status;
    }

    @Override
    public void displayDetails() {
        System.out.println("Task Details: " + this.toString());
        System.out.println("Priority: " + priority);
        System.out.println("Status: " + status);
    }
}

class Event extends Activity {
    private String location;

    public Event(String name, LocalDate date, String location, String description) {
        super(name, date, description);
        this.location = location;
    }

    @Override
    public void displayDetails() {
        System.out.println("Event Details: " + this.toString());
        System.out.println("Location: " + location);
    }
}

class Reminder extends Activity {
    private LocalTime time;

    public Reminder(String name, LocalDate date, LocalTime time, String description) {
        super(name, date, description);
        this.time = time;
    }

    @Override
    public void displayDetails() {
        System.out.println("Reminder Details: " + this.toString());
        System.out.println("Time: " + time);
    }
}

class ActivityManager {
    private List<Activity> activityList;

    public ActivityManager() {
        this.activityList = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activityList.add(activity);
        System.out.println("Activity added successfully!");
    }

    public void viewActivities() {
        System.out.println("Activity List:");
        for (Activity activity : activityList) {
            activity.displayDetails();
            System.out.println(); // Add a newline for better readability
        }
    }
}

class Prompt {
    public static void prompt() {
        ActivityManager activityManager = new ActivityManager();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Life Management System Menu");
            System.out.println("1. Add Task");
            System.out.println("2. Add Event");
            System.out.println("3. Add Reminder");
            System.out.println("4. View Activities");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addTask(scanner, activityManager);
                    break;
                case 2:
                    addEvent(scanner, activityManager);
                    break;
                case 3:
                    addReminder(scanner, activityManager);
                    break;
                case 4:
                    viewActivities(activityManager);
                    break;
                case 0:
                    System.out.println("Exiting the Life Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addTask(Scanner scanner, ActivityManager activityManager) {
        // Input for Task
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate taskDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter priority: ");
        int taskPriority = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter status: ");
        String taskStatus = scanner.nextLine();
        System.out.print("Enter task description: ");
        String taskDescription = scanner.nextLine();

        Task task = new Task(taskName, taskDate, taskPriority, taskStatus, taskDescription);
        activityManager.addActivity(task);
    }

    private static void addEvent(Scanner scanner, ActivityManager activityManager) {
        // Input for Event
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine();
        System.out.print("Enter event date (YYYY-MM-DD): ");
        LocalDate eventDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter event location: ");
        String eventLocation = scanner.nextLine();
        System.out.print("Enter event description: ");
        String eventDescription = scanner.nextLine();

        Event event = new Event(eventName, eventDate, eventLocation, eventDescription);
        activityManager.addActivity(event);
    }

    private static void addReminder(Scanner scanner, ActivityManager activityManager) {
        // Input for Reminder
        System.out.print("Enter reminder name: ");
        String reminderName = scanner.nextLine();
        System.out.print("Enter reminder date (YYYY-MM-DD): ");
        LocalDate reminderDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter reminder time (HH:mm): ");
        LocalTime reminderTime = LocalTime.parse(scanner.nextLine());
        System.out.print("Enter reminder description: ");
        String reminderDescription = scanner.nextLine();

        Reminder reminder = new Reminder(reminderName, reminderDate, reminderTime, reminderDescription);
        activityManager.addActivity(reminder);
    }

    private static void viewActivities(ActivityManager activityManager) {
        activityManager.viewActivities();
    }
}