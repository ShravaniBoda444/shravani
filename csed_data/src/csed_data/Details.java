package csed_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class Details {

	private JFrame frame;
	private JTextField tn;
	private JTextField te;
	private JTextField tp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
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
	public Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 497);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(53, 46, 76, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(53, 92, 72, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fav.Programming");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(53, 137, 144, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(53, 180, 120, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(53, 218, 76, 19);
		frame.getContentPane().add(lblNewLabel_4);
		
		tn = new JTextField();
		tn.setBounds(200, 50, 125, 20);
		frame.getContentPane().add(tn);
		tn.setColumns(10);
		
		te = new JTextField();
		te.setBounds(200, 96, 125, 20);
		frame.getContentPane().add(te);
		te.setColumns(10);
		
		JComboBox cp = new JComboBox();
		cp.setModel(new DefaultComboBoxModel(new String[] {"Select", "Java", "Python ", "C"}));
		cp.setBounds(200, 140, 125, 22);
		frame.getContentPane().add(cp);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma", Font.BOLD, 13));
		r1.setBounds(200, 179, 76, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma", Font.BOLD, 13));
		r2.setBounds(276, 180, 98, 23);
		frame.getContentPane().add(r2);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(265, 180, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		
		tp = new JTextField();
		tp.setFont(new Font("Tahoma", Font.BOLD, 13));
		tp.setBounds(200, 219, 125, 20);
		frame.getContentPane().add(tp);
		tp.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tn.getText();
				String email=te.getText();
				String favpl=(String) cp.getSelectedItem();
				String gender;
				if(r1.isSelected())
				{
					gender="Male";
				}
				else if(r2.isSelected())
				{
					gender="Female";
				}
				else
				{
					gender="Invalid";
				}
				String ph=tp.getText();
				int phno=Integer.parseInt(ph);
				JOptionPane.showMessageDialog(btnNewButton,"Hello \n"+name+"\n"+"Registration Done");
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/csed","root","mrec");
					String q="Insert into student values('"+name+"','"+email+"','"+favpl+"','"+gender+"','"+phno+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(141, 274, 98, 33);
		frame.getContentPane().add(btnNewButton);
	}
}
