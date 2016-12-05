import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

import database.Person;
import database.Village;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class PersonPanel extends JPanel {
	
	private JTextField name;
	private JTextField relation_with_host;
	private JTextField health_status;
	private JTextField culture_status;
	private JTextField tel_number;
	private JTextField political_status;
	private JTextField poor_property;
	private JTextField poor_reason;
	private JTextField remark;
	
	String iconB64 = "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";
	
	JPanel contentPane;
	JPanel mainPane;
	Person person = null;
	private JTextField town;
	private JTextField village;
	private JTextField home;
	
	public PersonPanel(JPanel contentPane, JPanel mainPane) {
		this();
		this.contentPane = contentPane;
		this.mainPane = mainPane;
	}
	
	public PersonPanel() {
		
		this.setBounds(100, 100, 800, 800);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("小德营子乡");
		TreeModel model = new DefaultTreeModel(root);
		
		for(Village village : Village.getVillages("select * from `village`")) {
			DefaultMutableTreeNode villageNode = new DefaultMutableTreeNode(village.getName());
			root.add(villageNode);
			for(Person person : Person.getPersons("select * from `person` where `village`='" + village.getName().replace("'", "''") + "'")) {
				DefaultMutableTreeNode personNode = new DefaultMutableTreeNode(person.getName());
				personNode.setUserObject(person);
				villageNode.add(personNode);
			}
		}
		
		this.setLayout(new BorderLayout(0, 0));
		
		JLabel label_1 = new JLabel("\u5C0F\u5FB7\u8425\u5B50\u4E61\u8D2B\u56F0\u6237\u57FA\u672C\u4FE1\u606F");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(label_1, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		this.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {200, 0};
		gbl_panel_1.rowHeights = new int[]{694, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		
		JTree tree = new JTree();
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				if(node.isLeaf()) {
					person = (Person)node.getUserObject();
					showPersonInfoByName();
					System.out.println(person.getVillage());
				}
				
			}
		});
		

		tree.setModel(model);
		scrollPane.setViewportView(tree);
		
		JPanel panel_2 = new JPanel();
		this.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u83DC\u5355");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(mainPane);
				contentPane.validate();
				contentPane.repaint();
			}
		});
		panel_2.add(btnNewButton_1);
		
		try {
			Icon icon;
			Image image = new ImageIcon(decodeBase64(iconB64)).getImage();
			image = image.getScaledInstance(80, 100, Image.SCALE_FAST);
			icon = new ImageIcon(image);
			
			JPanel panel_5 = new JPanel();
			GridBagConstraints gbc_panel_5 = new GridBagConstraints();
			gbc_panel_5.insets = new Insets(0, 0, 5, 0);
			gbc_panel_5.fill = GridBagConstraints.BOTH;
			gbc_panel_5.gridx = 1;
			gbc_panel_5.gridy = 0;
			panel_1.add(panel_5, gbc_panel_5);
			panel_5.setLayout(null);
			
			JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
			label_2.setBounds(41, 34, 93, 15);
			panel_5.add(label_2);
			
			name = new JTextField();
			name.setBounds(144, 25, 87, 34);
			panel_5.add(name);
			name.setColumns(10);
			
			relation_with_host = new JTextField();
			relation_with_host.setColumns(10);
			relation_with_host.setBounds(120, 75, 66, 21);
			panel_5.add(relation_with_host);
			
			JLabel label_3 = new JLabel("\u4E0E\u6237\u4E3B\u5173\u7CFB\uFF1A");
			label_3.setBounds(41, 78, 79, 15);
			panel_5.add(label_3);
			
			health_status = new JTextField();
			health_status.setColumns(10);
			health_status.setBounds(120, 117, 66, 21);
			panel_5.add(health_status);
			
			JLabel label_4 = new JLabel("\u5065\u5EB7\u60C5\u51B5\uFF1A");
			label_4.setBounds(41, 120, 66, 15);
			panel_5.add(label_4);
			
			culture_status = new JTextField();
			culture_status.setColumns(10);
			culture_status.setBounds(120, 163, 66, 21);
			panel_5.add(culture_status);
			
			JLabel label_5 = new JLabel("\u6587\u5316\u7A0B\u5EA6\uFF1A");
			label_5.setBounds(41, 166, 66, 15);
			panel_5.add(label_5);
			
			JLabel label_6 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
			label_6.setBounds(227, 226, 66, 15);
			panel_5.add(label_6);
			
			tel_number = new JTextField();
			tel_number.setColumns(10);
			tel_number.setBounds(306, 223, 66, 21);
			panel_5.add(tel_number);
			
			JLabel label_7 = new JLabel("\u653F\u6CBB\u9762\u8C8C\uFF1A");
			label_7.setBounds(227, 277, 66, 15);
			panel_5.add(label_7);
			
			political_status = new JTextField();
			political_status.setColumns(10);
			political_status.setBounds(306, 274, 66, 21);
			panel_5.add(political_status);
			
			JLabel label_8 = new JLabel("\u8D2B\u56F0\u6237\u5C5E\u6027\uFF1A");
			label_8.setBounds(227, 329, 79, 15);
			panel_5.add(label_8);
			
			poor_property = new JTextField();
			poor_property.setColumns(10);
			poor_property.setBounds(306, 326, 66, 21);
			panel_5.add(poor_property);
			
			JLabel label_9 = new JLabel("\u81F4\u8D2B\u539F\u56E0\uFF1A");
			label_9.setBounds(41, 375, 66, 15);
			panel_5.add(label_9);
			
			poor_reason = new JTextField();
			poor_reason.setColumns(10);
			poor_reason.setBounds(120, 372, 66, 21);
			panel_5.add(poor_reason);
			
			JLabel label_10 = new JLabel("\u5907\u6CE8\uFF1A");
			label_10.setBounds(227, 378, 66, 15);
			panel_5.add(label_10);
			
			remark = new JTextField();
			remark.setColumns(10);
			remark.setBounds(306, 375, 66, 21);
			panel_5.add(remark);
			
			JLabel iconLabel = new JLabel("");
			iconLabel.setBounds(266, 51, 80, 100);
			panel_5.add(iconLabel);
			iconLabel.setIcon(icon);
			
			JButton button = new JButton("\u4E0A\u4F20");
			button.setBounds(266, 162, 80, 23);
			panel_5.add(button);
			
			JButton button_1 = new JButton("\u4FDD\u5B58");
			button_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//Person person = new Person();
					person.setName(name.getText());
					person.setTown(town.getText());
					person.setVillage(village.getText());
					person.setHome(home.getText());
					person.setRelation_with_host(relation_with_host.getText());
					person.setHealth_status(health_status.getText());
					person.setCulture_status(culture_status.getText()); 
					person.setTel_number(tel_number.getText());
					person.setPolitical_status(political_status.getText());
					person.setPoor_property(poor_property.getText());
					person.setPoor_reason(poor_reason.getText());
					person.setRemark(remark.getText());
					//person.setLabor_export(labor_export.getText());
					//person.setHouse_reform(house_reform.getText());
					//person.setIcon();
					boolean status = person.save();
					System.out.println(status);
					JOptionPane.showMessageDialog(null, "操作成功");
					
				}
			});
			button_1.setBounds(158, 428, 93, 23);
			panel_5.add(button_1);
			
			JLabel label = new JLabel("\u6240\u5728\u4E61\uFF1A");
			label.setBounds(41, 226, 54, 15);
			panel_5.add(label);
			
			town = new JTextField();
			town.setBounds(120, 223, 66, 21);
			panel_5.add(town);
			town.setColumns(10);
			
			JLabel label_11 = new JLabel("\u6240\u5728\u6751\uFF1A");
			label_11.setBounds(41, 280, 54, 15);
			panel_5.add(label_11);
			
			JLabel label_12 = new JLabel("\u6240\u5728\u6237\uFF1A");
			label_12.setBounds(41, 329, 54, 15);
			panel_5.add(label_12);
			
			village = new JTextField();
			village.setBounds(120, 274, 66, 21);
			panel_5.add(village);
			village.setColumns(10);
			
			home = new JTextField();
			home.setBounds(120, 326, 66, 21);
			panel_5.add(home);
			home.setColumns(10);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static String encodeBase64(byte[]input) throws Exception {  
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");  
        Method mainMethod= clazz.getMethod("encode", byte[].class);  
        mainMethod.setAccessible(true);  
         Object retObj=mainMethod.invoke(null, new Object[]{input});  
         return (String)retObj;  
    }  

    public static byte[] decodeBase64(String input) throws Exception {  
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");  
        Method mainMethod= clazz.getMethod("decode", String.class);  
        mainMethod.setAccessible(true);  
         Object retObj=mainMethod.invoke(null, input);  
         return (byte[])retObj;  
    }
	
	
	public void showPersonInfoByName() {
    	name.setText(person.getName());
    	town.setText(person.getTown());
    	village.setText(person.getVillage());
    	home.setText(person.getHome());
    	relation_with_host.setText(person.getRelation_with_host());
    	health_status.setText(person.getHealth_status());
    	culture_status.setText(person.getCulture_status());
    	tel_number.setText(person.getTel_number());
    	political_status.setText(person.getPolitical_status());
    	poor_property.setText(person.getPoor_property());
    	poor_reason.setText(person.getPoor_reason());
    	remark.setText(person.getRemark());
    }
}
