package ui;

import java.util.Scanner;

public class UserInput {

    static Scanner userInput = new Scanner(System.in);

    private static int routeNumberValue;
    private static String climbType;
    private static String baseLineValue;
    private static String workoutIntensity;

    public static void numberOfSendsInput(){
        String routeNumberString = userInput.nextLine();
        routeNumberValue = Integer.parseInt(routeNumberString);
    }

    public static int getRouteNumber(){
        return routeNumberValue;
    }

    public static void climbTypeInput(){
        climbType = userInput.nextLine();
    }

    public static String getClimbType(){
        return climbType;
    }

    public static void baseLineInput(){
        String baseline = userInput.nextLine();
        if (UserInput.getClimbType().equals("1")) {
            baseline = baseline.toLowerCase();
        } else if (UserInput.getClimbType().equals("2")) {
            baseline = baseline.toUpperCase();
        }
        baseLineValue = baseline;
    }

    public static String getBaseLine(){
        return baseLineValue;
    }

    public static void workoutIntensityInput(){
        workoutIntensity = userInput.nextLine();
    }

    public static String getWorkoutIntensity(){
        return workoutIntensity;
    }
}
