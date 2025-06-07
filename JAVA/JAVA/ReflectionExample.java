import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Load the class
            Class<?> obj = Class.forName("bytecode.BytecodeExample"); // fully qualified name

            // Print class name
            System.out.println("Class Name: " + obj.getName());

            // Print all methods
            System.out.println("\nMethods:");
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            // Print fields
            System.out.println("\nFields:");
            Field[] fields = obj.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Print constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = obj.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
