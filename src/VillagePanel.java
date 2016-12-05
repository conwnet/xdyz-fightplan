import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import database.Person;
import database.Village;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;

public class VillagePanel extends JPanel {

	private JPanel contentPane, mainPane;
	private JTable table;
	JTree tree_1;
	
	public VillagePanel(JPanel contentPane, JPanel mainPane) {
		this();
		this.contentPane = contentPane;
		this.mainPane = mainPane;

	}
	
	/**
	 * Create the panel.
	 */
	public VillagePanel() {
		
		this.setBounds(100, 100, 800, 800);
		this.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("\u7CBE\u51C6\u8131\u8D2B\u9884\u8131\u8D2B\u5DE5\u4F5C\u8BA1\u5212");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		this.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {300, 0};
		gbl_panel_4.rowHeights = new int[]{694, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("С��Ӫ����");
		TreeModel model1 = new DefaultTreeModel(root1);
		
		DefaultMutableTreeNode personInfoNode = new DefaultMutableTreeNode("ȫ��ƶ�����������ͳ��");
		personInfoNode.setUserObject(new WhichNode(null, "ȫ��ƶ�����������ͳ��"));
		root1.add(personInfoNode);
		DefaultMutableTreeNode poorReasonNode = new DefaultMutableTreeNode("ȫ��ƶ������ƶԭ��ͳ��");
		poorReasonNode.setUserObject(new WhichNode(null, "ȫ��ƶ������ƶԭ��ͳ��"));
		root1.add(poorReasonNode);
		
		for(Village village : Village.getVillages("select * from `village`")) {
			DefaultMutableTreeNode villageNode = new DefaultMutableTreeNode(village.getName());
			DefaultMutableTreeNode personListNode2016 = new DefaultMutableTreeNode("2016 ��Ԥ��ƶ�˿�����");
			personListNode2016.setUserObject(new WhichNode(village, "2016 ��Ԥ��ƶ�˿�����"));
			villageNode.add(personListNode2016);
			DefaultMutableTreeNode personListNode2017 = new DefaultMutableTreeNode("2017 ��Ԥ��ƶ�˿�����");
			personListNode2017.setUserObject(new WhichNode(village, "2017 ��Ԥ��ƶ�˿�����"));
			villageNode.add(personListNode2017);
			DefaultMutableTreeNode personListNode2018 = new DefaultMutableTreeNode("2018 ��Ԥ��ƶ�˿�����");
			personListNode2018.setUserObject(new WhichNode(village, "2018 ��Ԥ��ƶ�˿�����"));
			villageNode.add(personListNode2018);
			root1.add(villageNode);
		}
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_4.add(scrollPane_1, gbc_scrollPane_1);
		
		tree_1 = new JTree();
		tree_1.setModel(model1);
		scrollPane_1.setViewportView(tree_1);
		
		tree_1.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree_1.getLastSelectedPathComponent();
				if(node.isLeaf()) {
					WhichNode which = (WhichNode)node.getUserObject();
					doSelectAction(which);
				}
				
			}
		});
	
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
	
		
	
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		this.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(mainPane);
				contentPane.validate();
				contentPane.repaint();
			}
		});
		panel_3.add(btnNewButton_2);
		
	}
	
	
	public void doSelectAction(WhichNode node) {
		if(node.which.equals("2016 ��Ԥ��ƶ�˿�����")) {
			DefaultTableModel personListModel = new DefaultTableModel(null, new String[] {
					"���", "��������", "�˿�", "���"
			});
			table.setModel(personListModel);
			int i = 1;
			for(Person person : Person.getPersons("select * from `person` where `village`='" + node.village.getName().replace("'", "''") + "' group by `home`")) {
					int personCnt = Person.getPersons("select * from `person` where `home`='" + person.getHome().replace("'", "''") + "'").size();
					String data[] = new String[] { String.valueOf(i), person.getHome(), String.valueOf(personCnt), person.getVillage() };
					personListModel.addRow(data);
					i++;
			}	
		} else if(node.which.equals("ȫ��ƶ�����������ͳ��")) {
			DefaultTableModel baseInfoModel = new DefaultTableModel(null, new String[] {
					"ƶ������", "ƶ���˿�", "һ��ƶ����", "�ͱ���", "һ�㼲��", "��", "�м�", "�й���Ա", "��ä", "Сѧ", "����", "����", "��ר����"
			});
			table.setModel(baseInfoModel);
			for(Village village : Village.getVillages("select * from `village`")) {
				int homes = Person.getPersons("select * from `person` where `village`='" + village.getName().replace("'", "''") + "' group by `home`").size();
				int persons = Person.getPersons("select * from `person` where `village`='" + village.getName().replace("'", "''") + "'").size();
				int normalpks = Person.getPersons("select * from `person` where `poor_property`='һ��ƶ����' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int dibaos = Person.getPersons("select * from `person` where `poor_property`='�ͱ���' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int normaljbs = Person.getPersons("select * from `person` where `health_status`='һ�㼲��' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int bigjbs = Person.getPersons("select * from `person` where `health_status`='��' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int terriblejbs = Person.getPersons("select * from `person` where `health_status`='�м�' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int dangyuans = Person.getPersons("select * from `person` where `political_status`='�й���Ա' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int wenmangs = Person.getPersons("select * from `person` where `culture_status`='��ä' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int xiaoxues = Person.getPersons("select * from `person` where `culture_status`='Сѧ' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int chuzhongs = Person.getPersons("select * from `person` where `culture_status`='����' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int gaozhongs = Person.getPersons("select * from `person` where `culture_status`='����' and `village`='" + village.getName().replace("'", "''") + "'").size();
				int dazhuans = Person.getPersons("select * from `person` where `culture_status`='��ר����' and `village`='" + village.getName().replace("'", "''") + "'").size();
				String data[] = new String[] {village.getName(), String.valueOf(homes), String.valueOf(persons),
						String.valueOf(normalpks), String.valueOf(dibaos), String.valueOf(normaljbs), 
						String.valueOf(bigjbs), String.valueOf(terriblejbs), String.valueOf(dangyuans),
						String.valueOf(wenmangs), String.valueOf(xiaoxues), String.valueOf(chuzhongs),
						String.valueOf(gaozhongs), String.valueOf(dazhuans) };
				baseInfoModel.addRow(data);
			}
		} else if(node.which.equals("ȫ��ƶ������ƶԭ��ͳ��")){
			DefaultTableModel poorReasonModel = new DefaultTableModel(null, new String[] {
					"��", "���", "��ѧ", "ȱ����", "ȱˮ", "ȱ����", "ȱ����", "ȱ�ʽ�", "��ͨ�������", "����չ��������", "����", "���"
			});
			String[] reasons = new String[] {"��", "���", "��ѧ", "ȱ����", "ȱˮ", "ȱ����", "ȱ����", "ȱ�ʽ�", "��ͨ�������", "����չ��������", "����", "���"};
			String[] data = new String[15];
			table.setModel(poorReasonModel);
			for(Village village : Village.getVillages("select * from `village`")) {
				for(int i = 0; i < reasons.length; i++) {
					int cnt = Person.getPersons("select * from `person` where `poor_reason`='" + reasons[i].replace("'", "''") + "' and `village`='" + village.getName().replace("'", "''") + "'").size();
					data[i] = String.valueOf(cnt);
				}
				poorReasonModel.addRow(data);
			}
		}
	}
}

class WhichNode {
	public Village village;
	public String which;
	
	public WhichNode(Village village, String which) {
		this.village = village;
		this.which = which;
	}
	
	@Override
	public String toString() {
		return which;
	}
}



