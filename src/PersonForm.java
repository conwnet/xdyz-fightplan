import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.Person;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PersonForm extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JPanel panel_1;
	private JLabel label;
	private JTextField textField_1;
	private JPanel panel_2;
	private JLabel label_1;
	private JTextField textField_2;
	private JPanel panel_3;
	private JLabel label_2;
	private JTextField textField_3;
	private JPanel panel_4;
	private JLabel label_3;
	private JTextField textField_4;
	private JPanel panel_5;
	private JLabel label_4;
	private JTextField textField_5;
	private JPanel panel_6;
	private JLabel label_5;
	private JTextField textField_6;
	private JPanel panel_7;
	private JLabel label_6;
	private JTextField textField_7;
	private JPanel panel_8;
	private JLabel label_7;
	private JTextField textField_8;
	private JPanel panel_9;
	private JLabel label_8;
	private JTextField textField_9;
	private JPanel panel_10;
	private JLabel label_9;
	private JTextField textField_10;
	private JButton btnNewButton;
	private JPanel panel_11;
	private JLabel label_10;
	private JTextField textField_11;
	private JPanel panel_12;
	private JLabel label_11;
	private JTextField textField_12;
	private JPanel panel_13;
	private JLabel label_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonForm frame = new PersonForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(15, 0, 0, 0));
		
		panel = new JPanel();
		contentPane.add(panel);
		
		lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		label = new JLabel("\u6240\u5728\u4E61\uFF1A");
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setText("\u5C0F\u5FB7\u8425\u5B50\u4E61");
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		label_1 = new JLabel("\u6240\u5728\u6751\uFF1A");
		panel_2.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		label_2 = new JLabel("\u6240\u5728\u6237\uFF1A");
		panel_3.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_3.add(textField_3);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		label_3 = new JLabel("\u4E0E\u6237\u4E3B\u5173\u7CFB\uFF1A");
		panel_4.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel_4.add(textField_4);
		
		panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		label_4 = new JLabel("\u5065\u5EB7\u72B6\u51B5\uFF1A");
		panel_5.add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_5.add(textField_5);
		
		panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		label_5 = new JLabel("\u6587\u5316\u7A0B\u5EA6\uFF1A");
		panel_6.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_6.add(textField_6);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		label_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		panel_7.add(label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_7.add(textField_7);
		
		panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		label_7 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
		panel_8.add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_8.add(textField_8);
		
		panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		label_8 = new JLabel("\u8D2B\u56F0\u6237\u5C5E\u6027\uFF1A");
		panel_9.add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_9.add(textField_9);
		
		panel_10 = new JPanel();
		contentPane.add(panel_10);
		
		label_9 = new JLabel("\u81F4\u8D2B\u539F\u56E0\uFF1A");
		panel_10.add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_10.add(textField_10);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Person person = new Person();
				person.setName(textField.getText());
				person.setTown(textField_1.getText());
				person.setVillage(textField_2.getText());
				person.setHome(textField_3.getText());
				person.setRelation_with_host(textField_4.getText());
				person.setHealth_status(textField_5.getText());
				person.setCulture_status(textField_6.getText()); 
				person.setTel_number(textField_7.getText());
				person.setPolitical_status(textField_8.getText());
				person.setPoor_property(textField_9.getText());
				person.setPoor_reason(textField_10.getText());
				person.setRemark(textField_11.getText());
				person.setLabor_export(textField_12.getText());
				person.setHouse_reform(textField_13.getText());
				//person.setIcon();
				boolean status = person.add();
				System.out.println(status);
				JOptionPane.showMessageDialog(PersonForm.this, "²Ù×÷³É¹¦");
				PersonForm.this.setVisible(false);
			}
			
		});
		
		panel_11 = new JPanel();
		contentPane.add(panel_11);
		
		label_10 = new JLabel("\u5907\u6CE8\uFF1A");
		panel_11.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_11.add(textField_11);
		
		panel_12 = new JPanel();
		contentPane.add(panel_12);
		
		label_11 = new JLabel("\u52B3\u52A1\u8F93\u51FA\uFF1A");
		panel_12.add(label_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		panel_12.add(textField_12);
		
		panel_13 = new JPanel();
		contentPane.add(panel_13);
		
		label_12 = new JLabel("\u5371\u623F\u6539\u9020\uFF1A");
		panel_13.add(label_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		panel_13.add(textField_13);
		contentPane.add(btnNewButton);
	}
	

}
