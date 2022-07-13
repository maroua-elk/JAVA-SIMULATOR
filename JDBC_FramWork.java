// importation des packages
package project.project;

import java.sql.*;

public class JDBC_FramWork extends simulateur {
    // jdbc driver
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    // DB_URL contient le nom du dataBase (miniproject)
    // localhost signifie que la DB se trouve dans la meme machine
    static final String DB_URL = "jdbc:postgresql://localhost/miniproject";

    // DB credentials (pour garentir l'acces au DB)
    static final String USER = "postgres";
    static final String PASS = "jklm99999";

    Connection conn = null;

    public JDBC_FramWork() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(DB_URL);
            if (conn != null) {
                System.out.println("Connected to jdbc");
                delete();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create() {
        String sql = "INSERT INTO pays (codepays, pays, population2019, continent) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "MAR");
            statement.setString(2, "Morocco");
            statement.setInt(3, 36471766);
            statement.setString(4, "Africa");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void select() {
        String sql = "SELECT * FROM pays";

        Statement statement = null;
        try {
            statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update() {
        String sql = "UPDATE pays SET continent=?, pays=?, population2019=? WHERE codepays=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 784517668);
            statement.setString(2, "Morocco");
            statement.setString(3, "Africa");
            statement.setInt(3, 784517668);
            statement.setString(4, "MAR");

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete() {
        String sql = "DELETE FROM pays WHERE codepays=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "MAR");
            int rowsDeleted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}