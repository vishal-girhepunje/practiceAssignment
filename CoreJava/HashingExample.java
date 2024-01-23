package practiceAssignment.CoreJava;
import java.util.*;
public class HashingExample {
    public static void main(String[] args) {
        // Create a hash table to store student names and ages
        Map<String, Integer> studentAges = new HashMap<>();

        // Insert elements into the hash table
        studentAges.put("Alice", 20);
        studentAges.put("Bob", 22);
        studentAges.put("Charlie", 21);

        // Retrieve elements from the hash table
        System.out.println("Age of Alice: " + studentAges.get("Alice"));
        System.out.println("Age of Bob: " + studentAges.get("Bob"));

        // Check if a key exists in the hash table
        String searchKey = "Bob";
        if (studentAges.containsKey(searchKey)) {
            System.out.println(searchKey + " is in the hash table.");
        } else {
            System.out.println(searchKey + " is not in the hash table.");
        }

        // Remove an element from the hash table
        studentAges.remove("Charlie");

        // Display the updated hash table
        System.out.println("Updated hash table: " + studentAges);
    }
}
