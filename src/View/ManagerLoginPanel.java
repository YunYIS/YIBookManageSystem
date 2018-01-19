package View;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Database.BOOKDAO;
import model.Manager;
import model.User;
/**
 * 
 * @author 张云天
 *
 */
@SuppressWarnings("serial")
public class ManagerLoginPanel extends JPanel {
	
	private JLabel managerLabel;
	private JTextField managerTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton loginButton;
	private JButton backButton;

	public ManagerLoginPanel(JPanel contentPanel) {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			//更改界面风格
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel TitleLabel = new JLabel("管 理 员 登 陆");
		TitleLabel.setFont(new Font("宋体", Font.PLAIN, 26));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(238, 75, 294, 57);
		add(TitleLabel);
		
		managerLabel = new JLabel("账户：");
		managerLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		managerLabel.setBounds(238, 193, 43, 33);
		add(managerLabel);
		
		managerTextField = new JTextField();
		managerTextField.setColumns(10);
		managerTextField.setBounds(306, 196, 198, 27);
		add(managerTextField);
		
		passwordLabel = new JLabel("密码：");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		passwordLabel.setBounds(238, 255, 43, 33);
		add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(306, 261, 198, 27);
		add(passwordTextField);
		
		loginButton = new JButton("登陆");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				BOOKDAO bookdao = new BOOKDAO();
				List<Manager> managers = new ArrayList<>();
				boolean isManagerTrue = false;
				try {
					managers = bookdao.queryManagerAll();
					for (int i = 0; i < managers.size(); i++){
						if(managerTextField.getText().equals(managers.get(i).getAdminName())
								&& passwordTextField.getText().equals(managers.get(i).getPassword())){
							isManagerTrue = true;
							break;
						}
					}
					if (isManagerTrue){
						MainFrame.mainPanel.removeAll();
						MainFrame.mainPanel.add(new ManagerPanel());
						MainFrame.mainPanel.validate();
						MainFrame.mainJFrame.repaint();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		loginButton.setBounds(270, 370, 93, 33);
		add(loginButton);
		
		backButton = new JButton("返回");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.mainPanel.removeAll();
				MainFrame.mainPanel.add(contentPanel);
				MainFrame.mainPanel.validate();
				MainFrame.mainJFrame.repaint();
			}
		});
		backButton.setBounds(420, 370, 93, 33);
		add(backButton);
	}

}
