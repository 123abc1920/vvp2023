package ru.tasks.task1_16;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private int w;
	private int h;
	private int m;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		m = Task1_16.win1.getMas();
		w = Task1_16.win1.getPanelSize().getX();
		h = Task1_16.win1.getPanelSize().getY();

		g2d.translate(w / 2, h / 2);

		int i = -(w / 2) + (w / 2) % m;
		while (i <= (w / 2) - (w / 2) % m) {
			Line2D line = new Line2D.Double(i, -(h / 2), i, (h / 2));
			i += m;
			g2d.draw(line);
		}

		i = -(h / 2) + (h / 2) % m;
		while (i <= (h / 2) - (h / 2) % m) {
			Line2D line = new Line2D.Double(-(w / 2), i, (w / 2), i);
			i += m;
			g2d.draw(line);
		}

		g2d.setStroke(new BasicStroke(3));

		Line2D line = new Line2D.Double(-(w / 2), 0, (w / 2), 0);
		g2d.draw(line);
		line = new Line2D.Double(0, -(h / 2), 0, (h / 2));
		g2d.draw(line);

		g2d.setColor(new Color(0, 0, 255, 255));
		Path2D rectangle = new Path2D.Double();
		drawFigure(g2d, rectangle, Task1_16.rectangle);

		g2d.setColor(new Color(255, 0, 0, 255));
		Path2D polygon = new Path2D.Double();
		drawFigure(g2d, polygon, Task1_16.polynom);
	}

	private void drawFigure(Graphics2D g2d, Path2D polygon, Polynom polynom) {
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < polynom.getTops().size(); i++) {
			list.add(new Point(polynom.getTops().get(i).getX() * m, -(polynom.getTops().get(i).getY() * m)));

		}
		polygon.moveTo(list.get(0).getX(), list.get(0).getY());
		for (int i = 1; i < list.size(); i++) {
			polygon.lineTo(list.get(i).getX(), list.get(i).getY());
		}
		polygon.closePath();
		g2d.draw(polygon);
	}
}