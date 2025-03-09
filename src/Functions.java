
public class Functions {

    public static void clear(){
        System.out.print("\033c");
    }

    public static void displaygenshintask(){
        System.out.println("Genshin Impact Tasks:");
        for (int i = 0; i < Tasks.Genshintasks.length; i++){
            System.out.println((i+1) +". " + Tasks.Genshintasks[i]);
        }
    }
}
