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

/**
 * Ö÷´°ÌåÀà
 * @author 10864189 coax
 *
 */
public class MianView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textUrl;
	public JTextField textFilePath;
	
	 

	/**
	 * Create the frame.
	 */
	public MianView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 390);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new LineBorder(Color.GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbeUrl = new JLabel("\u7F51\u5740\uFF1A");
		lbeUrl.setBounds(47, 45, 50, 20);
		contentPane.add(lbeUrl);
		
		textUrl = new JTextField();
		textUrl.setText("http://www.tooopen.com/view/1587424.html");
		lbeUrl.setLabelFor(textUrl);
		textUrl.setBounds(107, 45, 408, 21);
		contentPane.add(textUrl);
		textUrl.setColumns(10);
		
		JLabel lbeFilePath = new JLabel("\u5730\u5740\uFF1A");
		lbeFilePath.setBounds(47, 110, 50, 20);
		contentPane.add(lbeFilePath);
		
		textFilePath = new JTextField();
		textFilePath.setText("E:\\SysMediaFile\\Desktop\\temp\\downTest");
		textFilePath.setColumns(10);
		textFilePath.setBounds(107, 110, 408, 21);
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
		btnDown.setBounds(107, 198, 93, 23);
		contentPane.add(btnDown);
		
		JButton btnParse = new JButton("\u89E3\u6790");
		btnParse.setBounds(286, 198, 93, 23);
		contentPane.add(btnParse);
	}
}
