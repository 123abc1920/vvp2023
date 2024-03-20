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
		/*map.put(0, Arrays.asList(G.RIGHT));
		map.put(5, Arrays.asList(G.RIGHT));
		map.put(2, Arrays.asList(G.BOTTOM));
		map.put(3, Arrays.asList(G.RIGHT));
		map.put(7, Arrays.asList(G.RIGHT, G.BOTTOM));
		map.put(9, Arrays.asList(G.BOTTOM));
		map.put(12, Arrays.asList(G.RIGHT));*/
		l = new Labirynt(3, 5, 2, 1, map);

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
		if (mas > 70) {
			mas = 70;
		}
		win.DrawPane.repaint();
	}
}
