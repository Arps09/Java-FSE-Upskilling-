import java.util.ArrayList;
import java.util.Collections;
public class LambdaSort {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println("Sorted List: " + list);
    }
}
