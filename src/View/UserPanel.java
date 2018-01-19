package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
/**
 * 
 * @author 张云天
 *
 */
public class UserPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
		JLabel welcomeLabel = new JLabel("欢迎用户 zyt");
		welcomeLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		welcomeLabel.setBounds(126, 56, 115, 30);
		add(welcomeLabel);
		
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
		
		SearchPanel panel = new SearchPanel();
		panel.setBorder(null);
		panel.setBounds(126, 100, 504, 75);
		add(panel);

	}
}
