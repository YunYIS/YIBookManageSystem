package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Database.BOOKDAO;
import model.User;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class UserRegister extends JPanel {
	private JTextField userNameTextField;
	private JTextField passwordTextField;

	/**
	 * Create the panel.
	 */
	public UserRegister() {
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
				
				try {
					//�ж��û����Ƿ�Ϊ�ջ򡰡�
					if(userNameTextField.getText() == null || userNameTextField.getText().equals("")){
						JOptionPane.showMessageDialog(null, "�û���Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE); 
					}else{
						//�ж������Ƿ�Ϊ�ջ򡰡�
						if(passwordTextField.getText() == null || passwordTextField.getText().equals("")){
							JOptionPane.showMessageDialog(null, "����Ϊ��", "��ʾ", JOptionPane.ERROR_MESSAGE); 
						}
						else{
							users = bookdao.queryUserAll();
							for (int i = 0; i < users.size(); i++){
								if(userNameTextField.getText().equals(users.get(i).getUserName())){
									isUserExist = true;
									break;
								}
							}
							if (!isUserExist){
								MainFrame.mainPanel.removeAll();
								MainFrame.mainPanel.add(new UserPanel());
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
				
			}
		});
		backButton.setBounds(278, 218, 102, 33);
		add(backButton);

	}
}
