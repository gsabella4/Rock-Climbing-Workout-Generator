
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ClimbingWorkout {

        public static void run(){

            //To-Do:
            // DONE --- UserInput & UserOutput handling all display and input from user
            // DONE --- write workout to a file, to showcase FileWriter
            // DONE --- options to calc another workout or exit
            // - exception handling for input type checks

            //Arrays to hold grades for both Top Rope and Bouldering. Grade is level of difficult, sorted in ascending order from easy to more difficult
            String[] topRopeGradeArray = {"5.5", "5.6", "5.7", "5.8", "5.9", "10a", "10b", "10c", "10d", "11a", "11b", "11c", "11d", "12a", "12b", "12c", "12d"};
            String[] boulderGradeArray = {"VB", "V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8", "V9", "V10"};

            //Map to hold climb# and route grade, will loop through at the end to display workout to the user.
            Map<Integer, String> workoutRoutes = new HashMap<>();

            //Welcome statement, could include some instructions here? anything to greet user, to help positive user experience
            UserOutput.introDisplay();

            //Asking for number of routes the user would like to climb, a route is one time up the wall. A "send" is the term for a completed climb.
            UserOutput.numberOfSendsPrompt();
            UserInput.numberOfSendsInput();

            //Type of Climbing: if User selects Top Rope, we'll utilize the top rope grading system, if selection is Bouldering, we'll use the boulder grades
            UserOutput.climbTypeMenu();
            UserInput.climbTypeInput();

            //baseline is a current performance level, this baseline will serve as a reference point for the route grades assigned in workout
            UserOutput.baseLinePrompt();
            UserInput.baseLineInput();

            //Workout type. Starting with 2 options - more relaxed workout or a difficult workout (Full Send). Selection will determine deviation from baseline.
            UserOutput.workoutIntensityMenu();
            UserInput.workoutIntensityInput();

            if (UserInput.getWorkoutIntensity().equals("1")) {
                if (UserInput.getClimbType().equals("1")) {
                    int baselineIndex = Arrays.asList(topRopeGradeArray).indexOf(UserInput.getBaseLine());
                    int climbNumber = 1;
                    for (int i = 1; i <= UserInput.getRouteNumber(); i++) {/*Climbing grades are exponentially difficult, if user's baseline is among
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
                } else if (UserInput.getClimbType().equals("2")) {
                    int baselineIndex = Arrays.asList(boulderGradeArray).indexOf(UserInput.getBaseLine());
                    int climbNumber = 1;
                    for (int i = 1; i <= UserInput.getRouteNumber(); i++) {/*Climbing grades are exponentially difficult, if user's baseline is among
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
            } else if (UserInput.getWorkoutIntensity().equals("2")) {
                if (UserInput.getClimbType().equals("1")) {
                    int baselineIndex = Arrays.asList(topRopeGradeArray).indexOf(UserInput.getBaseLine());
                    int climbNumber = 1;
                    for (int i = 1; i <= UserInput.getRouteNumber(); i++) {
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
                } else if (UserInput.getClimbType().equals("2")) {
                    int baselineIndex = Arrays.asList(boulderGradeArray).indexOf(UserInput.getBaseLine());
                    int climbNumber = 1;
                    for (int i = 1; i <= UserInput.getRouteNumber(); i++) {
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

            //print workout w/ current date to existing file workout.txt
            try (PrintWriter workoutOutput = new PrintWriter(new FileOutputStream("workout.txt", true))) {
                UserOutput.outroDisplay();
                workoutOutput.println("\nToday's Date: " + LocalDate.now() + "\nYour workout: ");
                for (Map.Entry<Integer, String> entry : workoutRoutes.entrySet()) {
                    System.out.printf(UserOutput.workoutPrintFormat(), entry.getKey(), entry.getValue());
                    workoutOutput.printf(UserOutput.workoutTextFileFormat(), entry.getKey(), entry.getValue());
                }
            } catch (FileNotFoundException e) {
                e.getMessage();
            }

            //prompt user to calculate another workout, if Yes, calls to re-run program. If No, exits program w/ a goodbye message.
            UserOutput.anotherWorkoutPrompt();
            UserInput.anotherWorkoutInput();
        }
    }











