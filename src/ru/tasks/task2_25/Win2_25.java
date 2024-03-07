package ru.tasks.task2_25;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class Win2_25 extends JFrame {

	public static TheList<TheElement> l = new TheList<>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private DefaultTableModel changeModel = new DefaultTableModel(1, 1);
	private JTable first;
	private JTable second;
	private int colCount = 1;

	/**
	 * Create the frame.
	 */
	public Win2_25() {
		this.setTitle("Task2_25");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		model = new DefaultTableModel(1, colCount);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JLabel lblNewLabel = new JLabel("Начальная таблица:");
		panel_2.add(lblNewLabel);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(25, 25, 0, 25));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel.add(scrollPane);

		first = new JTable(model);
		first.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		first.setPreferredScrollableViewportSize(new Dimension(100, 100));
		first.setTableHeader(null);
		scrollPane.setViewportView(first);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JLabel lblNewLabel_1 = new JLabel("Итоговая таблица:");
		panel_3.add(lblNewLabel_1);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_3);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EmptyBorder(25, 25, 0, 25));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel.add(scrollPane_1);

		second = new JTable(changeModel);
		second.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		second.setPreferredScrollableViewportSize(new Dimension(100, 100));
		second.setTableHeader(null);
		scrollPane_1.setViewportView(second);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel.add(verticalStrut_1);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JButton addBtn = new JButton("+");
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colCount++;
				model.addColumn("");
				first.setModel(model);
				second.setModel(changeModel);
			}
		});

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue_1);
		panel_1.add(addBtn);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_5);

		JButton readBtn = new JButton("Read");
		readBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					l = ReadWrite.read();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}

				colCount = l.size();
				model.setColumnCount(colCount);
				int j = 0;
				for (TheElement i : l) {
					model.setValueAt(i.getValue(), 0, j++);
				}
			}
		});
		panel_1.add(readBtn);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_6);

		JButton changeBtn = new JButton("Change");
		changeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				l = new TheList<>();
				for (int i = 0; i < colCount; i++) {
					l.addEnd(first.getValueAt(0, i));
				}
				changeModel.setColumnCount(l.size());
				for (int i = 0; i < l.size() / 2; i++) {
					l.change(i, l.size() - i - 1);
					changeModel.setValueAt(l.get(i).getValue(), 0, i);
					changeModel.setValueAt(l.get(l.size() - i - 1).getValue(), 0, l.size() - i - 1);
				}
				if (l.size() % 2 != 0) {
					changeModel.setValueAt(l.get(l.size() / 2).getValue(), 0, l.size() / 2);
				}
				try {
					ReadWrite.write(l);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colCount = 1;
				model = new DefaultTableModel(1, colCount);
				first.setModel(model);
			}
		});
		panel_1.add(clearBtn);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		panel_1.add(changeBtn);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_7);

		JButton deleteBtn = new JButton("-");
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (colCount > 1) {
					colCount--;
				}
				model.setColumnCount(colCount);
				first.setModel(model);
				second.setModel(changeModel);
			}
		});
		panel_1.add(deleteBtn);

		Component horizontalGlue = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue);
	}

}
