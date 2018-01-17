package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {

	private JFrame frame;
	private JPanel panel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.initialize();
					mainFrame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * ��ʼ��JFrame
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/book.png"));
		setPanelView();
	}
	
	/**
	 * ���������棬�������л��ɲ�ͬ��JPanel��ɣ���MainFrame.panelָ������JPanelʵ��ʱ����ʾ��ͬ�Ľ��棩
	 */
	public void setPanelView(){
		panel = (JPanel) frame.getContentPane();
		panel.setLayout(null);
		
		/**
		 * ����ͼƬbook.png
		 */
		JLabel bookIconLabel = new JLabel("");	
		//����ͼƬ��С
		Image bookImage = Toolkit.getDefaultToolkit().getImage("image/book.png").getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		bookIconLabel.setIcon(new ImageIcon(bookImage));
		bookIconLabel.setBackground(new Color(240, 240, 240));
		bookIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookIconLabel.setBounds(170, 77, 75, 75);
		panel.add(bookIconLabel);
		
		/**
		 * ϵͳ������ʾ
		 */
		JLabel systemTitleLabel = new JLabel("�� ͼ �� �� �� ϵ ͳ");
		systemTitleLabel.setFont(new Font("����", Font.BOLD, 29));
		systemTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemTitleLabel.setBounds(274, 49, 325, 128);
		panel.add(systemTitleLabel);
		
		try {
			//���Ľ�����
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		/**
		 * ����Ա��½��ť
		 */
		JButton managerLoginButton = new JButton("����Ա��½");
		managerLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel = new View.ManagerLoginPanel();
				panel.validate();
				frame.setContentPane(panel);
				frame.validate();
			
			}
		});
		managerLoginButton.setFont(new Font("����", Font.PLAIN, 15));
		managerLoginButton.setBounds(317, 224, 134, 47);
		managerLoginButton.setFocusable(false);
		panel.add(managerLoginButton);
		
		/**
		 * �û���½��ť 
		 */
		JButton userLoginButton = new JButton("�û���½");
		userLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel = new View.ManagerLoginPanel();
				panel.validate();
				frame.setContentPane(panel);
				frame.validate();
			}
		});
		userLoginButton.setFont(new Font("����", Font.PLAIN, 15));
		userLoginButton.setBounds(317, 301, 134, 47);
		userLoginButton.setFocusable(false);
		panel.add(userLoginButton);
		
		/**
		 * �˳���ť
		 */
		JButton exitButton = new JButton("�˳�");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("����", Font.PLAIN, 15));
		exitButton.setBounds(317, 372, 134, 47);
		exitButton.setFocusable(false);
		panel.add(exitButton);
	}
	
	
}
