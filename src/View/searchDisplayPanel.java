package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchDisplayPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public searchDisplayPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("\u67E5\u8BE2\u7ED3\u679C:");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		label.setBounds(78, 40, 68, 24);
		add(label);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"no", "\u4E66\u540D", "\u4F5C\u8005", "\u51FA\u7248\u65E5\u671F", "\u6240\u5728\u56FD\u5BB6", "\u9875\u6570", "\u4EF7\u683C", "\u501F\u9605\u60C5\u51B5", "\u7B80\u4ECB"},
				{"1", "\u632A\u5A01\u7684\u68EE\u6797", "\u6751\u4E0A\u6625\u6811", "2007-7", "\u65E5\u672C", "384", "23\u5143", "\u65E0", null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(93, 124, 512, 32);
		add(table);
		
		JButton btnNewButton = new JButton("\u501F\u4E66");
		btnNewButton.setBounds(607, 138, 93, 18);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(549, 406, 101, 32);
		add(btnNewButton_1);

	}
}
