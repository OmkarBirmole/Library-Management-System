package library.management.system;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddBook extends JFrame implements ActionListener{

    JPanel contentPane;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    JComboBox comboBox;
        
    public static void main(String[] args) {
	new AddBook().setVisible(true);
    }

//    public void random() {
//        Random rd = new Random();
//	t1.setText("" + rd.nextInt(1000 + 1));
//    }

    public AddBook() {
        setBounds(600, 200, 518, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel l1 = new JLabel("Name");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Tahoma", Font.BOLD, 14));
	l1.setBounds(73, 98, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("ISBN");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 131, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Publisher");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 164, 90, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Price");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Tahoma", Font.BOLD, 14));
	l4.setBounds(73, 230, 90, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Pages");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 263, 90, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Book_id");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Tahoma", Font.BOLD, 14));
	l6.setBounds(73, 67, 90, 22);
	contentPane.add(l6);

	JLabel l7 = new JLabel("Edition");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Tahoma", Font.BOLD, 14));
	l7.setBounds(73, 197, 90, 22);
	contentPane.add(l7);

		JLabel l8 = new JLabel("ADD BOOKS");
		l8.setForeground(new Color(204, 51, 102));
		l8.setFont(new Font("Osward", Font.BOLD, 38));
		l8.setBounds(150, 3, 701, 80);
		contentPane.add(l8);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Tahoma", Font.BOLD, 14));
	t1.setBounds(169, 70, 198, 23);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(169, 101, 198, 23);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(169, 134, 198, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(169, 167, 198, 23);
	contentPane.add(t4);

        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(169, 233, 198, 23);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(169, 266, 198, 23);
	contentPane.add(t6);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));
	comboBox.setBounds(169, 200, 194, 23);
	contentPane.add(comboBox);

        b1 = new JButton("Add");
	b1.addActionListener(this);
        b1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b1.setBounds(102, 314, 100, 33);
        b1.setBackground(Color.DARK_GRAY);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
	b2.setBounds(212, 314, 108, 33);
        b2.setBackground(Color.DARK_GRAY);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

//	JPanel panel = new JPanel();
//	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Add Books", TitledBorder.LEADING,
//			TitledBorder.TOP, null, new Color(0, 0, 255)));
//	panel.setBounds(10, 29, 398, 344);
//	contentPane.add(panel);
//
//        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);

    }
    
    public void actionPerformed(ActionEvent ae){
        try {
			if (ae.getSource() == b2) {
				this.setVisible(false);
				new Home().setVisible(true);
			}

			if (ae.getSource() == b1) {
				if (t6.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Fill all the required fields");
			} else {
				conn con = new conn();

					String sql = "insert into book(book_id, name, isbn, publisher, edition, price, pages) values(?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement st = con.c.prepareStatement(sql);

					st.setString(1, t1.getText());
					st.setString(2, t2.getText());
					st.setString(3, t3.getText());
					st.setString(4, t4.getText());
					st.setString(5, (String) comboBox.getSelectedItem());
					st.setString(6, t5.getText());
					st.setString(7, t6.getText());

					int rs = st.executeUpdate();
					if (rs > 0)
						JOptionPane.showMessageDialog(null, "Successfully Added");
					else
						JOptionPane.showMessageDialog(null, "Error");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					st.close();
					con.c.close();
				}
			}



		}catch(Exception e){
            
        }
    }
}
