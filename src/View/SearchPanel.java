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
		setLayout(null);
		
		searchTextField = new JTextField();
		searchTextField.setColumns(10);
		searchTextField.setBounds(0, 0, 349, 31);
		add(searchTextField);
		
		JButton searchButton = new JButton("\u641C \u7D22 \u56FE \u4E66");
		searchButton.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		searchButton.setBounds(379, 0, 123, 31);
		add(searchButton);
		
		JLabel searchConditionLabel = new JLabel("\u641C\u7D22\u6761\u4EF6\uFF1A");
		searchConditionLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		searchConditionLabel.setBounds(0, 51, 65, 20);
		add(searchConditionLabel);
		
		JRadioButton bookNameRadioButton = new JRadioButton("\u4E66\u540D");
		bookNameRadioButton.setBounds(84, 51, 49, 23);
		add(bookNameRadioButton);
		
		JRadioButton authorRadioButton = new JRadioButton("\u4F5C\u8005");
		authorRadioButton.setBounds(143, 51, 49, 23);
		add(authorRadioButton);
		
		JRadioButton summaryRadioButton = new JRadioButton("\u7B80\u4ECB");
		summaryRadioButton.setBounds(202, 51, 49, 23);
		add(summaryRadioButton);
		
		JRadioButton allRadioButton = new JRadioButton("\u5168\u90E8\u5B57\u6BB5");
		allRadioButton.setBounds(261, 50, 73, 23);
		add(allRadioButton);

	}

}
