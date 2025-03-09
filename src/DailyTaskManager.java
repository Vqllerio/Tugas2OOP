import java.util.Scanner;
public class DailyTaskManager{

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) throws Exception {

        //First and foremost, clears the terminal, standard good CLI program practice i think...
        Functions.clear();

        //init a linked list
        LinkedList linkedlist = new LinkedList();

        //loadds the list of tasks from the genshin and real life txt files
        Tasks.loadTasksGenshin();
        Tasks.loadTasksRL(linkedlist);

        //init a scanner object to be able to read from the terminal
        Scanner scanner = new Scanner(System.in);

        //init stack for both genshin tasks(array) and  the real life tasks(linked list) to undo.
        Stack<String> gstack = new Stack<>(10);
        Stack<String> rlstack = new Stack<>(10);

        //the beginning of the CLI - starts with an animation of a stickman
        Functions.startingAnimation();

        //Looping of the whole program
        while (true){
            
            //Tells your the menu options
            showMainMenu();

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

                        //Edit Tasks
                        if (inputint == 1){

                            Functions.displaygenshintask();
                            System.out.println("Menu:");
                            System.out.println("1. Mark a task as Completed");
                            System.out.println("2. Undo Completed");
                            System.out.println("3. Change a Task");
                            System.out.println("4. Back to Main Menu");
                            System.out.print("Input a Number Between 1 and 2 : ");
                            inputint = scanner.nextInt();
                            Functions.clear();

                            //Marks a task as complete if the input 1
                            if (inputint == 1) {

                                Functions.displaygenshintask();

                                System.out.print("Enter the number corresponding to the Task that you want to mark as complete : ");
                                inputint = scanner.nextInt();

                                for (int i = 0; i < Tasks.Genshintasks.length ; i ++){
                                    if (inputint == i+1){
                                        System.out.println("Marking the task \""+ Tasks.Genshintasks[i]+"\" as completed.");
                                        gstack.push(Tasks.Genshintasks[i]);
                                        Functions.markGenshinCompleted(i);
                                    }
                                Functions.clear();
                                }
                            } 

                            //Undo's a marked task if the input is 2
                            else if (inputint == 2){
                                undoGenshinTask(gstack);
                            }

                            //Changes a task if the input is 3
                            else if (inputint == 3){
                                changeGenshinTask(scanner);
                            }

                            //Goes back to the Main menu if the input is 4
                            else if (inputint == 4){
                                Functions.backToMainMenu();
                                break;
                            }

                            //Expresses that the input is out of bounds, outside of the program's parameters
                            else {
                                Functions.beyondparam();
                            }
                        }

                        // Goes back to the Main menu if the input is 2
                        else if (inputint == 2){
                            Functions.backToMainMenu();
                            break;
                        }

                        //Expresses that the input is out of bounds, outside of the program's parameters
                        else {
                            Functions.beyondparam();
                        }
                    } 
                    
                    //List of tasks made with and Linked List
                    else if (inputint == 2){

                        //Displays the list of tasks from the linked list with numbers.
                        linkedlist.printlist();
                        System.out.println("Menu:");
                        System.out.println("1. Edit Tasks");
                        System.out.println("2. Back to Main Menu");
                        System.out.print("Input a Number Between 1 and 2 : ");

                        //Asking for userinput, choose between edit the tasks shown or back to menu
                        inputint = scanner.nextInt();
                        Functions.clear();

                        //Edit Tasks if the input is 1
                        if (inputint == 1){
                            linkedlist.printlist();
                            System.out.println("Menu:");
                            System.out.println("1. Mark a Task as Complete");
                            System.out.println("2. Undo Completed");
                            System.out.println("3. Add a Task");
                            System.out.println("4. Remove a Task");
                            System.out.println("5. Back to Main Menu");
                            System.out.print("Input a Number Between 1 - 5 : ");

                            //Asking for userinput, choose between Mark Complete, Undo, Add Task, Remove Task, or Back to Main Menu.
                            inputint = scanner.nextInt();
                            Functions.clear();

                            //Marks a task as complete if the input is 1
                            if (inputint == 1){
                                linkedlist.printlist();
                                System.out.print("Enter the number corresponding to the Task that you want to mark as complete : ");
                                inputint = scanner.nextInt();

                                for (int i = 0; i < linkedlist.checkLength() ; i ++){
                                    if (inputint == i+1){
                                        System.out.println("Marking the task \""+ linkedlist.checkAt(i) +"\" as completed.");
                                        rlstack.push((String) linkedlist.checkAt(i));
                                        linkedlist.replaceAt(i, "\u001B[32m"+linkedlist.checkAt(i)+"\u001B[0m");
                                        Tasks.saveTasksRL(linkedlist);
                                        Thread.sleep(800);
                                    }
                                Functions.clear();
                                }
                            }

                            //Undo's a marked task
                            else if (inputint == 2){
                                @SuppressWarnings("unused")
                                boolean stackisempty = rlstack.isEmpty();
                                if (stackisempty = false){
                                    System.out.print("There are no more saved previous actions");
                                } 
                                else {
                                    String elementUndo = rlstack.pop();
                                    System.out.println("Undoing " + elementUndo);
                                    for (int i = 0 ; i < linkedlist.checkLength() ; i++){
                                        if (((String) linkedlist.checkAt(i)).contains(elementUndo)){
                                            linkedlist.replaceAt(i, elementUndo);
                                            Tasks.saveTasksRL(linkedlist);
                                        }
                                    }
                                    Thread.sleep(800);
                                }
                                Functions.clear();
                            }

                            //Adds a task to the linked list if the input is 3
                            else if (inputint == 3){
                                linkedlist.printlist();
                                System.out.print("Enter at which point do you want to insert a task : ");
                                inputint = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Enter the task that you want to add :");
                                String inputString = scanner.nextLine();
                                Functions.clear();

                                linkedlist.insertAt(inputString, inputint - 1);
                                Tasks.saveTasksRL(linkedlist);
                            }

                            //Removes a task to the linked list if the input is 4
                            else if (inputint == 4){
                                linkedlist.printlist();
                                System.out.print("Enter at which point do you want to remove a task : ");
                                inputint = scanner.nextInt();
                                Functions.clear();

                                System.out.println("Removing the task " + linkedlist.checkAt(inputint -1));
                                linkedlist.removeAt(inputint - 1);
                                Tasks.saveTasksRL(linkedlist);
                            }

                            //Goes back to the main menu if the input is 5
                            else if (inputint == 5){
                                Functions.backToMainMenu();
                                break;
                            }

                            //Expresses that the input is out of bounds, out of the program's parameters
                            else {
                                Functions.beyondparam();
                            }
                        }

                        //Goes back to the main menu if the input is 2
                        else if (inputint == 2){
                            Functions.backToMainMenu();
                        }

                        //Expresses that the input is out of bounds, out of the program's parameters
                        else {
                            Functions.beyondparam();
                        }
                    }

                    //Goes back to the main menu if the input is 3
                    else if (inputint == 3){
                        Functions.backToMainMenu();
                        break;
                    }

                    //Expresses that the input is out of bounds, out of the program's parameters
                    else {
                    Functions.beyondparam();
                }
                } 
            } else if (userinputmenu == 2){
                Functions.clear();
                System.out.println("Closing the program...");
                Thread.sleep(800);
                break;
            } else {
                Functions.beyondparam();
            }
        Functions.clear();
        }

        //close the scanner after the loop of the whole program is finished to save memory
        scanner.close();

        //closing animation to say good bye to the user
        Functions.closingAnimation();
    }

    private static void showMainMenu(){
            System.out.println("MAIN MENU:");
            System.out.println("1. View Tasks");
            System.out.println("2. Exit");
            System.out.print("Input a Number Between 1 and 2 : ");
    }

    private static void changeGenshinTask(Scanner scanner){
        Functions.displaygenshintask();

        System.out.print("Enter the number corresponsing to the Task that you want to change : ");
        int inputint = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < Tasks.Genshintasks.length; i++){
            if (inputint == i+1){
                System.out.println("What do you want to change the task \"" + Tasks.Genshintasks[i] + "\" into?");
                System.out.print("Enter your replacement task here : ");
                String inputString = scanner.nextLine();
                
                System.out.println("Changing the task\"" + Tasks.Genshintasks[i] + "\" into " + inputString);
                Tasks.updatetaskgenshin(i, inputString);
                
            }
        }
    }

    private static void undoGenshinTask(Stack<String> gstack) throws InterruptedException{
        @SuppressWarnings("unused")
        boolean stackisempty = gstack.isEmpty();
        if (stackisempty = false){
            System.out.print("There are no more saved previous actions");
        } 
        else {
            String elementUndo = gstack.pop();
            Functions.undoGenshinCompleted(elementUndo);
        }
        Functions.clear();

    }
    
}