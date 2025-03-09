import java.util.Scanner;
public class DailyTaskManager{

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception {

        //First and foremost, clears the terminal, standard good CLI program practice i think...
        Functions.clear();

        String beyondparameters = "Your Input is Beyond our Parameters, Please Try Again.";

        LinkedList linkedlist = new LinkedList();

        //initializes a linked list filled with values from Tasks
        for (String rltasks : Tasks.Genshintasks){
            linkedlist.insert(rltasks);
        }

        Tasks.loadTasksGenshin();
        Tasks.loadTasksRL();

        //init a scanner object to be able to read from the terminal
        Scanner scanner = new Scanner(System.in);

        Stack<String> stack = new Stack<>(10);

        //the beginning of the CLI
        System.out.print("Hello! Welcome to the DailyTaskManager");
        Thread.sleep(1500);
        Functions.clear();

        //Looping of the whole program
        while (true){
            
            //Tells your the menu options
            System.out.println("MAIN MENU:");
            System.out.println("1. View Tasks");
            System.out.println("2. Exit");
            System.out.print("Input a Number Between 1 and 2 : ");

            //user input for the menu, 1 is View Tasks, and 2 is Exit the program.
            int userinputmenu = scanner.nextInt(); 
            Functions.clear();

            //if the user is within the parameters, checks if the user chose to View Tasks.
            if (userinputmenu == 1){

                //Looping to pick which tasks does the user want to view
                while (true){
                System.out.println("Type of Tasks");
                System.out.println("1. Genshin Impact Tasks");
                System.out.println("2. Morning Routine");
                System.out.println("3. Back to Menu");
                System.out.print("Input a number between 1 - 3 : ");

                //prompts the user to enter what kind of task they want to view
                int inputint = scanner.nextInt();
                Functions.clear();

                //List of tasks made with an Array
                if (inputint == 1){

                    //showing Genshin Impact Tasks
                    Functions.displaygenshintask();

                    //menu part
                    System.out.println("Menu:");
                    System.out.println("1. Edit Tasks");
                    System.out.println("2. Back to Main Menu");
                    System.out.print("Input a Number Between 1 and 2 : ");
                    inputint = scanner.nextInt();
                    Functions.clear();

                    if (inputint == 1){
                        Functions.displaygenshintask();
                        System.out.println("Menu:");
                        System.out.println("1. Mark a task as Completed");
                        System.out.println("2. Undo Completed");
                        System.out.println("3. Change a Task");
                        System.out.println("4. Back");
                        System.out.print("Input a Number Between 1 and 2 : ");
                        inputint = scanner.nextInt();
                        Functions.clear();

                        if (inputint == 1) {

                            System.out.println("Genshin Impact Tasks:");
                            for (int i = 0; i < Tasks.Genshintasks.length; i++){
                                System.out.println((i+1) +". " + Tasks.Genshintasks[i]);
                            }

                            System.out.print("Enter the number corresponding to the Task that you want to mark as complete : ");
                            inputint = scanner.nextInt();

                            for (int i = 0; i < Tasks.Genshintasks.length ; i ++){
                                if (inputint == i+1){
                                    System.out.println("Marking the task \""+ Tasks.Genshintasks[i]+"\" as completed.");
                                    stack.push(Tasks.Genshintasks[i]);
                                    Tasks.Genshintasks[i] = "\u001B[32m" + Tasks.Genshintasks[i] +"\u001B[0m";
                                    Tasks.saveTasksGenshin();
                                    Thread.sleep(800);
                                }
                            }
                        } 
                        else if (inputint == 2) {
                            boolean truefalse = stack.isEmpty();
                            if (truefalse = true) {
                                System.out.println("There are no more saved previous actions");
                            } 
                            else {
                                String elementtoundo = stack.pop();
                                for (int i = 0 ; i < Tasks.Genshintasks.length ; i++){
                                    if (Tasks.Genshintasks[i].contains(elementtoundo)) {
                                        Tasks.Genshintasks[i] = elementtoundo;
                                        Tasks.saveTasksGenshin();
                                    }
                                }
                            }
                        }
                        else if (inputint == 3) {

                            Functions.displaygenshintask();
                            System.out.print("Enter the number corresponsing to the Task that you want to change : ");
                            inputint = scanner.nextInt();
                            scanner.nextLine();

                            for (int i = 0; i < Tasks.Genshintasks.length; i++){
                                if (inputint == i+1){
                                    System.out.println("What do you want to change the task \"" + Tasks.Genshintasks[i] + "\" into?");
                                    System.out.print("Enter your replacement task here : ");
                                    String inputString = scanner.nextLine();
                                    
                                    System.out.println("Changing the task\"" + Tasks.Genshintasks[i] + "\" into " + inputString);
                                    Tasks.updatetask1(i, inputString);
                                    
                                }
                            }
                        }
                        else if (inputint == 4) {
                        }
                        else {
                            System.out.println(beyondparameters);
                        }
                    }
                    else if (inputint == 2){
                        System.out.println("Going back to Main Menu...");
                        Thread.sleep(800);
                        Functions.clear();
                        break;
                    }
                    else {
                        System.out.println(beyondparameters);
                    }
                } 
                
                //List of tasks made with and Linked List
                else if (inputint == 2){
                    System.out.println("Morning Routine:");
                    linkedlist.printlist();

                    //menu part
                    System.out.println("Menu:");
                    System.out.println("1. Edit Tasks");
                    System.out.println("2. Back to Main Menu");
                    System.out.print("Input a Number Between 1 and 2 : ");
                    inputint = scanner.nextInt();
                    Functions.clear();
                    if (inputint == 1){
                        System.out.println("Menu:");
                        System.out.println("1. Mark a Task as Complete");
                        System.out.println("2. Add a Task");
                        System.out.println("3. Remove a Task");
                    }
                }

                else if (inputint == 3) {
                    System.out.println("Going back to the Main Menu...");
                    Thread.sleep(800);
                    Functions.clear();
                    break;
                }

                else {
                    System.out.println(beyondparameters);
                    Thread.sleep(800);
                }
                Functions.clear();
                } 
            } else if (userinputmenu == 2){
                Functions.clear();
                System.out.println("Closing the program...");
                Thread.sleep(800);
                break;
            } else {
                System.out.println(beyondparameters);
                Thread.sleep(800);
            }
        Functions.clear();
        }
        //close the scanner after the loop of the whole program is finished to save memory
        scanner.close();
    }
}