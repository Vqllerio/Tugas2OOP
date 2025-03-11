public class Functions {

    //Clears the terimnal for crisp CLI
    public static void clear(){
        System.out.print("\033c");
    }

    //Prints a Message that says the input is beyond the parameters, and waits for a bit before clearing the terminal
    public static void beyondparam() throws InterruptedException{
        System.out.println("Your Input is Beyond our Parameters, Please Try Again.");
        Thread.sleep(1000);
        clear();
    }

    //Animate the frames from the array of frames in Animation.java (OPENING)
    public static void startingAnimation(String name) throws InterruptedException{

        for (String frame : Animation.FramesOpening(name)){
            System.out.print("\033[?25l\033[H");
            System.out.print(frame);
            Thread.sleep(200);
        }
        Thread.sleep(1500);
        clear();
    }

    //Animate the frames from the array of frames in Animation.java (CLOSING)
    public static void closingAnimation(String name) throws InterruptedException{
        for (String frame : Animation.FramesClosing(name)){
            System.out.print("\033[?25l\033[H");
            System.out.print(frame);
            Thread.sleep(100);
        }
        Thread.sleep(1500);
        clear();
    }

    //Input Validation for better user experience ig, it was in the rubric for extra points, so...
    public static void backToMainMenu() throws InterruptedException{
        System.out.println("Going back to the Main Menu...");
        Thread.sleep(800);
        clear();
    }

    //Input Validation again
    public static void backtoPreviousMenu() throws InterruptedException{
        System.out.println("Going back to the Previous Menu");
        Thread.sleep(800);
        clear();
    }

    public static void closeProgram() throws InterruptedException{
        clear();
        System.out.println("Closing the program...");
        Thread.sleep(800);
    }

    //Prints the array of genshin tasks and a number going from 1 to the number of genshin tasks
    public static void displaygenshintask(){
        System.out.println("Genshin Impact Tasks:");
        for (int i = 0; i < Tasks.Genshintasks.length; i++){
            System.out.println((i+1) +". " + Tasks.Genshintasks[i]);
        }
    }

    //Undo's the element that was marked by detecting if the element of the element contains the element without the colors
    public static void undoGenshinCompleted(String elementUndo) throws InterruptedException{
        System.out.println("Undoing " + elementUndo);
        for (int i = 0 ; i < Tasks.Genshintasks.length ; i++){
            if (Tasks.Genshintasks[i].contains(elementUndo)){
                Tasks.Genshintasks[i] = elementUndo;
                Tasks.saveTasksGenshin();
            }
        }
        Thread.sleep(800);
    }

    //Marks a task completed by adding coloring unicodes at the front and back, green and reset/default in that order.
    public static void markGenshinCompleted(int i) throws InterruptedException{
        Tasks.Genshintasks[i] = "\u001B[32m" + Tasks.Genshintasks[i] +"\u001B[0m";
        Tasks.saveTasksGenshin();
        Thread.sleep(800);
    }
}
