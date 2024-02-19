package ru.tasks.task1_16;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

public class Task1_16 {
	public static Polynom polynom;
	public static PolynomWin win1;
	public static Polynom rectangle;

	private static int a = 0;
	private static int b = 0;

	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, -1);
		Point p3 = new Point(-1, 1);
		List<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		polynom = new Polynom(points);
		rectangle = new Polynom(createRectangle());

		win1 = new PolynomWin();
		win1.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int width = (Task1_16.rectangle.getTops().get(0).getX() - Task1_16.rectangle.getTops().get(3).getX());
				int height = (Task1_16.rectangle.getTops().get(1).getY() - Task1_16.rectangle.getTops().get(0).getY());

				if (win1.getHeight() / Task1_16.win1.getMas() - height < 3
						|| win1.getWidth() / Task1_16.win1.getMas() - width < 3) {
					Task1_16.win1.setMas(Task1_16.win1.getMas() - 5);
				} else if ((win1.getHeight() / Task1_16.win1.getMas()) - height > 7
						|| (win1.getWidth() / Task1_16.win1.getMas()) - width > 7) {
					Task1_16.win1.setMas(Task1_16.win1.getMas() + 5);
				}
			}
		});
		win1.setVisible(true);
	}

	private static List<Point> createRectangle() {
		List<Point> lst = new ArrayList<>();

		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		int minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
		for (Point p : polynom.getTops()) {
			if (p.getX() < minX) {
				minX = p.getX();
			}
			if (p.getX() > maxX) {
				maxX = p.getX();
			}
			if (p.getY() < minY) {
				minY = p.getY();
			}
			if (p.getY() > maxY) {
				maxY = p.getY();
			}
		}

		a = maxX - minX;
		b = maxY - minY;

		Point p1 = new Point(maxX, minY);
		Point p2 = new Point(maxX, minY + b);
		Point p3 = new Point(maxX - a, minY + b);
		Point p4 = new Point(maxX - a, minY);

		lst.add(p1);
		lst.add(p2);
		lst.add(p3);
		lst.add(p4);

		return lst;
	}
}
