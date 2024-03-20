package ru.tasks.task3_6;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.tasks.task3_6.Cell.G;

public class Task3_6 {
	public static Win6 win = null;
	public static int mas = 50;
	public static Labirynt l;

	public static void main(String[] args) throws FileNotFoundException {
		Map<Integer, List<G>> map = readWrite.read();
		int[] arr = readWrite.readSize();
		l = new Labirynt(arr[0], arr[1], arr[2], arr[3], map);

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
