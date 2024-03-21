package ru.tasks.task3_6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import ru.tasks.task3_6.Cell.G;

public class DrawingPane extends JPanel {
	private int w;
	private int h;
	private int m;
	private int top = Task3_6.l.getSize()[2], left = Task3_6.l.getSize()[3];

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		m = Task3_6.mas;
		h = w = 20 * Task3_6.mas;

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

		g2d.setStroke(new BasicStroke(3));
		g2d.drawRect(left * Task3_6.mas, top * Task3_6.mas, Task3_6.l.getSize()[0] * Task3_6.mas,
				Task3_6.l.getSize()[1] * Task3_6.mas);

		int row = Task3_6.l.getSize()[1];
		int col = Task3_6.l.getSize()[0];
		for (i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (Task3_6.l.getArray().get(i + j * col).getOneTop(G.RIGHT) == null) {
					Line2D line = new Line2D.Double((left + i + 1) * Task3_6.mas, (top + j) * Task3_6.mas,
							(left + i + 1) * Task3_6.mas, (top + j + 1) * Task3_6.mas);
					g2d.draw(line);
				}
				if (Task3_6.l.getArray().get(i + j * col).getOneTop(G.BOTTOM) == null) {
					Line2D line = new Line2D.Double((left + i) * Task3_6.mas, (top + j + 1) * Task3_6.mas,
							(left + i + 1) * Task3_6.mas, (top + j + 1) * Task3_6.mas);
					g2d.draw(line);
				}
			}
		}

		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(Color.RED);
		if (Task3_6.win.startX != -1 && Task3_6.win.startY != -1) {
			g2d.drawLine(Task3_6.win.startX * Task3_6.mas + Task3_6.mas / 2,
					Task3_6.win.startY * Task3_6.mas + Task3_6.mas / 2,
					Task3_6.win.startX * Task3_6.mas + Task3_6.mas / 2,
					Task3_6.win.startY * Task3_6.mas + Task3_6.mas / 2);
		}
		if (Task3_6.win.endX != -1 && Task3_6.win.endY != -1) {
			g2d.drawLine(Task3_6.win.endX * Task3_6.mas + Task3_6.mas / 2,
					Task3_6.win.endY * Task3_6.mas + Task3_6.mas / 2, Task3_6.win.endX * Task3_6.mas + Task3_6.mas / 2,
					Task3_6.win.endY * Task3_6.mas + Task3_6.mas / 2);
		}

		for (int j = 0; j < Task3_6.win.Path.size() - 1; j++) {
			g2d.drawLine((Task3_6.win.Path.get(j).getNum() + Task3_6.l.getSize()[3]) * Task3_6.mas + Task3_6.mas / 2,
					(Task3_6.win.Path.get(j).getNum() / Task3_6.l.getSize()[0] + Task3_6.l.getSize()[2]) * Task3_6.mas
							+ Task3_6.mas / 2,
					(Task3_6.win.Path.get(j + 1).getNum() + Task3_6.l.getSize()[3]) * Task3_6.mas + Task3_6.mas / 2,
					(Task3_6.win.Path.get(j + 1).getNum() / Task3_6.l.getSize()[0] + Task3_6.l.getSize()[2])
							* Task3_6.mas + Task3_6.mas / 2);
		}
	}
}
