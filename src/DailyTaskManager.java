import java.util.Scanner;

public class DailyTaskManager{
    public static void main(String[] args) throws Exception {

        System.out.print("\033c");
        Tasks listtasks = new Tasks();
        for (String task : listtasks.getTasks()){
            System.out.println(task);
        }
        LinkedList ll = new LinkedList();
    }
}
