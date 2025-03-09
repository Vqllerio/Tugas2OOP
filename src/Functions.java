public class Functions {

    public static void clear(){
        System.out.print("\033c");
    }

    public static void displaygenshintask(){

        Tasks listTasks = new Tasks();

        System.out.println("Genshin Impact Tasks:");
        for (int i = 0; i < listTasks.Genshintasks.length; i++){
            System.out.println((i+1) +". " + listTasks.Genshintasks[i]);
        }
    }
}
