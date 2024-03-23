package ru.tasks.task4_24;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Win4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	private DefaultTableModel intsModel;
	private DefaultTableModel stringModel;
	private DefaultTableModel productModel;

	/**
	 * Create the frame.
	 */
	public Win4(int[] ints, List<String> string, List<Product> product) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		intsModel = new DefaultTableModel(1, ints.length);
		for (int i = 0; i < ints.length; i++) {
			intsModel.setValueAt(ints[i], 0, i);
		}

		int i = 0;
		stringModel = new DefaultTableModel(1, string.size());
		for (String s : string) {
			stringModel.setValueAt(s, 0, i++);
		}

		i = 0;
		productModel = new DefaultTableModel(2, product.size() / 2 - 1);
		for (Product s : product) {
			productModel.setColumnCount(productModel.getColumnCount() + 1);
			productModel.setValueAt(s.getName(), 0, i);
			productModel.setValueAt(s.getCost(), 1, i++);
		}

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(UIManager.getColor("Button.background"), 10, true));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Int", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table.setTableHeader(null);
		table.setModel(intsModel);
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "String", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table_1.setTableHeader(null);
		table_1.setModel(stringModel);
		scrollPane_1.setViewportView(table_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2);

		table_2 = new JTable();
		table_2.setTableHeader(null);
		table_2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_2.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table_2.setModel(productModel);
		scrollPane_2.setViewportView(table_2);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel.add(verticalStrut);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel_4.add(horizontalGlue_2);

		JButton btnRead = new JButton("Read");
		panel_4.add(btnRead);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		panel_4.add(horizontalGlue_3);
	}

}
