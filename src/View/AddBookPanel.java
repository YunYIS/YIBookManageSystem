package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 
 * @author YunYIS
 */
@SuppressWarnings("serial")
public class AddBookPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public AddBookPanel() {
		setLayout(null);
		
		JLabel lbll = new JLabel("\u6DFB\u52A0\u56FE\u4E66");
		lbll.setFont(new Font("宋体", Font.PLAIN, 15));
		lbll.setBounds(102, 60, 101, 37);
		add(lbll);
		
		JLabel label = new JLabel("\u4E66\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(98, 107, 49, 26);
		add(label);
		
		JLabel label_1 = new JLabel("\u4F5C\u8005\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(98, 143, 49, 26);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(69, 179, 78, 26);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u9875\u6570\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(98, 215, 49, 26);
		add(label_3);
		
		textField = new JTextField();
		textField.setBounds(157, 107, 229, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 146, 229, 26);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 182, 229, 26);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 218, 229, 26);
		add(textField_3);
		
		JLabel label_4 = new JLabel("\u4EF7\u683C\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(98, 251, 49, 26);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(157, 251, 229, 26);
		add(textField_4);
		
		JLabel label_5 = new JLabel("\u56FD\u5BB6\uFF1A");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(98, 287, 49, 26);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(157, 290, 229, 26);
		add(textField_5);
		
		JLabel label_6 = new JLabel("\u7B80\u4ECB\uFF1A");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(98, 326, 49, 26);
		add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(157, 326, 229, 26);
		add(textField_6);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setBounds(98, 400, 114, 37);
		add(btnNewButton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.setBounds(272, 400, 114, 37);
		add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(443, 400, 114, 37);
		add(button_1);

	}

}
