package ru.tasks.task1_16;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JScrollPane;

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

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);

		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int w = graphicLayout.getWidth(), h = graphicLayout.getHeight();
					BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
					Graphics g = image.createGraphics();
					graphicLayout.paint(g);
					ImageIO.write(image, "jpeg", new File("example.jpeg"));
				} catch (IOException err) {
					System.err.println(err);
				}
			}
		});
		panel.add(saveButton);

		Component horizontalStrut = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut);

		JLabel infoLabel = new JLabel();
		infoLabel.setText("S=" + Task1_16.polynom.findS() + " P=" + Task1_16.polynom.findP());
		panel.add(infoLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		graphicLayout = new DrawingPanel();
		graphicLayout.setPreferredSize(new Dimension(20 * mas, 20 * mas));
		scrollPane.setViewportView(graphicLayout);

		graphicLayout.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				startX = (int) Math
						.round((e.getX() - (Task1_16.win1.getFrameSize().getX() / 2.0)) / Task1_16.win1.getMas());
				startY = (int) -Math
						.round((e.getY() - (Task1_16.win1.getFrameSize().getY() / 2.0)) / Task1_16.win1.getMas());

				if (startX < Task1_16.rectangle.getTops().get(0).getX()
						&& startX > Task1_16.rectangle.getTops().get(3).getX()) {
					if (startY < Task1_16.rectangle.getTops().get(2).getY()
							&& startY > Task1_16.rectangle.getTops().get(0).getY()) {
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

					int movementX = (int) (newX - startX);
					int movementY = (int) (newY - startY);

					newTops(movementX, movementY, Task1_16.polynom);
					newTops(movementX, movementY, Task1_16.rectangle);

					graphicLayout.repaint();
				}

			}
		});
	}

	private void newTops(int movementX, int movementY, Polynom polynom) {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < polynom.getTops().size(); i++) {
			list.add(new Point(polynom.getTops().get(i).getX() + movementX,
					polynom.getTops().get(i).getY() + movementY));
		}
		polynom.setTops(list);
	}

	public Point getFrameSize() {
		return new Point(graphicLayout.getWidth(), graphicLayout.getHeight());
	}

	public int getMas() {
		return this.mas;
	}

	public void setMas(int mas) {
		if (mas > 0 && mas < 80) {
			this.mas = mas;
			graphicLayout.setPreferredSize(new Dimension(20 * mas, 20 * mas));
		}
	}
}
