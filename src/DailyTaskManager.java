import java.util.Scanner;
public class DailyTaskManager{

    public static void clear(){
        System.out.print("\033c");
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {

        //border variable to quickly print borders between sections of CLI
        String border = ("\n" + "=".repeat(20) + "\n");

        //First and foremost, clears the terminal, standard good CLI program practice.
        clear();

        String beyondparameters = "Your Input is Beyond our Parameters, Please Try Again.";

        Tasks listTasks = new Tasks();

        @SuppressWarnings("rawtypes")
        LinkedList linkedlist = new LinkedList();

        //initializes a linked list filled with values
        for (String rltasks : listTasks.getTasks()){
            linkedlist.insert(rltasks);
        }

        //Arrat of Genshin Tasks
        String arrStacks[] = {"Complete Dailies",
                              "Do a world boss",
                              "Craft shit, ig",
                              "Stock up on Food Buffs",
                              "Clear bosses",
                              "Gather Materials",
                              "Do world Puzzels"};

        //init a scanner object to be able to read from the terminal
        Scanner scanner = new Scanner(System.in);

        //the beginning of the CLI
        System.out.print("Hello! Welcome to the DailyTaskManager");
        Thread.sleep(1500);
        clear();

        //Looping of the whole program!
        while (true){
            //Tells your the menu options
            System.out.println("MAIN MENU:");
            System.out.println("1. View Tasks");
            System.out.println("2. Exit");
            System.out.print("Input a Number Between 1 and 2 : ");

            //user input for the menu, 1 is View Tasks, and 2 is Exit the program.
            int userinputmenu = scanner.nextInt(); 
            clear();

            //checks first if the user's input is within the parameters
            if (userinputmenu != 1 && userinputmenu != 2){
                System.out.println(beyondparameters);
            } 
            
            //if the user is within the parameters, checks if the user chose to View Tasks.
            else if (userinputmenu == 1){
                System.out.print("\033c");

                //Looping to pick which tasks does the user want to view
                while (true){
                System.out.println("Type of Tasks");
                System.out.println("1. Genshin Impact Tasks");
                System.out.println("2. Morning Routine");
                System.out.println("3. Back to Menu");
                System.out.print("Input a number between 1 - 3 : ");

                //prompts the user to enter what kind of task they want to view
                int userinput = scanner.nextInt();
                clear();

                //List of tasks made with an Array
                if (userinput == 1){

                    //showing Genshin Impact Tasks
                    System.out.println("Genshin Impact Tasks:");
                    for (int i = 0; i < arrStacks.length; i++){
                        System.out.println((i+1) +". " + arrStacks[i]);
                    }

                    //menu part
                    System.out.println("Menu:");
                    System.out.println("1. Edit Tasks");
                    System.out.println("2. Back to Main Menu");
                    int editorno1 = scanner.nextInt();
                    clear();

                    if (editorno1 == 1){

                    }
                    else if (editorno1 == 2){
                        System.out.println("Going back to Main Menu...");
                        Thread.sleep(1000);
                        clear();
                        break;
                    }
                    else {
                        System.out.println(beyondparameters);
                    }
                } 
                
                //List of tasks made with and Linked List
                else if (userinput == 2){
                    System.out.println("Morning Routine:");
                    linkedlist.printlist();
                    System.out.print("Do you want to edit your tasks?");
                }
                else {
                    System.out.println("Going back to the Main Menu...");
                    Thread.sleep(1500);
                    clear();
                    break;
                }
                scanner.nextInt();
                clear();
                } 
            } else {
                clear();
                System.out.println("Closing the program...");
                Thread.sleep(1500);
                break;
            }
        }
        //close the scanner after the loop of the whole program is finished to save memory
        scanner.close();
    }
}