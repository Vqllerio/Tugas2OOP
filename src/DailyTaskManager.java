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

        System.out.println("Before we start the program, we'd like to know your name :3");
        System.out.print("You Name : ");
        String name = scanner.nextLine();

        //the beginning of the CLI - starts with an animation of a stickman
        Functions.startingAnimation(name);

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
                mainLooping(scanner, rlstack, gstack, linkedlist);
            } 

            //Closes the program if the userinputmenu is 2
            else if (userinputmenu == 2){
                Functions.closeProgram();
                break;
            }
            
            //Expresses that the input is out of bounds, outside of the program's parameters
            else {
                Functions.beyondparam();
            }

        Functions.clear();
        }

        //close the scanner after the loop of the whole program is finished to save memory
        scanner.close();

        //closing animation to say good bye to the user buh bye
        Functions.closingAnimation(name);
    }

    //main menu of the program
    private static void showMainMenu(){
            System.out.println("=====[MAIN MENU]=====");
            System.out.println("1. View Tasks");
            System.out.println("2. Exit");
            System.out.print("Input a Number Between 1 and 2 : ");
    }

    //change one of the genshin tasks
    private static void changeGenshinTask(Scanner scanner){

        //shows the genshin tasks
        Functions.displaygenshintask();

        //asking for input, which tasks do they want to change
        System.out.print("Enter the number corresponsing to the Task that you want to change : ");
        int inputint = scanner.nextInt();
        scanner.nextLine();

        //asking for inupt, what to replace the task with
        System.out.println("What do you want to change the task \"" + Tasks.Genshintasks[inputint - 1] + "\" into?");
        System.out.print("Enter your replacement task here : ");
        String inputString = scanner.nextLine();
        Functions.clear();

        //User Input Validation and actually replacing the task
        System.out.println("Changing the task\"" + Tasks.Genshintasks[inputint - 1] + "\" into " + inputString);
        Tasks.updatetaskgenshin(inputint - 1, inputString);
        Functions.clear();
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void undoRealLifeTask(Stack<String> rlstack, LinkedList linkedlist) throws InterruptedException{

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

    private static void markGenshinTaskComplete(int inputint, Scanner scanner, Stack<String> gstack) throws InterruptedException{

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void markRealLifeComplete(int inputint, LinkedList linkedlist, Scanner scanner, Stack<String> rlstack) throws InterruptedException{

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void addNewTask(LinkedList linkedlist, int inputint, Scanner scanner){

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static void removeTask(LinkedList linkedlist, int inputint, Scanner scanner){

        linkedlist.printlist();

        System.out.print("Enter at which point do you want to remove a task : ");
        inputint = scanner.nextInt();
        Functions.clear();

        System.out.println("Removing the task " + linkedlist.checkAt(inputint -1));
        linkedlist.removeAt(inputint - 1);
        Tasks.saveTasksRL(linkedlist);
    }

    //editing menu for genshin tasks
    private static void genshinTaskEditing(Scanner scanner, Stack<String> gstack, int inputint) throws InterruptedException{

        while (true) {
        
            //showing genshin tasks
            Functions.displaygenshintask();

            //menu part
            System.out.println("Menu:");
            System.out.println("1. Mark a task as Completed");
            System.out.println("2. Undo Completed");
            System.out.println("3. Change a Task");
            System.out.println("4. Back to Main Menu");
            System.out.print("Input a Number Between 1 - 4 : ");
            inputint = scanner.nextInt();
            Functions.clear();
            
            if (inputint < 4 && 4 > inputint){
                switch (inputint) {
                    case 1: // Marks a task as complete if the input is 1
                    markGenshinTaskComplete(inputint, scanner, gstack);
                    break;
                    case 2: // Undo's a marked task if the input is 2
                    undoGenshinTask(gstack);
                    break;
                    case 3: //Changes a task if the input is 3
                    changeGenshinTask(scanner);
                    break;
                    default: //Expresses that the input is out of bounds, outside of the programs's parameters
                    Functions.beyondparam();
                }
            }

            //Goes back to the Main Menu if the input is 4
            else {
                Functions.backToMainMenu();
                break;
            }
        }
    }

    //Editing menu for real life tasks
    @SuppressWarnings("rawtypes")
    private static void realLifeTasksEditing(LinkedList linkedlist, int inputint, Scanner scanner, Stack<String> rlstack) throws InterruptedException{

        while (true){

            //Showing real life tasks
            linkedlist.printlist();

            //menu part
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

            if (inputint < 5 && 5 > inputint){
                switch (inputint){
                    case 1: //Marks a task as complete if the input is 1
                    markRealLifeComplete(inputint, linkedlist, scanner, rlstack);
                    break;
                    case 2: //Undo's a marked task
                    undoRealLifeTask(rlstack, linkedlist);
                    break;
                    case 3: //Adds a task to the linked list if the input is 3
                    addNewTask(linkedlist, inputint, scanner);
                    break;
                    case 4: //Removes a task to the linked list if the input is 4
                    removeTask(linkedlist, inputint, scanner);
                    break;
                    default: //Expresses that the input is out of bounds, out of the program's parameters
                    Functions.beyondparam();
                } 
            }else { //Goes back to the main menu if the input is 5
                Functions.backToMainMenu();
                break;
            }
        }
    }

    //Genshin Tasks Menu
    private static void genshinTasksMenu(int inputint, Scanner scanner,Stack<String> gstack) throws InterruptedException{
        
        //showing Genshin Impact Tasks
        Functions.displaygenshintask();

        //menu part
        System.out.println("Menu:");
        System.out.println("1. Edit Tasks");
        System.out.println("2. Back");
        System.out.print("Input a Number Between 1 and 2 : ");
        inputint = scanner.nextInt();
        Functions.clear();

        switch (inputint){
            case 1: // Edits Genshin Tasks
            genshinTaskEditing(scanner, gstack, inputint);
            break;
            case 2: // Goes back to the Main menu if the input is 2
            Functions.backtoPreviousMenu();
            break;
            default : // Expresses that the input is out of bounds, outside of the program's parameters
            Functions.beyondparam();
        }
    }

    //Real Life Tasks Menu
    @SuppressWarnings("rawtypes")
    private static void realLifeTasksMenu(int inputint, Scanner scanner, Stack<String> rlstack, LinkedList linkedlist) throws InterruptedException{
        
        //Displays the list of tasks from the linked list with numbers.
        linkedlist.printlist();
        System.out.println("Menu:");
        System.out.println("1. Edit Tasks");
        System.out.println("2. Back");
        System.out.print("Input a Number Between 1 and 2 : ");

        //Asking for userinput, choose between edit the tasks shown or back to menu
        inputint = scanner.nextInt();
        Functions.clear();

        switch (inputint){
            case 1: //Edit Tasks if the input is 1
            realLifeTasksEditing(linkedlist, inputint, scanner, rlstack);
            break;
            case 2: //Goes back to the main menu if the input is 2
            Functions.backtoPreviousMenu();
            break;
            default: //Expresses that the input is out of bounds, out of the program's parameters
            Functions.beyondparam();
        }
    }

    //main looping for the menus and types of tasks
    @SuppressWarnings("rawtypes")
    private static void mainLooping(Scanner scanner, Stack<String> rlstack, Stack<String> gstack, LinkedList linkedlist) throws InterruptedException{
        
        while (true) {
            System.out.println("Type of Tasks");
            System.out.println("1. Genshin Impact Tasks");
            System.out.println("2. Morning Routine");
            System.out.println("3. Back to Menu");
            System.out.print("Input a number between 1 - 3 : ");

            //prompts the user to enter what kind of task they want to view
            int inputint = scanner.nextInt();
            Functions.clear();

            if (inputint < 3 && 3 > inputint){
                switch (inputint){
                    case 1: //List of tasks made with an Array
                    genshinTasksMenu(inputint, scanner, gstack);
                    break;
                    case 2: //List of tasks made with and Linked List
                    realLifeTasksMenu(inputint, scanner, rlstack, linkedlist);
                    break;
                    default: //Expresses that the input is out of bounds, out of the program's parameters
                    Functions.beyondparam();
                }
            } else { //Goes back to the main menu if the input is 3
                Functions.backToMainMenu();
                break;
            }
        }
    }
}