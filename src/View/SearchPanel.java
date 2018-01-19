package View;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class SearchPanel extends JPanel {
	private JTextField searchTextField;

	/**
	 * Create the panel.
	 */
	public SearchPanel() {
		setBorder(null);
		setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.setBounds(0, 0, 349, 31);
		add(searchTextField);
		
		JButton searchButton = new JButton("搜 索 图 书");
		searchButton.setFont(new Font("宋体", Font.PLAIN, 15));
		searchButton.setBounds(379, 0, 123, 31);
		add(searchButton);
		
		JLabel searchConditionLabel = new JLabel("搜索条件：");
		searchConditionLabel.setFont(new Font("宋体", Font.PLAIN, 13));
		searchConditionLabel.setBounds(0, 51, 65, 20);
		add(searchConditionLabel);
		
		JRadioButton bookNameRadioButton = new JRadioButton("书名");
		bookNameRadioButton.setBounds(84, 51, 49, 23);
		add(bookNameRadioButton);
		
		JRadioButton authorRadioButton = new JRadioButton("作者");
		authorRadioButton.setBounds(143, 51, 49, 23);
		add(authorRadioButton);
		
		JRadioButton summaryRadioButton = new JRadioButton("简介");
		summaryRadioButton.setBounds(202, 51, 49, 23);
		add(summaryRadioButton);
		
		JRadioButton allRadioButton = new JRadioButton("全部字段");
		allRadioButton.setBounds(261, 50, 73, 23);
		add(allRadioButton);

	}

}
