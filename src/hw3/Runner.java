package hw3;

import java.util.HashMap;

/**
 * Homework #3
 *
 * @author Aleksandr Kurov
 * @version dated Август 22, 2018
 */
public class Runner {
    public static void main(String[] args) {

        // Task 1:
        String[] words = new String[] {
            "thrust", "warn", "clinic", "thrust", "era",
            "narrow", "relaxation", "thrust", "moment",
            "thrust", "shortage", "swing", "thrust",
            "different", "moment", "term", "laboratory",
            "moment", "shortage", "era"
        };

        //showUnicWordsStat(words);

        // Task 2:
        String[][] phonesData = {
            {"Nash","89222451939"},
            {"Mccoy","89223439021"},
            {"Kelley","89221783489"},
            {"Francis","89229511581"},
            {"Mccoy","8128127721"},
            {"Schmitt","4952941555"},
            {"Francis","4953019243"},
            {"Mccoy","8129178142"},
        };

        PhoneBook pb = new PhoneBook();

        for(String[] record : phonesData) {
            pb.add(record[0], record[1]);
        }

        System.out.println("Search results:");
        System.out.println("Mccoy: " + pb.get("Mccoy"));
        System.out.println("Kelley: " + pb.get("Kelley"));
        System.out.println("Francis: " + pb.get("Francis"));

    }

    public static void showUnicWordsStat(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();

        for(String word : words) {
            if (hm.containsKey(word)) {
                hm.put(word, hm.get(word) + 1);
            } else {
                hm.put(word, 1);
            }
        }

        System.out.println("[Unic Word]\t[count]");
        for(String key : hm.keySet()) {
            System.out.println(String.format("%-8s\t%4s", key, hm.get(key)));
        }
    }
}
