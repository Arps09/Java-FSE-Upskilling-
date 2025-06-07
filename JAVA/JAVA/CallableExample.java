import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a single thread
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Create a Callable task
        Callable<Integer> task = () -> {
            int x = 5;
            int y = 10;
            return x + y; // Task returns a result
        };

        try {
            // Submit the task and get a Future object
            Future<Integer> future = executor.submit(task);

            // Get result from the Future
            int result = future.get();
            System.out.println("Result from Callable: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }
}
