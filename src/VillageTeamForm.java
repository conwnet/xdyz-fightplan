import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Village;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class VillageTeamForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPanel panel;
	private JButton btnNewButton;
	private int id = VillageListForm.selected;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VillageTeamForm frame = new VillageTeamForm();
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
	public VillageTeamForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u6751\u4E24\u59D4\u73ED\u5B50\u6210\u5458\u57FA\u672C\u60C5\u51B5\u4ECB\u7ECD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		textField.setText(Village.getVillage(id).getTeam());
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("\u4FDD\u5B58");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String team = textField.getText().replaceAll("'", "''");
				Village.execute("update `village` set `team`='" + team + "' where `id`=" + id);
				JOptionPane.showMessageDialog(VillageTeamForm.this, "²Ù×÷³É¹¦");
			}
		});
		panel.add(btnNewButton);
	}

}
