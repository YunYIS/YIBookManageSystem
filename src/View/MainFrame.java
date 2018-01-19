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
/**
 * 
 * @author 张云天
 *
 */
public class MainFrame {

	public static JFrame mainJFrame;
	public static JPanel mainPanel;
	private JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.initialize();
					mainFrame.mainJFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 初始化JFrame
	 */
	public void initialize() {
		mainJFrame= new JFrame();
		mainJFrame.setBounds(100, 100, 790, 519);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainJFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/book.png"));
		setPanelContent();
		mainPanel = (JPanel) mainJFrame.getContentPane();
		mainPanel.add(contentPanel);
	}
	
	/**
	 * 设置主界面内容
	 */
	public void setPanelContent(){
		
		contentPanel.setLayout(null);
		
		/**
		 * 放置图片book.png
		 */
		JLabel bookIconLabel = new JLabel("");	
		//更改图片大小
		Image bookImage = Toolkit.getDefaultToolkit().getImage("image/book.png").getScaledInstance(75, 75, Image.SCALE_DEFAULT);
		bookIconLabel.setIcon(new ImageIcon(bookImage));
		bookIconLabel.setBackground(new Color(240, 240, 240));
		bookIconLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookIconLabel.setBounds(170, 77, 75, 75);
		contentPanel.add(bookIconLabel);
		
		/**
		 * 系统标题显示
		 */
		JLabel systemTitleLabel = new JLabel("易 图 书 管 理 系 统");
		systemTitleLabel.setFont(new Font("宋体", Font.BOLD, 29));
		systemTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		systemTitleLabel.setBounds(274, 49, 325, 128);
		contentPanel.add(systemTitleLabel);
		
		try {
			//更改界面风格
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		/**
		 * 管理员登陆按钮
		 */
		JButton managerLoginButton = new JButton("管理员登陆");
		managerLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				mainPanel.removeAll();
				mainPanel.add(new ManagerLoginPanel(contentPanel));
				mainPanel.validate();
				mainJFrame.repaint();
			}
		});
		managerLoginButton.setFont(new Font("宋体", Font.PLAIN, 15));
		managerLoginButton.setBounds(317, 224, 134, 47);
		managerLoginButton.setFocusable(false);
		contentPanel.add(managerLoginButton);
		
		/**
		 * 用户登陆按钮 
		 */
		JButton userLoginButton = new JButton("用户登陆");
		userLoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mainPanel.removeAll();
				mainPanel.add(new UserLoginPanel(contentPanel));
				mainPanel.validate();
				mainJFrame.repaint();
			}
		});
		userLoginButton.setFont(new Font("宋体", Font.PLAIN, 15));
		userLoginButton.setBounds(317, 301, 134, 47);
		userLoginButton.setFocusable(false);
		contentPanel.add(userLoginButton);
		
		/**
		 * 退出按钮
		 */
		JButton exitButton = new JButton("退出");
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setFont(new Font("宋体", Font.PLAIN, 15));
		exitButton.setBounds(317, 372, 134, 47);
		exitButton.setFocusable(false);
		contentPanel.add(exitButton);
		
	}
	
}
