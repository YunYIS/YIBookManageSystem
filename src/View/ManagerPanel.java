package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ManagerPanel extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(null);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel welcomeLabel = new JLabel("����Ա zyt");
		welcomeLabel.setBounds(603, 121, 106, 30);
		welcomeLabel.setFont(new Font("����", Font.BOLD | Font.ITALIC, 16));
		add(welcomeLabel);
		
		JLabel titleLabel = new JLabel("ͼ �� �� Ϣ �� ��");
		titleLabel.setBounds(275, 60, 257, 69);
		titleLabel.setFont(new Font("����", Font.BOLD, 26));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(titleLabel);
		
		JButton queryButton = new JButton("�� ѯ");
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		queryButton.setBounds(118, 208, 123, 31);
		queryButton.setFont(new Font("����", Font.PLAIN, 15));
		add(queryButton);
		
		JButton updateButton = new JButton("�� ��");
		updateButton.setBounds(264, 208, 123, 31);
		updateButton.setFont(new Font("����", Font.PLAIN, 15));
		add(updateButton);
		
		JButton addButton = new JButton("�� ��");
		addButton.setBounds(409, 208, 123, 31);
		addButton.setFont(new Font("����", Font.PLAIN, 15));
		add(addButton);
		
		JButton deleteButton = new JButton("ɾ ��");
		deleteButton.setBounds(554, 208, 123, 31);
		deleteButton.setFont(new Font("����", Font.PLAIN, 15));
		add(deleteButton);
		
		SearchPanel panel = new SearchPanel();
		panel.setBorder(null);
		panel.setBounds(154, 369, 504, 75);
		add(panel);

	}
}
