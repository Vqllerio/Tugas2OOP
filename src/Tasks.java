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

    public static void updatetaskgenshin(int index, String value) {
        Genshintasks[index] = value;
        saveTasksGenshin();
    }

    static void saveTasksGenshin() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(genshinfile))) {
            for (String task : Genshintasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static void saveTasksRL(LinkedList<String> linkedList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rlfile))) {
            LinkedList.Node<String> current = linkedList.getHead(); // Get the head of the linked list

            while (current != null) {
                writer.write(current.data);
                writer.newLine();
                current = current.next;
            }
        } catch (IOException exception) {
            System.out.println("Error saving tasks: " + exception.getMessage());
        }
    }

    public static void loadTasksRL(LinkedList<String> linkedList) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rlfile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                linkedList.insert(line);
            }
        } catch (IOException exception) {
            System.out.println("Error loading tasks: " + exception.getMessage());
        }
    }

}

