package csed_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class metrobooking {

	private JFrame frame;
	private JTextField tn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					metrobooking window = new metrobooking();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public metrobooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metro Train TB");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(110, 11, 348, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBackground(new Color(72, 209, 204));
		lblNewLabel_1.setBounds(76, 57, 68, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("From Station");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(76, 87, 107, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("To Station");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_3.setBounds(76, 122, 120, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No.Tickets");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_4.setBounds(76, 154, 107, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		tn = new JTextField();
		tn.setBackground(new Color(211, 211, 211));
		tn.setBounds(196, 57, 86, 20);
		frame.getContentPane().add(tn);
		tn.setColumns(10);
		
		JComboBox cf = new JComboBox();
		cf.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nagool", "Paradise", "Parade Grounds", "JBS", "MGBS"}));
		cf.setBounds(196, 85, 86, 22);
		frame.getContentPane().add(cf);
		
		JComboBox ct = new JComboBox();
		ct.setModel(new DefaultComboBoxModel(new String[] {"Select", "Nagool", "Paradise", "Parade Grounds", "JBS", "MGBS"}));
		ct.setBounds(196, 120, 86, 22);
		frame.getContentPane().add(ct);
		
		JComboBox cn = new JComboBox();
		cn.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		cn.setBounds(196, 152, 86, 22);
		frame.getContentPane().add(cn);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tn.getText();
				String fs=(String) cf.getSelectedItem();
				String ts=(String) ct.getSelectedItem();
				String t=(String) cn.getSelectedItem();
				int tickets=Integer.parseInt(t);
				int bill=0;
				if(fs.equals("Paradise")&& ts.equals("Nagool"));
				{
					bill=tickets*20;
				}
				 if(fs.equals("Paradise")&& ts.equals("Parade Grounds"))
				{
					bill=tickets*30;
				}
				else
				{
			      JOptionPane.showMessageDialog(btnNewButton, "please select");
				}
				try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/5J7","root","mrec");
				String q="insert into bill values";
				Statement sta=con.createStatement();
				sta.execute(q);
				con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(138, 200, 89, 35);
		frame.getContentPane().add(btnNewButton);
	}
}
