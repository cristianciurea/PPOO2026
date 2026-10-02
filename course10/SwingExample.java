import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SwingExample extends JFrame implements ActionListener {

    String driver = null;
    String database = null;
    String username = null;
    String password = null;
    String sql = null;

    JTextField tfDriver, tfDatabase, tfUsername, tfPassword, tfSql;
    JButton button;
    JTextArea textArea;
    JLabel status;

    public SwingExample()
    {
        setTitle("Database application");
        setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Driver");
        add(label1);
        tfDriver = new JTextField(60);
        tfDriver.setText("org.sqlite.JDBC");
        add(tfDriver);

        JLabel label2 = new JLabel("Database URL");
        add(label2);
        tfDatabase = new JTextField(60);
        tfDatabase.setText("jdbc:sqlite:C:\\Users\\Administrator\\ExempluSQLite2");
        add(tfDatabase);

        JLabel label3 = new JLabel("Username");
        add(label3);
        tfUsername = new JTextField(60);
        add(tfUsername);

        JLabel label4 = new JLabel("Password");
        add(label4);
        tfPassword = new JTextField(60);
        add(tfPassword);

        JLabel label5 = new JLabel("SQL command");
        add(label5);
        tfSql = new JTextField(60);
        tfSql.setText("SELECT * FROM student");
        add(tfSql);

        button = new JButton("Executa");
        add(button);
        button.addActionListener(this);

        textArea = new JTextArea(10, 60);
        add(textArea);

        status = new JLabel();
        add(status);

        addWindowListener(new MyWindowAdapter());

        textArea.addMouseListener(new MouseHandler());
        textArea.addMouseMotionListener(new MouseHandler());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        textArea.setText("");
        processData();
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(database, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            while (rs.next())
            {
                String record = "";
                for(int i=1;i<=numCols;i++)
                {
                    int dataType = rsmd.getColumnType(i);
                    record+=getField(rs, dataType, i)+" ";
                }
                textArea.append(record+"\n");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    class MyWindowAdapter extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private void processData()
    {
        driver = tfDriver.getText();
        if(driver.equals(""))
            driver = "org.sqlite.JDBC";

        database = tfDatabase.getText();
        if(database.equals(""))
            database = "jdbc:sqlite:C:\\Users\\Administrator\\ExempluSQLite2";

        username = tfUsername.getText();

        password = tfPassword.getText();

        sql = tfSql.getText();
        if(sql.equals(""))
            sql = "SELECT * FROM student";
    }

    private String getField(ResultSet rs, int dataType, int col) throws SQLException
    {
        switch (dataType)
        {
            case Types.VARCHAR:
                String str = rs.getString(col);
                return str;
            case Types.INTEGER:
                int x = rs.getInt(col);
                return String.valueOf(x);
        }
        return "";
    }

    class MouseHandler implements MouseListener,MouseMotionListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            status.setText("Mouse entered!");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            status.setText("Mouse exited!");
        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        SwingExample frame = new SwingExample();
        frame.setBounds(1,1,650, 500);
        frame.setVisible(true);
    }
}
