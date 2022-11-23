import java.util.Scanner;

public class UserInput {

    static Scanner userInput = new Scanner(System.in);

    private static int routeNumberValue;
    private static int climbType;
    private static String baseLineValue;
    private static int workoutIntensity;


    public static void numberOfSendsInput(){
        String routeNumberString = userInput.nextLine();
        routeNumberValue = Integer.parseInt(routeNumberString);
    }

    public static int getRouteNumber(){
        return routeNumberValue;
    }

    public static void climbTypeInput(){
        String climbTypeString = userInput.nextLine();
        climbType = Integer.parseInt(climbTypeString);
    }

    public static int getClimbType(){
        return climbType;
    }

    public static void baseLineInput(){
        String baseline = userInput.nextLine();
        if (UserInput.getClimbType() == 1) {
            baseline = baseline.toLowerCase();
        } else if (UserInput.getClimbType() == 2) {
            baseline = baseline.toUpperCase();
        }
        baseLineValue = baseline;
    }

    public static String getBaseLine(){
        return baseLineValue;
    }

    public static void workoutIntensityInput(){
        String workoutIntensityString = userInput.nextLine();
        workoutIntensity = Integer.parseInt(workoutIntensityString);
    }

    public static int getWorkoutIntensity(){
        return workoutIntensity;
    }

    public static String logWorkoutIntensity(){
        if (workoutIntensity == 1){
            return "Normal";
        } else if (workoutIntensity == 2){
            return "Full Send";
        }
        return "";
    }

    public static String logClimbType(){
        if (climbType == 1){
            return "Top-Rope";
        } else if (climbType == 2){
            return "Bouldering";
        }
        return "";
    }

    public static void anotherWorkoutInput(){
        String response = userInput.nextLine();
        if (response.equalsIgnoreCase("Y")){
            ClimbingWorkout.run();
        } else if (response.equalsIgnoreCase("N")) {
            UserOutput.goodbyeMessage();
            System.exit(1);
        }
    }
}
