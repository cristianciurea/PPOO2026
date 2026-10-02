import java.sql.*;

public class JDBCConnection {

    public static final String DB_URL = "jdbc:derby:C:\\Users\\Administrator\\ExempluJavaDB2;create=true";
    public static final String USERNAME = "admin";
    public static final String PASS = "admin";

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;

        try {
            //conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conectare cu succes!");

            stmt = conn.createStatement();

            String sqlCreate = "CREATE TABLE student(COD INT PRIMARY KEY, NUME VARCHAR(10), VARSTA INT, SEX VARCHAR(2), CNP VARCHAR(13))";
            stmt.executeUpdate(sqlCreate);
            System.out.println("Tabela creata cu succes!");

            String sqlInsert = "INSERT INTO student VALUES(100, 'Gigel', 23, 'M', '1234567890123')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Date inserate cu succes!");

            String sqlUpdate = "UPDATE student SET NUME = 'Viorel' WHERE COD = 100";
            stmt.executeUpdate(sqlUpdate);
            System.out.println("Date actualizate cu succes!");

            String sqlDelete = "DELETE FROM student WHERE COD=100";
            //stmt.executeUpdate(sqlDelete);
            System.out.println("Date sterse cu succes!");

            String sqlInsert2 = "INSERT INTO student VALUES(200, 'Ionel', 23, 'M', '1234567890123')";
            stmt.executeUpdate(sqlInsert2);
            System.out.println("Date inserate cu succes!");

            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            int nr = 0;
            while(rs.next())
            {
                System.out.println(++nr+" Nume: "+
                        rs.getString(2)+" Varsta "+
                        rs.getInt(3));
            }

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("Nr. coloane: "+rsmd.getColumnCount());
            for(int i=1;i<=rsmd.getColumnCount();i++)
                System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i)+" "+rsmd.getColumnDisplaySize(i));

            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
