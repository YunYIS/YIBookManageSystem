package View;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
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
		
		JButton searchButton = new JButton("�� �� ͼ ��");
		searchButton.setFont(new Font("����", Font.PLAIN, 15));
		searchButton.setBounds(379, 0, 123, 31);
		add(searchButton);
		
		JLabel searchConditionLabel = new JLabel("����������");
		searchConditionLabel.setFont(new Font("����", Font.PLAIN, 13));
		searchConditionLabel.setBounds(0, 51, 65, 20);
		add(searchConditionLabel);
		
		JRadioButton bookNameRadioButton = new JRadioButton("����");
		bookNameRadioButton.setBounds(84, 51, 49, 23);
		add(bookNameRadioButton);
		
		JRadioButton authorRadioButton = new JRadioButton("����");
		authorRadioButton.setBounds(143, 51, 49, 23);
		add(authorRadioButton);
		
		JRadioButton summaryRadioButton = new JRadioButton("���");
		summaryRadioButton.setBounds(202, 51, 49, 23);
		add(summaryRadioButton);
		
		JRadioButton allRadioButton = new JRadioButton("ȫ���ֶ�");
		allRadioButton.setBounds(261, 50, 73, 23);
		add(allRadioButton);

	}

}
