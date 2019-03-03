package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Database.BOOKAction;
import Database.BOOKDAO;
import model.User;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("serial")
public class UserRegister extends JPanel {
	private JTextField userNameTextField;
	private JTextField passwordTextField;

	/**
	 * Create the panel.
	 */
	public UserRegister(JPanel userLoginPanel) {
		setLayout(null);
		
		JLabel userNameLabel = new JLabel("�û�����");
		userNameLabel.setFont(new Font("����", Font.PLAIN, 14));
		userNameLabel.setBounds(101, 62, 56, 33);
		add(userNameLabel);
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		userNameTextField.setBounds(182, 65, 198, 27);
		add(userNameTextField);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(182, 130, 198, 27);
		add(passwordTextField);
		
		JLabel passwordLable = new JLabel("���룺");
		passwordLable.setFont(new Font("����", Font.PLAIN, 14));
		passwordLable.setBounds(114, 124, 43, 33);
		add(passwordLable);
		
		JButton registerButton = new JButton("ע��");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				BOOKDAO bookdao = new BOOKDAO();
				List<User> users = new ArrayList<>();
				boolean isUserExist = false;
				String userName = userNameTextField.getText();
				String password = passwordTextField.getText();
				try {
					//�ж��û����Ƿ�Ϊ�ջ򡰡�
					if(userName == null || userName.equals("")){
						JOptionPane.showMessageDialog(null, "�û���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE); 
					}else{
						//�ж������Ƿ�Ϊ�ջ򡰡�
						if(password == null || password.equals("")){
							JOptionPane.showMessageDialog(null, "����Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE); 
						}
						else{
							users = bookdao.queryUserAll();
							for (int i = 0; i < users.size(); i++){
								if(userName.equals(users.get(i).getUserName())){
									isUserExist = true;
									break;
								}
							}
							if (!isUserExist){
								User user = new User(userName, password, LocalDate.now().toString());
								new BOOKAction().addUser(user);
								MainFrame.nowUser = user;
								JOptionPane.showMessageDialog(null, "ע��ɹ������ȷ����½", "�ɹ�", JOptionPane.ERROR_MESSAGE); 
								MainFrame.mainPanel.removeAll();
								MainFrame.mainPanel.add(new UserPanel(userLoginPanel));
								MainFrame.mainPanel.validate();
								MainFrame.mainJFrame.repaint();
							}else{
								JOptionPane.showMessageDialog(null, "�û����Ѵ���", "����", JOptionPane.ERROR_MESSAGE); 
							}
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		registerButton.setBounds(101, 218, 102, 33);
		add(registerButton);
		
		JButton backButton = new JButton("����");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainFrame.mainPanel.removeAll();
				MainFrame.mainPanel.add(userLoginPanel);
				MainFrame.mainPanel.validate();
				MainFrame.mainJFrame.repaint();
			}
		});
		backButton.setBounds(278, 218, 102, 33);
		add(backButton);

	}
}
