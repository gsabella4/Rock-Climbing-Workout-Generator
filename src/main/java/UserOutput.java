



public class UserOutput {

    public static void introDisplay(){
        System.out.println("\n☺・☻・☺・☻・Welcome to the Rock Climbing Workout Generator・☻・☺・☻・☺\n");

        System.out.println("          /\\");
        System.out.println("         /**\\");
        System.out.println("        /****\\   /\\");
        System.out.println("       /      \\ /**\\");
        System.out.println("      /  /\\    /    \\        /\\    /\\  /\\      /\\            /\\/\\/\\  /\\");
        System.out.println("     /  /  \\  /      \\      /  \\/\\/  \\/  \\  /\\/  \\/\\  /\\  /\\/ / /  \\/  \\");
        System.out.println("    /  /    \\/ /\\     \\    /    \\ \\  /    \\/ /   /  \\/  \\/  \\  /    \\   \\");
        System.out.println("   /  /      \\/  \\/\\   \\  /      \\    /   /    \\");
        System.out.println("__/__/_______/___/__\\___\\__________________________________________________");
    }

    public static void numberOfSendsPrompt(){
        System.out.print("\nHow many routes would you like to send today?  ");
    }

    public static void climbTypeMenu(){
        System.out.println("\nWhat type of climbing will you be doing?");
        System.out.println("Enter 1 for Top Rope");
        System.out.println("Enter 2 for Bouldering");
    }

    public static void baseLinePrompt(){
        System.out.print("\nWhat is your Baseline?\tFor Top Rope(Baselines range from 5.5 to 12d) --- For Bouldering(Baselines range from VB to V10)  ");
    }

    public static void workoutIntensityMenu(){
        System.out.println("\nPlease select your workout type");
        System.out.println("Enter 1 for Normal");
        System.out.println("Enter 2 for Full Send");
    }

    public static void outroDisplay(){
        System.out.println("\n\t       /\\");
        System.out.println("\t      /**\\");
        System.out.println("\t     /****\\");
        System.out.println("\t    /*/\\***\\");
        System.out.println("\t   / /**\\   \\  /\\");
        System.out.println("\t  / /    \\   \\/YY\\");
        System.out.println("\t /\\ /YYYYYY\\   \\YYY\\");
        System.out.println("\t/  \\YYYYYYYY\\YYY\\YYY\\");
        System.out.println("\n\n\tYour Workout for the Day. Get After It!");
        System.out.println("\t☺・☻・☺・☻・☺・☻・☺・☻・☺・☻・☺・☻\n");
    }

    public static String workoutPrintFormat(){
        return "\t\t\t  Climb# %2s  :  %-17s\n";
    }

    public static String workoutTextFileFormat(){
        return "Climb# %2s  :  %-17s\n";
    }

    public static void anotherWorkoutPrompt(){
        System.out.print("\nWould you like to create another workout? Y/N:   ");
    }

    public static void goodbyeMessage(){
        System.out.println("\n          Don't forget your chalk!         ");
        System.out.println("\n☆彡*ー*★彡*ー*☆彡 Goodbye ☆彡*ー*★彡*ー*☆彡");
    }
}
