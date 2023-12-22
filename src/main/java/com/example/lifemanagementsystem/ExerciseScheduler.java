package com.example.lifemanagementsystem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ExerciseScheduler {

    private String exerciseName;
    private LocalDate lastExerciseDate;

    public ExerciseScheduler(String exerciseName, String lastExerciseDate) {
        this.exerciseName = exerciseName;
        this.lastExerciseDate = LocalDate.parse(lastExerciseDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public LocalDate calculateNextExerciseDate() {
        // Assuming exercise happens every 7 days
        return lastExerciseDate.plusDays(7);
    }

    public void setLastExerciseDate(String lastExerciseDate) {
        this.lastExerciseDate = LocalDate.parse(lastExerciseDate, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public LocalDate getLastExerciseDate() {
        return lastExerciseDate;
    }

    public static void prompt() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the exercise: ");
        String exerciseName = scanner.nextLine();

        System.out.print("Enter the date of the last exercise (YYYY-MM-DD): ");
        String lastExerciseDate = scanner.nextLine();

        ExerciseScheduler scheduler = new ExerciseScheduler(exerciseName, lastExerciseDate);

        System.out.println("Last exercise date: " + scheduler.getLastExerciseDate());
        System.out.println("Next exercise date: " + scheduler.calculateNextExerciseDate());
    }


}
