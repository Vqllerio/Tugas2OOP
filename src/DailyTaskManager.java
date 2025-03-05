import java.util.Scanner;

public class DailyTaskManager{
    public static void main(String[] args) throws Exception {
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
        System.out.println("1. View Tasks\n2. Edit tasks\n3. Exit");
        System.out.print("Input a number between 1-3 :");
        int userinput = scanner.nextInt();

        //Print Genshin Impact Tasks
        System.out.println("Genshin Impact Tasks:");
        for (int i = 0; i < arrStacks.length; i++){
            System.out.println((i+1) +". " + arrStacks[i]);
        }

        //Border to seperate the two
        System.out.println("\n===========================\n");

        //Print Morning Routine/set of tasks
        System.out.println("Morning Routine:");
        Tasks listTasks = new Tasks();
        int count = 1;
        for (String task : listTasks.getTasks()){
            System.out.println(count+". "+task);
            count++;
        }
    }
}