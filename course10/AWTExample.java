import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AWTExample extends Frame implements ActionListener {

    String driver = null;
    String database = null;
    String username = null;
    String password = null;
    String sql = null;

    TextField tfDriver, tfDatabase, tfUsername, tfPassword, tfSql;
    Button button;
    TextArea textArea;
    Label status;

    public AWTExample()
    {
        setTitle("Database application");
        setLayout(new FlowLayout());

        Label label1 = new Label("Driver");
        add(label1);
        tfDriver = new TextField(60);
        tfDriver.setText("org.sqlite.JDBC");
        add(tfDriver);

        Label label2 = new Label("Database URL");
        add(label2);
        tfDatabase = new TextField(60);
        tfDatabase.setText("jdbc:sqlite:C:\\Users\\Administrator\\ExempluSQLite2");
        add(tfDatabase);

        Label label3 = new Label("Username");
        add(label3);
        tfUsername = new TextField(60);
        add(tfUsername);

        Label label4 = new Label("Password");
        add(label4);
        tfPassword = new TextField(60);
        add(tfPassword);

        Label label5 = new Label("SQL command");
        add(label5);
        tfSql = new TextField(60);
        tfSql.setText("SELECT * FROM student");
        add(tfSql);

        button = new Button("Executa");
        add(button);
        button.addActionListener(this);

        textArea = new TextArea(10, 60);
        add(textArea);

        status = new Label();
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
        AWTExample frame = new AWTExample();
        frame.setBounds(1,1,550, 600);
        frame.setVisible(true);
    }
}
