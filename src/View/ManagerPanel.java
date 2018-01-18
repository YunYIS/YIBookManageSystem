package View;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManagerPanel extends JPanel {
	private JTable table;
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(null);
		
		JLabel lblZyt = new JLabel("\u7BA1\u7406\u5458 zyt");
		lblZyt.setFont(new Font("ËÎÌו", Font.BOLD | Font.ITALIC, 16));
		lblZyt.setBounds(539, 49, 106, 30);
		add(lblZyt);
		
		JLabel lblNewLabel = new JLabel("\u56FE \u4E66 \u4FE1 \u606F \u7BA1 \u7406");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(211, 10, 257, 69);
		add(lblNewLabel);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(10, 126, 135, 22);
		add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mntmNewMenuItem_1.setBounds(10, 147, 135, 22);
		add(mntmNewMenuItem_1);
		

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
