package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import cons.Constans;
import util.Listeners;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 * 主窗体类
 * @author 10864189 coax
 *
 */
public class MianView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 面板
	 */
	private JPanel contentPane;
	
	/**
	 * 存储路径
	 */
	public JTextField textFilePath;
	
	/**
	 * 搜索关键字
	 */
	public JTextField textSearchText;
	
	public JLabel lbeSearch;
	public JLabel lbeSearchText;
	
	/**
	 * 下拉选择爬取地址
	 */
	public JComboBox<String> boxSelectUrl;
	
	/**
	 * 下拉选择下载数量
	 */
	JComboBox<String> comboBox;
	
	/**
	 * 是否搜索单选框 否
	 */
	public JRadioButton rdoNo;
	
	/**
	 * 是否搜索单选框 是
	 */
	public JRadioButton rdoYes;
	 

	/**
	 * Create the frame.
	 */
	public MianView() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 390);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbeUrl = new JLabel("\u7F51\u5740\uFF1A");
		lbeUrl.setBounds(50, 50, 50, 20);
		contentPane.add(lbeUrl);
		
		JLabel lbeFilePath = new JLabel("\u5730\u5740\uFF1A");
		lbeFilePath.setBounds(50, 90, 50, 20);
		contentPane.add(lbeFilePath);
		
		textFilePath = new JTextField();
		textFilePath.setText("E:\\SysMediaFile\\Desktop\\temp\\downTest");
		textFilePath.setColumns(10);
		textFilePath.setBounds(120, 90, 408, 21);
		contentPane.add(textFilePath);
		
		JButton btnDown = new JButton("\u4E0B\u8F7D");
		btnDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				try {
					Listeners.downPic1(Constans.getMianView());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDown.setBounds(123, 257, 93, 23);
		contentPane.add(btnDown);
		
		JButton btnParse = new JButton("\u89E3\u6790");
		btnParse.setBounds(393, 257, 93, 23);
		contentPane.add(btnParse);
		
		boxSelectUrl = new JComboBox<String>();
		if (boxSelectUrl.getItemCount() == 0) {
			Listeners.loadUrl(boxSelectUrl);
		}
		
		// boxSelectUrl.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		boxSelectUrl.setBounds(120, 50, 408, 21);
		contentPane.add(boxSelectUrl);
		
		lbeSearchText = new JLabel("\u641C\u7D22\uFF1A");
		lbeSearchText.setBounds(50, 210, 50, 20);
		lbeSearchText.setVisible(false);
		contentPane.add(lbeSearchText);
		
		textSearchText = new JTextField();
		textSearchText.setColumns(10);
		textSearchText.setBounds(120, 210, 408, 21);
		textSearchText.setVisible(false);
		contentPane.add(textSearchText);
		
		lbeSearch = new JLabel("\u641C\u7D22\uFF1A");
		lbeSearch.setBounds(50, 130, 50, 20);
		contentPane.add(lbeSearch);
		
		rdoNo = new JRadioButton("\u4E0D\u7528");
		rdoNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listeners.showOrHideSearch(rdoNo, lbeSearchText, textSearchText);
			}
		});
		rdoNo.setMnemonic('0');
		rdoNo.setSelected(true);
		rdoNo.setBounds(120, 130, 77, 23);
		contentPane.add(rdoNo);
		
		rdoYes = new JRadioButton("\u662F\u7684");
		rdoYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listeners.showOrHideSearch(rdoNo, lbeSearchText, textSearchText);
			}
		});
		rdoYes.setMnemonic('0');
		rdoYes.setBounds(230, 130, 121, 23);
		contentPane.add(rdoYes);
		
		//设置buttom组  只能单选
		ButtonGroup bgRdoSearch = new ButtonGroup();
		bgRdoSearch.add(rdoYes);
		bgRdoSearch.add(rdoNo);
		
		JLabel label = new JLabel("\u6570\u91CF\uFF1A");
		label.setBounds(50, 170, 50, 20);
		contentPane.add(label);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(Constans.downNum));
		comboBox.setBounds(120, 170, 408, 21);
		contentPane.add(comboBox);
	}
}
