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

    public static void updatetask1(int index, String value) {
        Genshintasks[index] = value;
        saveTasksGenshin();
    }

    public static void updatetask2(int index, String value) {
        RLtasks[index] = value;
        saveTasksRL();
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

    private static void saveTasksRL() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rlfile))) {
            for (String task : RLtasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTasksGenshin() {
        File file = new File(genshinfile);
        if (!file.exists()) return; // No file means no saved tasks

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < Genshintasks.length; i++) {
                String line = reader.readLine();
                if (line != null) {
                    Genshintasks[i] = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadTasksRL() {
        File file = new File(rlfile);
        if (!file.exists()) return; // No file means no saved tasks

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < RLtasks.length; i++) {
                String line = reader.readLine();
                if (line != null) {
                    RLtasks[i] = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}