import java.util.Scanner;

public class DailyTaskManager{
    public static void main(String[] args) throws Exception {
        String border = ("\n" + "=".repeat(20) + "\n");
        //First and foremost, clears the terminal, standard good CLI program practice.
        System.out.print("\033c");
        String arrStacks[] = {"Complete Dailies",
                              "Do a world bodd",
                              "Craft shit, ig",
                              "Stock up on Food Buffs",
                              "Clear bosses",
                              "Gather Materials",
                              "Do world Puzzels"};

        Scanner scanner = new Scanner(System.in);

        //the beginning of the CLI
        System.out.println("Hello! Welcome to the DailyTaskManager");
        while (true){
            System.out.println("1. View Tasks\n2. Edit Tasks\n3. Exit");
            System.out.print("Input a number between 1 - 3 : ");
            int userinputmenu = scanner.nextInt(); 
            if (userinputmenu == 1){
            System.out.println("\033c");
            while (true){
                System.out.println("Type of Tasks");
                System.out.println("1. Genshin Impact Tasks\n2. Morning Routine\n3. Back to Menu");
                System.out.print("Input a number between 1 - 3 : ");
                int userinput = scanner.nextInt();
                if (userinput == 1){
                    System.out.println("Genshin Impact Tasks:");
                    for (int i = 0; i < arrStacks.length; i++){
                        System.out.println((i+1) +". " + arrStacks[i]);
                    }
                } else if (userinput == 2){
                    System.out.println("Morning Routine:");
                    Tasks listTasks = new Tasks();
                    int count = 1;
                    for (String task : listTasks.getTasks()){
                        System.out.println(count+". "+task);
                        count++;
                        }
                    }
                } 
            }else if (userinputmenu == 3){
                System.out.print("\033c");
                System.out.println("Closing the program");
                break;
            } else {
                System.out.println("Your input is beyond our parameters, please try again.");
            }
        }
        scanner.close();
    }
}