package ru.tasks.task3_6;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ru.tasks.task1_16.Task1_16;
import ru.tasks.task3_6.Cell.G;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.JScrollPane;

public class Win6 extends JFrame {
	public static DrawingPane DrawPane;
	public int startX = -1, startY = -1, endX = -1, endY = -1;
	public List<Cell> Path = new ArrayList<>();

	private JPanel contentPane;

	private Map<Integer, List<G>> map = new HashMap<>();
	private int[] arr;

	private boolean start = false;
	private boolean draw = false;
	private boolean rect = false;

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
		DrawPane.setPreferredSize(new Dimension(20 * Task3_6.mas, 20 * Task3_6.mas));
		scrollPane.setViewportView(DrawPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		Component horizontalGlue = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!draw) {
					draw = true;
					rect = true;
					btnNew.setBackground(Color.WHITE);
					Path.clear();
					startX = startY = endX = endY = -1;
					Task3_6.l.clear();
					map.clear();
					DrawPane.repaint();
				} else {
					draw = false;
					btnNew.setBackground(null);
				}
			}
		});
		panel_1.add(btnNew);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!draw) {
					draw = true;
					btnAdd.setBackground(Color.WHITE);
					Path.clear();
					startX = startY = endX = endY = -1;
				} else {
					draw = false;
					btnAdd.setBackground(null);
				}
			}
		});
		panel_1.add(btnAdd);

		Component horizontalStrut1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut1);

		JButton btnStrt = new JButton("Start");
		btnStrt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!start) {
					startX = startY = endX = endY = -1;
					Path.clear();
					DrawPane.repaint();
					start = true;
					btnStrt.setBackground(Color.WHITE);
				} else {
					start = false;
					btnStrt.setBackground(null);
					startX = startY = endX = endY = -1;
				}
			}
		});
		panel_1.add(btnStrt);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);

		JButton btnSave = new JButton("Save");
		panel_1.add(btnSave);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);

		JButton btnRead = new JButton("Read");
		btnRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					map = readWrite.read();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					arr = readWrite.readSize();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				Task3_6.l.clear();
				Task3_6.l.update(arr[0], arr[1], arr[2], arr[3], map);
				startX = startY = endX = endY = -1;
				Path.clear();
				DrawPane.repaint();
			}
		});
		panel_1.add(btnRead);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		panel_1.add(horizontalGlue_1);

		DrawPane.addMouseListener(new MouseAdapter() {
			int x1, y1, x2, y2;

			public void mousePressed(MouseEvent e) {
				if (start) {
					if (startX == -1 || startY == -1) {
						startX = Math.round(e.getX() / Task3_6.mas);
						startY = Math.round(e.getY() / Task3_6.mas);
						if (startX < Task3_6.l.getSize()[3]
								|| startX > (Task3_6.l.getSize()[3] + Task3_6.l.getSize()[0]) - 1
								|| startY < Task3_6.l.getSize()[2]
								|| startY > (Task3_6.l.getSize()[2] + Task3_6.l.getSize()[1]) - 1) {
							startX = startY = -1;
						}
						DrawPane.repaint();
					} else {
						endX = Math.round(e.getX() / Task3_6.mas);
						endY = Math.round(e.getY() / Task3_6.mas);
						DrawPane.repaint();
						start = false;
						btnStrt.setBackground(null);
						Task3_6.l.setStart(startX - Task3_6.l.getSize()[3]
								+ Task3_6.l.getSize()[0] * (startY - Task3_6.l.getSize()[2]));
						Task3_6.l.setEnd(endX - Task3_6.l.getSize()[3]
								+ Task3_6.l.getSize()[0] * (endY - Task3_6.l.getSize()[2]));

						/*-----*/

						// Path = FindPath.findStandart();
						Path = FindPath.findMyQueue();

						/*-----*/
					}
				}

				if (draw) {
					x1 = Math.round(e.getX() / Task3_6.mas);
					y1 = Math.round(e.getY() / Task3_6.mas);

					DrawPane.repaint();
					if (!rect) {
						if (x1 > Task3_6.l.getSize()[3] - 1 && x1 < (Task3_6.l.getSize()[3] + Task3_6.l.getSize()[0])
								&& y1 > Task3_6.l.getSize()[2] - 1
								&& y1 < (Task3_6.l.getSize()[2] + Task3_6.l.getSize()[1])) {

							if (!map.containsKey(x1 - Task3_6.l.getSize()[3]
									+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0])) {
								map.put(x1 - Task3_6.l.getSize()[3]
										+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0],
										Arrays.asList(G.RIGHT));
							} else {
								if (map.get(x1 - Task3_6.l.getSize()[3]
										+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0]).size() == 1) {
									if (map.get(x1 - Task3_6.l.getSize()[3]
											+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0])
											.contains(G.RIGHT)) {
										map.put(x1 - Task3_6.l.getSize()[3]
												+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0],
												Arrays.asList(G.BOTTOM));
									} else {
										map.put(x1 - Task3_6.l.getSize()[3]
												+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0],
												Arrays.asList(G.RIGHT, G.BOTTOM));
									}
								} else {
									map.remove(x1 - Task3_6.l.getSize()[3]
											+ (y1 - Task3_6.l.getSize()[2]) * Task3_6.l.getSize()[0]);
								}
							}

							Task3_6.l.clear();
							Task3_6.l.update(-1, -1, -1, -1, map);
							DrawPane.repaint();
						}
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (rect) {
					rect = false;

					x2 = Math.round(e.getX() / Task3_6.mas);
					y2 = Math.round(e.getY() / Task3_6.mas);

					if (x1 > x2) {
						int c = x2;
						x2 = x1;
						x1 = c;
					}

					if (y1 > y2) {
						int c = y2;
						y2 = y1;
						y1 = c;
					}

					Task3_6.l.update(x2 - x1 + 1, y2 - y1 + 1, y1, x1, map);
					DrawPane.repaint();
				}
			}
		});
	}
}
