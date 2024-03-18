package ru.tasks.task3_6;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

public class DrawingPane extends JPanel {
	private int w;
	private int h;
	private int m;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		m = 50;
		w = Task3_6.win.DrawPane.getWidth();
		h = Task3_6.win.DrawPane.getHeight();

		int i = 0;
		while (i <= w) {
			Line2D line = new Line2D.Double(i, 0, i, h);
			i += m;
			g2d.draw(line);
		}

		i = 0;
		while (i <= h) {
			Line2D line = new Line2D.Double(0, i, w, i);
			i += m;
			g2d.draw(line);
		}
	}
}
