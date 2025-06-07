import java.sql.*;

public class AccountDAO {
    private Connection conn;

    public AccountDAO(String dbPath) throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        createTable();
    }

    private void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS accounts (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "name TEXT NOT NULL," +
                     "balance REAL)";
        conn.createStatement().execute(sql);
    }

    public void addAccount(String name, double balance) throws SQLException {
        String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, balance);
            pstmt.executeUpdate();
        }
    }

    public void transfer(int fromId, int toId, double amount) throws SQLException {
        conn.setAutoCommit(false);  // Start transaction

        try {
            // Debit
            String debitSQL = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSQL)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromId);
                debitStmt.executeUpdate();
            }

            // Credit
            String creditSQL = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement creditStmt = conn.prepareStatement(creditSQL)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toId);
                creditStmt.executeUpdate();
            }

            conn.commit();  // Commit if both succeed
            System.out.println("Transaction Successful!");

        } catch (SQLException e) {
            System.out.println("Transaction Failed. Rolling back...");
            conn.rollback();  // Rollback on error
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true); // Reset auto-commit
        }
    }

    public void printAccounts() throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM accounts");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                               ", Name: " + rs.getString("name") +
                               ", Balance: " + rs.getDouble("balance"));
        }
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}
