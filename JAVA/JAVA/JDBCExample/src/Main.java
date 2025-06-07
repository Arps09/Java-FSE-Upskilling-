public class Main {
    public static void main(String[] args) {
        try {
            AccountDAO dao = new AccountDAO("students.db");

            // Add two accounts
            dao.addAccount("Alice", 1000);
            dao.addAccount("Bob", 500);

            // Print before
            System.out.println("Before Transfer:");
            dao.printAccounts();

            // Transfer ₹200 from Alice (id 1) to Bob (id 2)
            dao.transfer(1, 2, 200);

            // Print after
            System.out.println("After Transfer:");
            dao.printAccounts();

            dao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
