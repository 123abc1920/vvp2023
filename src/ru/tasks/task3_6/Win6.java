package ru.tasks.task3_6;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JScrollPane;

public class Win6 extends JFrame {

	private JPanel contentPane;
	public JPanel DrawPane;

	/**
	 * Create the frame.
	 */
	public Win6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		DrawPane = new DrawingPane();
		DrawPane.setPreferredSize(new Dimension(20 * 50, 20 * 50));
		scrollPane.setViewportView(DrawPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		Component horizontalGlue = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue);

		JButton btnNew = new JButton("New");
		panel_1.add(btnNew);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);

		JButton btnAdd = new JButton("Add");
		panel_1.add(btnAdd);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);

		JButton btnSave = new JButton("Save");
		panel_1.add(btnSave);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);

		JButton btnRead = new JButton("Read");
		panel_1.add(btnRead);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue_1);
	}

}
