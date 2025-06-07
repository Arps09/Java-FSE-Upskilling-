import java.util.HashMap;
import java.util.Scanner;
public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        map.put(1, "Arpita");
        map.put(2, "Bob");
        map.put(3, "Charlie");
        System.out.print("Enter student ID: ");
        int id = sc.nextInt();
        if (map.containsKey(id))
            System.out.println("Name: " + map.get(id));
        else
            System.out.println("ID not found.");
    }
}
