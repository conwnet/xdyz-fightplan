import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PoorReason extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PoorReason frame = new PoorReason();
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
	public PoorReason() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u5168\u4E61\u5EFA\u6863\u7ACB\u5361\u8D2B\u56F0\u6237\u81F4\u8D2B\u539F\u56E0\u7EDF\u8BA1");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] {
				"���", "��", "���", "��ѧ", "ȱ����", "ȱˮ", "ȱ����", "ȱ����", "ȱ�ʽ�", "��ͨ�������", "����չ��������", "����", "���"
		});
		table.setModel(model);
		scrollPane.setViewportView(table);
	}

}
