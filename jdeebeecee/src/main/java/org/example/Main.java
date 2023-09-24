import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/emp";
        String username = "root";
        String password = "mysql";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            //display
            displayEmployeeTable(connection);

            //insert
            System.out.println("Insertion");
            insertEmployee(connection, "John Doe", "Manager");
            displayEmployeeTable(connection);

            //delete
            deleteEmployee(connection, 1);
            displayEmployeeTable(connection);

            // Update
            updateEmployeePosition(connection, 3, "asst. manager");
            displayEmployeeTable(connection);

            System.out.println("All Operations Completed");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error!");
        }
    }

    private static void displayEmployeeTable(Connection connection) throws SQLException {
        String sqlQuery = "SELECT id, name, position FROM employee";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Employee Table:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String position = resultSet.getString("position");
            System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position);
        }
        System.out.println();
        resultSet.close();
        preparedStatement.close();
    }

    private static void insertEmployee(Connection connection, String name, String position) throws SQLException {
        String sqlQuery = "INSERT INTO employee (name, position) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, position);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    private static void deleteEmployee(Connection connection, int id) throws SQLException {
        String sqlQuery = "DELETE FROM employee WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Deleted employee with ID: " + id);
        preparedStatement.close();
    }

    private static void updateEmployeePosition(Connection connection, int id, String newPosition) throws SQLException {
        String sqlQuery = "UPDATE employee SET position = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, newPosition);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        System.out.println("Updated position for employee with ID " + id + " to " + newPosition);
        preparedStatement.close();
    }
}