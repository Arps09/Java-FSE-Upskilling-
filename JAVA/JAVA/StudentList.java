import java.util.ArrayList;
import java.util.Scanner;
public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student names (type 'stop' to end):");
        while (true) {
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("stop")) break;
            names.add(name);
        }
        System.out.println("Student List: " + names);
    }
}
