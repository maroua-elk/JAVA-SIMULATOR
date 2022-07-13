// c'est un exemple de jdbc avant le test des 1000 utilisateurs

//--------------------------------------------------------------------------

// importation des packages
import java.sql.*;

public class JDBC_exmp {

    // jdbc driver
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    // DB_URL contient le nom du dataBase (miniproject)
    // localhost signifie que la DB se trouve dans la meme machine
    static final String DB_URL = "jdbc:postgresql://localhost/miniproject";

    // DB credentials (pour garentir l'acces au DB)
    static final String USER = "postgres";
    static final String PASS = "jklm99999";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // ouvrire une connection
            System.out.println("connecting to DataBase...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // executer une requete
            System.out.println("Executing SQL query...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM covid19 WHERE codepays = 'MAR';";
            stmt.executeQuery(sql);
            System.out.println("Query executed successfully!!");
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("error during execution");
        }
    }

}
