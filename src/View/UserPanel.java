package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
/**
 * 
 * @author 张云天
 *
 */
public class UserPanel extends JPanel {
	private JTextField searchTextField;

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setLayout(null);
		
		JLabel welcomeLabel = new JLabel("欢迎用户 zyt");
		welcomeLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		welcomeLabel.setBounds(126, 56, 115, 30);
		add(welcomeLabel);
		
		searchTextField = new JTextField();
		searchTextField.setBounds(126, 96, 349, 31);
		add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("搜 索 图 书");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(505, 96, 123, 31);
		add(searchButton);
		
		JLabel searchConditionLabel = new JLabel("搜索条件：");
		searchConditionLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		searchConditionLabel.setBounds(126, 147, 65, 20);
		add(searchConditionLabel);
		
		JRadioButton bookNameRadioButton = new JRadioButton("书名");
		bookNameRadioButton.setBounds(210, 147, 49, 23);
		add(bookNameRadioButton);
		
		JRadioButton authorRadioButton = new JRadioButton("作者");
		authorRadioButton.setBounds(269, 147, 49, 23);
		add(authorRadioButton);
		
		JRadioButton summaryRadioButton = new JRadioButton("简介");
		summaryRadioButton.setBounds(328, 147, 49, 23);
		add(summaryRadioButton);
		
		JRadioButton allRadioButton = new JRadioButton("全部字段");
		allRadioButton.setBounds(387, 146, 73, 23);
		add(allRadioButton);
		
		JButton userInfoButton = new JButton("个人信息");
		userInfoButton.setFont(new Font("宋体", Font.PLAIN, 15));
		userInfoButton.setBounds(126, 315, 115, 32);
		add(userInfoButton);
		
		JButton borrowButton = new JButton("借阅情况");
		borrowButton.setFont(new Font("宋体", Font.PLAIN, 15));
		borrowButton.setBounds(269, 315, 115, 32);
		add(borrowButton);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 15));
		logoutButton.setBounds(412, 315, 115, 32);
		add(logoutButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.setFont(new Font("宋体", Font.PLAIN, 15));
		exitButton.setBounds(553, 315, 115, 32);
		add(exitButton);

	}
}
