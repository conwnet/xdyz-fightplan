import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import database.Person;
import database.Village;

import javax.swing.JScrollPane;

public class PersonListForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenu menu;
	private JMenuItem menuItem;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonListForm frame = new PersonListForm();
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
	public PersonListForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("\u7BA1\u7406");
		menuBar.add(menu);
		
		menuItem = new JMenuItem("\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PersonForm().setVisible(true);
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u59D3\u540D", "\u4E0E\u6237\u4E3B\u5173\u7CFB", "\u5065\u5EB7\u60C5\u51B5", "\u6587\u5316\u7A0B\u5EA6", "\u8054\u7CFB\u7535\u8BDD", "\u653F\u6CBB\u9762\u8C8C", "\u8D2B\u56F0\u6237\u5C5E\u6027", "\u81F4\u8D2B\u539F\u56E0", "\u5907\u6CE8"
			});
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		for (Person person : Person.getPersons("select * from `person`")) {
			String[] row = {person.getName(), person.getRelation_with_host(), person.getHealth_status(), person.getCulture_status(), person.getTel_number(), person.getPolitical_status(), person.getPoor_property(), person.getPoor_reason(), person.getRemark()};
			model.addRow(row);
		}
		
		
	}

}
