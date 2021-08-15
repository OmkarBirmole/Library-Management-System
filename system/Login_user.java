package library.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login_user extends JFrame implements ActionListener{

	private final JPanel panel;
	private final JTextField textField;
	private final JPasswordField passwordField;
	private final JButton b1;
	private final JButton b2;
	private final JButton b3;


	public Login_user() {
            
	setBackground(Color.WHITE);
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
	panel.setBackground(Color.WHITE);
	setContentPane(panel);
	panel.setLayout(null);

	JLabel l1 = new JLabel("Username : ");
	l1.setFont(new Font("Raleway", Font.BOLD, 20));
	l1.setBounds(210, 89, 125, 24);
	panel.add(l1);

	JLabel l2 = new JLabel("Password : ");
	l2.setFont(new Font("Raleway", Font.BOLD, 20));
	l2.setBounds(210, 150, 125, 24);
	panel.add(l2);

	JLabel l3 = new JLabel("WELCOME");
	l3.setFont(new Font("Osward", Font.BOLD, 38));
	l3.setForeground(new Color(249, 208, 5  ));
	l3.setBounds(180,20,450,40);
	add(l3);

	textField = new JTextField();
	textField.setBounds(210, 120, 157, 25);
	panel.add(textField);
	
	passwordField = new JPasswordField();
	passwordField.setBounds(210, 180, 157, 25);
	add(passwordField);


	b1 = new JButton("Login");
	b1.addActionListener(this);
	b1.setForeground(new Color(255, 255, 255));
	b1.setBackground(new Color(31, 102, 230));
	b1.setBounds(180, 215, 103, 30);
	panel.add(b1);
		
	b2 = new JButton("SignUp");
	b2.addActionListener(this);
	b2.setForeground(new Color(31, 230, 135 ));
	b2.setBackground(new Color(31, 102, 230 ));
	b2.setBounds(290, 215, 103, 30);
	panel.add(b2);

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	
        b3.setForeground(new Color(31, 102, 230));
	b3.setBackground(new Color(236, 236, 236 ));
	b3.setBounds(210, 300, 157, 30);
	panel.add(b3);

	JLabel l5 = new JLabel("Trouble in Login?");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
	l5.setForeground(new Color(251, 152, 144 ));
	l5.setBounds(230, 270, 130, 20);
	panel.add(l5);

	ImageIcon i20 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/logo.png"));
		Image i21 = i20.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
		ImageIcon i23 = new ImageIcon(i21);
		JLabel l11 = new JLabel(i23);
		l11.setBounds(100, 5, 75, 75);
		add(l11);
	}
        
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                Boolean status = false;
		try {
                    conn con = new conn();
                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);

                    st.setString(1, textField.getText());
                    st.setString(2, String.valueOf(passwordField.getPassword()));

                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        this.setVisible(false);
                        new Home().setVisible(true);
                    } else
			JOptionPane.showMessageDialog(null, "Invalid Login...!.");
                       
		} catch (Exception e2) {
                    e2.printStackTrace();
		}
            }
            if(ae.getSource() == b2){
                setVisible(false);
		Signup su = new Signup();
		su.setVisible(true);
            }   
            if(ae.getSource() == b3){
                setVisible(false);
		Forgot forgot = new Forgot();
		forgot.setVisible(true);
            }
        }
        
  	public static void main(String[] args) {
                new Login_user().setVisible(true);
	}

}
