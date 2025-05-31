record Person(String name, int age) {}
public class RecordExample {
    public static void main(String[] args) {
        Person p = new Person("Alice", 22);
        System.out.println(p.name() + ", " + p.age());
    }
}
