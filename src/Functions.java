
public class Functions {

    public static void clear(){
        System.out.print("\033c");
    }

    public static void beyondparam() throws InterruptedException{
        System.out.println("Your Input is Beyond our Parameters, Please Try Again.");
        Thread.sleep(800);
    }

    public static void startingAnimation() throws InterruptedException{
        for (String frame : Animation.FramesOpening){
            System.out.print("\033[?25l\033[H");
            System.out.print(frame);
            Thread.sleep(100);
        }
        Thread.sleep(1500);
        clear();
    }

    public static void closingAnimation() throws InterruptedException{
        for (String frame : Animation.FramesClosing){
            System.out.print("\033[?25l\033[H");
            System.out.print(frame);
            Thread.sleep(100);
        }
        Thread.sleep(1500);
        clear();
    }

    public static void backToMainMenu() throws InterruptedException{
        System.out.println("Going back to the Main Menu...");
        Thread.sleep(800);
        clear();
    }

    public static void displaygenshintask(){
        System.out.println("Genshin Impact Tasks:");
        for (int i = 0; i < Tasks.Genshintasks.length; i++){
            System.out.println((i+1) +". " + Tasks.Genshintasks[i]);
        }
    }

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

    public static void markGenshinCompleted(int i) throws InterruptedException{
        Tasks.Genshintasks[i] = "\u001B[32m" + Tasks.Genshintasks[i] +"\u001B[0m";
        Tasks.saveTasksGenshin();
        Thread.sleep(800);
    }
}
