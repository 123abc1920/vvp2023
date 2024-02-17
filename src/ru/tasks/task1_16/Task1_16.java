package ru.tasks.task1_16;

import java.awt.Rectangle;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Task1_16 {
	public static Polynom polynom;
	public static PolynomWin win1;

	public static void main(String[] args) {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(2, -3);
		Point p3 = new Point(-3, -1);
		List<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		polynom = new Polynom(points);

		win1 = new PolynomWin();
		win1.setVisible(true);

		win1.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Rectangle r = win1.getBounds();
				if (r.height / win1.getMas() >= 6) {
					win1.setMas(win1.getMas() + 10);
				} else {
					win1.setMas(win1.getMas() - 10);
				}
			}
		});
	}
}
