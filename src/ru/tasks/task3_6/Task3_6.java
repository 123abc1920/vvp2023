package ru.tasks.task3_6;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.tasks.task3_6.Cell.G;

public class Task3_6 {
	public static Win6 win = null;
	public static int mas = 50;
	public static Labirynt l;

	public static void main(String[] args) {
		Map<Integer, List<G>> map = new HashMap<>();
		map.put(0, Arrays.asList(G.RIGHT));
		map.put(1, Arrays.asList(G.BOTTOM));
		l = new Labirynt(2, 2, map);

		win = new Win6();
		win.setVisible(true);

		win.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				if (win.getHeight() / mas < 5 || win.getWidth() / mas < 5) {
					changeMas(-5);
				} else if ((win.getHeight() / mas) > 7 || (win.getWidth() / mas) > 7) {
					changeMas(5);
				}
			}
		});
	}

	private static void changeMas(int r) {
		mas += r;
		if (mas < 10) {
			mas = 10;
		}
		if (mas > 50) {
			mas = 50;
		}
		win.DrawPane.repaint();
	}
}
