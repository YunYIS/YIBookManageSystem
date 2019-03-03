package View;

import javax.swing.JPanel;

import Database.BOOKDAO;
import model.Book;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.AbstractListModel;

public class BorrowDisplayPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BorrowDisplayPanel() {
		setLayout(null);
		
		JLabel titleLabel = 
				new JLabel(MainFrame.nowUser.getUserName() + "�Ľ������:");
		titleLabel.setFont(new Font("����", Font.BOLD, 15));
		titleLabel.setBounds(96, 53, 187, 26);
		add(titleLabel);
		JTableView tableView = new JTableView(getColumnNames(), getData());
		add(tableView);
		
	}
	
	private String[] getColumnNames(){
		String[] columnNames = {"no", "����", "����", "��������", "����", "ҳ��", "�۸�", "���", "�˻�"};
		return columnNames;
	}
	
	private Object[][] getData(){
		BOOKDAO bookdao = new BOOKDAO();
		List<Book> retBookList = new ArrayList<>();
		try {
			List<Book> bookList = bookdao.queryBookAll();
			for(int i = 0; i < bookList.size(); i++){
				if(MainFrame.nowUser.getUserName().equals(bookList.get(i).getBorrow())){
					retBookList.add(bookList.get(i));
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[][] datas = new Object[retBookList.size()][];
		return datas;
	}
	
	
}
