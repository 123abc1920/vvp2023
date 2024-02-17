package ru.tasks.task1_16;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

public class PolynomWin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int mas = 50;
	private DrawingPanel graphicLayout;
	private int startX = 0;
	private int startY = 0;
	private boolean dragBool = false;

	/**
	 * Create the frame.
	 */
	public PolynomWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		graphicLayout = new DrawingPanel();
		contentPane.add(graphicLayout, BorderLayout.CENTER);

		graphicLayout.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startX = (int) Math
						.round((e.getX() - (Task1_16.win1.getFrameSize().getX() / 2.0)) / Task1_16.win1.getMas());
				startY = (int) -Math
						.round((e.getY() - (Task1_16.win1.getFrameSize().getY() / 2.0)) / Task1_16.win1.getMas());

				for (Point p : Task1_16.polynom.getTops()) {
					if (startX == p.getX() && startY == p.getY()) {
						dragBool = true;
					}
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (dragBool) {
					dragBool = false;
					int newX = (int) Math
							.round((e.getX() - (Task1_16.win1.getFrameSize().getX() / 2.0)) / Task1_16.win1.getMas());
					int newY = (int) -Math
							.round((e.getY() - (Task1_16.win1.getFrameSize().getY() / 2.0)) / Task1_16.win1.getMas());

					List<Point> list = new ArrayList<Point>();
					int movementX = (int) (newX - startX);
					int movementY = (int) (newY - startY);

					for (int i = 0; i < Task1_16.polynom.getTops().size(); i++) {
						list.add(new Point(Task1_16.polynom.getTops().get(i).getX() + movementX,
								Task1_16.polynom.getTops().get(i).getY() + movementY));
					}

					Task1_16.polynom.setTops(list);

					graphicLayout.repaint();
				}

			}
		});
	}

	public Point getFrameSize() {
		Rectangle r = this.getBounds();

		return new Point(r.width, r.height);
	}

	public int getMas() {
		return this.mas;
	}

	public void setMas(int mas) {
		if (mas > 0 && mas < 80) {
			this.mas = mas;
		}
	}
}
