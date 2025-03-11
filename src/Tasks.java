import java.io.*;

public class Tasks {
    public static String[] Genshintasks = {
        "Complete Dailies",
        "Do a world boss",
        "Craft sht, ig",
        "Stock upon Food Buffs",
        "Clear Bosses",
        "Grind for mats",
        "Do world Puzzles"
    };

    public static String[] RLtasks = {
        "Get up in the morning",
        "Brush your teeth",
        "Take a Shower",
        "Get Changed",
        "Make Breakfast",
        "Have breakfast",
        "Go to Campus",
    };

    private static final String genshinfile = "Genshin Tasks.txt";
    private static final String rlfile = "Real Life Tasks.txt";

    //updates the index and then saves it
    public static void updatetaskgenshin(int index, String value) {
        Genshintasks[index] = value;
        saveTasksGenshin();
    }

    //inits a write and for every task in Genshintasks it writes the task and a newline (to seperate them)
    static void saveTasksGenshin() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(genshinfile))) {
            for (String task : Genshintasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException exception) { //cacthes the error
            exception.printStackTrace(); // helps indicate where the error is at if there is an error
        }
    }

    //inits a reader and for every line in the genshintasks txt file, it adds it to Genshintasks.
    public static void loadTasksGenshin() {
        File file = new File(genshinfile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < Genshintasks.length; i++) {
                String line = reader.readLine();
                if (line != null) {
                    Genshintasks[i] = line;
                }
            }
        } catch (IOException exception) { // cathes the error
            exception.printStackTrace(); // helps indicate where the error is at if there is an error
        }
    }

    //inits a writer and for every task in the reallifetask linked list, it writes the task and a new line (to seperate them)
    public static void saveTasksRL(LinkedList<String> linkedList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rlfile))) {
            LinkedList.Node<String> current = linkedList.getHead();

            while (current != null) {
                writer.write(current.data);
                writer.newLine();
                current = current.next;
            }
        } catch (IOException exception) { // catches the error
            System.out.println("Error saving tasks: " + exception.getMessage()); //helps indicate where the error is at if there is an error
        }
    }

    //inits a reader and for every line in the reallifeetasks txt file, it adds it to real life tasks linked list
    public static void loadTasksRL(LinkedList<String> linkedList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rlfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linkedList.insert(line);
            }
        } catch (IOException exception) { // catches the error
            System.out.println("Error loading tasks: " + exception.getMessage()); // helps indicate where the error is at if there is an error
        }
    }

}

