import java.util.Scanner;
public class DailyTaskManager{
    public static void main(String[] args) throws Exception {

        //border variable to quickly print borders between sections of CLI
        String border = ("\n" + "=".repeat(20) + "\n");

        //First and foremost, clears the terminal, standard good CLI program practice.
        System.out.print("\033c");

        Tasks listTasks = new Tasks();
        LinkedList linkedlist = new LinkedList();

        //initializes a linked list filled with values
        for (String rltasks : listTasks.getTasks()){
            linkedlist.insert(rltasks);
        }

        //List of Genshin Tasks
        String arrStacks[] = {"Complete Dailies",
                              "Do a world bodd",
                              "Craft shit, ig",
                              "Stock up on Food Buffs",
                              "Clear bosses",
                              "Gather Materials",
                              "Do world Puzzels"};

        //init a scanner object to be able to read from the terminal
        Scanner scanner = new Scanner(System.in);

        //the beginning of the CLI
        System.out.println("Hello! Welcome to the DailyTaskManager");
        //Looping of the whole program!
        while (true){
            //Tells your the menu options
            System.out.println("1. View Tasks\n"+
                               "2. Exit\n"+
                               "Input a number Between 1 - 3 : ");

            //user input for the menu, 1 is View Tasks, and 2 is Exit the program.
            int userinputmenu = scanner.nextInt(); 
            
            //checks first if the user's input is within the parameters
            if (userinputmenu != 1 && userinputmenu != 2){
                System.out.println("Your input is beyond our parameters, please try again.");
            } else if (userinputmenu == 1){
                System.out.print("\033c");

                while (true){
                System.out.println("Type of Tasks");
                System.out.println("1. Genshin Impact Tasks\n2. Morning Routine\n3. Back to Menu");
                System.out.print("Input a number between 1 - 3 : ");
                int userinput = scanner.nextInt();

                //List of tasks made with an Array
                if (userinput == 1){
                    System.out.println("Genshin Impact Tasks:");
                    for (int i = 0; i < arrStacks.length; i++){
                        System.out.println((i+1) +". " + arrStacks[i]);
                    }
                System.out.println("Do you want to edit your tasks?");
                int editorno = scanner.nextInt();
                } 
                
                //List of tasks made with and Linked List
                else if (userinput == 2){
                    System.out.println("Morning Routine:");

                    int count = 1;
                    for (String task : listTasks.getTasks()){
                        System.out.println(count+". "+task);
                        count++;
                    }
                }
                } 
            } else {
                System.out.print("\033c");
                System.out.println("Closing the program");
                break;
            }
        }
        //close the scanner after the loop of the whole program is finished to save memory
        scanner.close();
    }
}