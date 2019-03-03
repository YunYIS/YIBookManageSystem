package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EmptyBorder;

import Database.DBUtil;
import model.User;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * @author YunYIS
 */
@SuppressWarnings("serial")
public class UserPanel extends JPanel {	
	/**
	 * Create the panel.
	 */
	public UserPanel(JPanel userLoginPanel) {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
		JLabel welcomeLabel = new JLabel("欢迎用户 " + MainFrame.nowUser.getUserName());
		welcomeLabel.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 16));
		welcomeLabel.setBounds(126, 56, 115, 30);
		add(welcomeLabel);
		
		JButton userInfoButton = new JButton("个人信息");
		userInfoButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, 
						"用户名："+MainFrame.nowUser.getUserName()+"; 注册日期："+MainFrame.nowUser.getRegisterDate(),
						"个人信息", JOptionPane.ERROR_MESSAGE); 
			}
		});
		userInfoButton.setFont(new Font("宋体", Font.PLAIN, 15));
		userInfoButton.setBounds(126, 315, 115, 32);
		add(userInfoButton);
		
		JButton borrowButton = new JButton("借阅情况");
		borrowButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		borrowButton.setFont(new Font("宋体", Font.PLAIN, 15));
		borrowButton.setBounds(269, 315, 115, 32);
		add(borrowButton);
		
		JButton logoutButton = new JButton("注销");
		logoutButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.mainPanel.removeAll();
				MainFrame.mainPanel.add(userLoginPanel);
				MainFrame.mainPanel.validate();
				MainFrame.mainJFrame.repaint();
			}
		});
		logoutButton.setFont(new Font("宋体", Font.PLAIN, 15));
		logoutButton.setBounds(412, 315, 115, 32);
		add(logoutButton);
		
		JButton exitButton = new JButton("退出");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DBUtil.closeBOOKConnection();
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("宋体", Font.PLAIN, 15));
		exitButton.setBounds(553, 315, 115, 32);
		add(exitButton);
		
		SearchPanel panel = new SearchPanel();
		panel.setBorder(null);
		panel.setBounds(126, 100, 504, 75);
		add(panel);

	}
}
