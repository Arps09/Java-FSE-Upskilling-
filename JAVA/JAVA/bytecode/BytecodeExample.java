package bytecode;
public class BytecodeExample {
    public int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {
        BytecodeExample obj = new BytecodeExample();
        int result = obj.square(5);
        System.out.println("Result: " + result);
    }
}
