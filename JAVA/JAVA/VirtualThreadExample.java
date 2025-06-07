public class VirtualThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Running in: " + Thread.currentThread());
        };

        // Creating a virtual thread
        Thread vt = Thread.ofVirtual().start(task);

        // Wait for the virtual thread to complete
        try {
            vt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
