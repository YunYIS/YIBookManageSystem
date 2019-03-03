package View;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Database.BOOKDAO;
import model.*;
/**
 * �û���½����
 * @author YunYIS
 */
@SuppressWarnings("serial")
public class UserLoginPanel extends JPanel {

	private JLabel userNameLabel;
	private JTextField userNameTextField;
	private JLabel passwordLabel;
	private JTextField passwordTextField;
	private JButton loginButton;
	private JButton backButton;
	
	public UserLoginPanel(JPanel contentPanel) {
		
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			//���Ľ�����
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel TitleLabel = new JLabel("�� �� �� ½");
		TitleLabel.setFont(new Font("����", Font.PLAIN, 26));
		TitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TitleLabel.setBounds(238, 75, 294, 57);
		add(TitleLabel);
		
		userNameLabel = new JLabel("�û�����");
		userNameLabel.setFont(new Font("����", Font.PLAIN, 14));
		userNameLabel.setBounds(225, 193, 56, 33);
		add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		userNameTextField.setBounds(306, 196, 198, 27);
		add(userNameTextField);
		
		passwordLabel = new JLabel("���룺");
		passwordLabel.setFont(new Font("����", Font.PLAIN, 14));
		passwordLabel.setBounds(238, 255, 43, 33);
		add(passwordLabel);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(306, 261, 198, 27);
		add(passwordTextField);
		
		loginButton = new JButton("��½");
		loginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BOOKDAO bookdao = new BOOKDAO();
				List<User> users = new ArrayList<>();
				User user = null;
				boolean isUserTrue = false;
				try {
					users = bookdao.queryUserAll();
					for (int i = 0; i < users.size(); i++){
						if(userNameTextField.getText().equals(users.get(i).getUserName())
								&& passwordTextField.getText().equals(users.get(i).getPassword())){
							isUserTrue = true;
							user = users.get(i);
							break;
						}
					}
					if (isUserTrue){
						MainFrame.nowUser = user;
						MainFrame.mainPanel.removeAll();
						MainFrame.mainPanel.add(new UserPanel(UserLoginPanel.this));
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
		
		backButton = new JButton("����");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.mainPanel.removeAll();
				MainFrame.mainPanel.add(contentPanel);
				MainFrame.mainPanel.validate();
				MainFrame.mainJFrame.repaint();
			}
		});
		backButton.setBounds(559, 370, 93, 33);
		add(backButton);
		
		JButton registerButton = new JButton("ע��");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.mainPanel.removeAll();
				MainFrame.mainPanel.add(new UserRegister(UserLoginPanel.this));
				MainFrame.mainPanel.validate();
				MainFrame.mainJFrame.repaint();
			}
		});
		registerButton.setBounds(422, 370, 93, 33);
		add(registerButton);

	}
}
