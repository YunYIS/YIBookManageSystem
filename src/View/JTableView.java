package View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * ʹ���Զ����TableMode������չʾ������Ϣ��JTable�ؼ�
 * ����Oracleʾ��:
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 * @author YunYIS
 */
@SuppressWarnings("serial")
public class JTableView extends JPanel {
    private boolean DEBUG = false;

    public JTableView(String[] columnNames, Object[][] data) {
        super(new GridLayout(1,0));
        
        try {
			//���Ľ�����
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

        JTable table = new JTable(new MyTableModel(columnNames, data));
        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        //���ô˱��Ƿ�ʼ�մ�����������ӿڵĸ߶�
        table.setFillsViewportHeight(true);

        //�������
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel {
    	private String[] columnNames;
        private Object[][] data;
        
        public MyTableModel(String[] columnNames, Object[][] data){
        	this.columnNames = columnNames;
        	this.data = data;
        }
        
        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTableʹ�ô˷�����ȷ��ÿһ��Ԫ��Ĭ����Ⱦ���༭���������û��ʵ�����������
         * ��ô���һ�н������ı�����true��/��false������������һ����ѡ��
         */
        @SuppressWarnings({ "unchecked", "rawtypes" })
		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                                   + " to " + value
                                   + " (an instance of "
                                   + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i=0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j=0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }
}
