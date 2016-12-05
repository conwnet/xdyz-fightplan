import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import database.Database;
import database.Person;
import database.Village;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private PersonPanel personPane;
	private JPanel villagePane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Database.init();

		InitGlobalFont(new Font("свт╡", Font.PLAIN, 15));
        try {  
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();  
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;  

            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();  
            UIManager.put("RootPane.setupButtonVisible", false);  
            //BeautyEyeLNFHelper.translucencyAtFrameInactive = false;  
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        } catch (Exception e) {  
            System.err.println("set skin fail!");  
        } 

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
    private static void InitGlobalFont(Font font) {  
        FontUIResource fontRes = new FontUIResource(font);  
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {  
            Object key = keys.nextElement();  
            Object value = UIManager.get(key);  
            if (value instanceof FontUIResource) {  
                UIManager.put(key, fontRes);  
            }  
        }  
    }  

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel mainPane = new JPanel();
		contentPane.add(mainPane, BorderLayout.CENTER);
		mainPane.setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("\u5C0F\u5FB7\u8425\u5B50\u4E61\u7CBE\u51C6\u8131\u8D2B\u653B\u575A\u4F5C\u6218\u8BA1\u5212");
		label.setFont(new Font("свт╡", Font.PLAIN, 48));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		mainPane.add(label, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		mainPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u8D2B\u56F0\u6237\u57FA\u672C\u4FE1\u606F");
		btnNewButton.setFont(new Font("свт╡", Font.PLAIN, 24));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(personPane);
				contentPane.validate();
				contentPane.repaint();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JButton button = new JButton("\u8131\u8D2B\u5DE5\u4F5C\u8BA1\u5212");
		button.setFont(new Font("свт╡", Font.PLAIN, 24));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.removeAll();
				contentPane.add(villagePane);
				contentPane.validate();
				contentPane.repaint();
			}
		});
		panel.add(button);
	
		
		
/************************************************************************************/
		personPane = new PersonPanel(contentPane, mainPane);
		contentPane.add(personPane, BorderLayout.CENTER);
		
/************************************************************************************/
		
		villagePane = new VillagePanel(contentPane, mainPane);
		contentPane.add(villagePane, BorderLayout.CENTER);
		
		
/************************************************************************************/	
		
		///**
		contentPane.removeAll();
		contentPane.add(mainPane);
		contentPane.validate();
		contentPane.repaint();
		//*/
		
	}
	
	
    
    
    public static void showPersonInfoByName(Person person) {
    	
    }

}
