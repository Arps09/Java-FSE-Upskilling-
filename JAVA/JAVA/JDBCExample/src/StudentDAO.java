import java.sql.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO(String dbPath) throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }

    public void insertStudent(String name, int age) throws SQLException {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.executeUpdate();
            System.out.println("Student inserted: " + name);
        }
    }

    public void updateStudentAge(int id, int newAge) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newAge);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student with ID " + id + " updated.");
            else
                System.out.println("No student found with ID " + id);
        }
    }

    public void close() throws SQLException {
        if (conn != null) conn.close();
    }
}
