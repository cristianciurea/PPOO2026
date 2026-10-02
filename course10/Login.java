package ro.ase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;

    public Login()
    {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField1.getText().equals("admin")
                        &&passwordField1.getText().equals("admin")) {
                    JOptionPane.showMessageDialog(null,
                            "Autentificare cu succes " + textField1.getText());
                }
                else
                    JOptionPane.showMessageDialog(null,
                            "Autentificare esuata!");
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Application");
        frame.setContentPane(new Login().panel1);
        frame.setBounds(1,1,650, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
