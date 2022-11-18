import java.util.*;

public class ClimbingWorkout {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        //To-Do:
        // - exception handling for input type checks
        // - write workout to a file, to showcase FileWriter

        //Arrays to hold grades for both Top Rope and Bouldering. Grade is level of difficult, sorted in ascending order from easy to more difficult
        String[] topRopeGradeArray = {"5.5", "5.6", "5.7", "5.8", "5.9", "10a", "10b", "10c", "10d", "11a", "11b", "11c", "11d", "12a", "12b", "12c", "12d"};
        String[] boulderGradeArray = {"VB", "V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10"};


        //Welcome statement, could include some instructions here? anything to greet user, to help positive user experience
        System.out.println("\n☺・☻・☺・☻・Welcome to your Rock Climbing Workout Generator・☻・☺・☻・☺\n");

        System.out.println("          /\\");
        System.out.println("         /**\\");
        System.out.println("        /****\\   /\\");
        System.out.println("       /      \\ /**\\");
        System.out.println("      /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\");
        System.out.println("     /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\");
        System.out.println("    /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\");
        System.out.println("   /  /      \\/  \\/\\   \\  /      \\    /   /    \\");
        System.out.println("__/__/_______/___/__\\___\\__________________________________________________");

        //Asking for number of routes the user would like to climb, a route is one time up the wall. A "send" is the term for a completed climb.
        System.out.print("\nHow many routes would you like to send today?  ");
        String routeNumberString = userInput.nextLine();
        int routeNumberValue = Integer.parseInt(routeNumberString);


        //Type of Climbing: if User selects Top Rope, we'll utilize the top rope grading system, if selection is Bouldering, we'll use the boulder grades
        System.out.println("\nWhat type of climbing will you be doing?");
        System.out.println("Enter 1 for Top Rope");
        System.out.println("Enter 2 for Bouldering");
        String climbType = userInput.nextLine();

        //baseline is a current performance level, this baseline will serve as a reference point for the route grades assigned in workout
        System.out.print("\nWhat is your Baseline?\tFor Top Rope(Baselines range from 5.5 to 12d) --- For Bouldering(Baselines range from VB to V10)  ");
        String baseline = userInput.nextLine();
            if (climbType.equals("1")) {
                baseline = baseline.toLowerCase();
            } else if (climbType.equals("2")) {
                baseline = baseline.toUpperCase();
            }

        //Workout type. Starting with 2 options - more relaxed workout or a difficult workout (Full Send). Selection will determine deviation from baseline.
        System.out.println("\nPlease select your workout type");
        System.out.println("Enter 1 to Take it Easy");
        System.out.println("Enter 2 to Full Send");
        String workoutIntensity = userInput.nextLine();

        //Map to hold climb# and route grade, will loop through at the end to display workout to the user.
        Map<Integer, String> workoutRoutes = new HashMap<>();

        if (workoutIntensity.equals("1")) {
            if (climbType.equals("1")) {
                int baselineIndex = Arrays.asList(topRopeGradeArray).indexOf(baseline);
                int climbNumber = 1;
                    for (int i = 1; i <= routeNumberValue; i++) {/*Climbing grades are exponentially difficult, if user's baseline is among
                                              the first 2 grades, the workout can include -1 baseline at the easiest unless baseline is the lowest grade*/
                        if (baselineIndex == 0) {
                            int randomNumber = new Random().nextInt(2);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else if (baselineIndex <= 2) {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex - 1]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else if (baselineIndex == topRopeGradeArray.length - 1) {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex - 2]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex - 1]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            }
                            climbNumber++;
                        } else {
                            int randomNumber = new Random().nextInt(4);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex - 2]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex - 1]);
                            } else if (randomNumber == 2) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        }
                    }
                }
            else if (climbType.equals("2")) {
                int baselineIndex = Arrays.asList(boulderGradeArray).indexOf(baseline);
                int climbNumber = 1;
                    for (int i = 1; i <= routeNumberValue; i++) {/*Climbing grades are exponentially difficult, if user's baseline is among
                                              the first 2 grades, the workout can include -1 baseline at the easiest unless baseline is the lowest grade*/
                        if (baselineIndex == 0) {
                            int randomNumber = new Random().nextInt(2);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else if (baselineIndex <= 2) {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex - 1]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else if (baselineIndex == (boulderGradeArray.length - 1)) {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex - 2]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex - 1]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            }
                            climbNumber++;
                        } else {
                            int randomNumber = new Random().nextInt(4);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex - 2]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex - 1]);
                            } else if (randomNumber == 2) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        }
                    }
                }
        }else if (workoutIntensity.equals("2")) {
            if (climbType.equals("1")) {
                int baselineIndex = Arrays.asList(topRopeGradeArray).indexOf(baseline);
                int climbNumber = 1;
                    for (int i = 1; i <= routeNumberValue; i++) {
                        if (baselineIndex == topRopeGradeArray.length - 1) {
                            workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            climbNumber++;
                        } else if (baselineIndex == (topRopeGradeArray.length - 2)) {
                            int randomNumber = new Random().nextInt(2);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 1]);
                            } else {
                                workoutRoutes.put(climbNumber, topRopeGradeArray[baselineIndex + 2]);
                            }
                            climbNumber++;
                        }
                    }
                }
            else if (climbType.equals("2")) {
                int baselineIndex = Arrays.asList(boulderGradeArray).indexOf(baseline);
                int climbNumber = 1;
                    for (int i = 1; i <= routeNumberValue; i++) {
                        if (baselineIndex == boulderGradeArray.length - 1) {
                            workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            climbNumber++;
                        } else if (baselineIndex >= (boulderGradeArray.length - 2)) {
                            int randomNumber = new Random().nextInt(2);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 1]);
                            }
                            climbNumber++;
                        } else {
                            int randomNumber = new Random().nextInt(3);
                            if (randomNumber == 0) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex]);
                            } else if (randomNumber == 1) {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 1]);
                            } else {
                                workoutRoutes.put(climbNumber, boulderGradeArray[baselineIndex + 2]);
                            }
                            climbNumber++;
                        }
                    }
                }
            }
        System.out.println();
        System.out.println("\nYour Workout for the Day.");
        System.out.println("\t  Get After It!\n");
        for (Map.Entry<Integer, String> entry : workoutRoutes.entrySet()) {
            System.out.println("Climb# " + entry.getKey() + "  :  " + entry.getValue());
        }
    }
}










