package ru.tasks.task3_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import ru.tasks.task3_6.Cell.G;

public class readWrite {
	private static File input = new File("InputFiles//Task3_6//input.txt");
	private static File inputSize = new File("InputFiles//Task3_6//inputSize.txt");

	public static Map<Integer, List<G>> read() throws FileNotFoundException {
		Scanner in = new Scanner(input);
		Map<Integer, List<G>> map = new HashMap<>();

		while (in.hasNextLine()) {
			Scanner mini = new Scanner(in.nextLine());
			mini.useDelimiter(":");
			int i = mini.nextInt();
			Scanner array = new Scanner(mini.next());
			array.useDelimiter(" ");
			List<G> lst = new ArrayList<>();
			while (array.hasNext()) {
				lst.add(G.valueOf(array.next()));
			}
			map.put(i, lst);
		}

		return map;
	}

	public static int[] readSize() throws FileNotFoundException {
		Scanner in = new Scanner(inputSize);
		in.useDelimiter(" ");
		return new int[] { in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() };
	}

	public static void write(Map<Integer, List<G>> map) throws FileNotFoundException {
		PrintWriter output = new PrintWriter(input);
		PrintWriter outputSize = new PrintWriter(inputSize);

		String text = Task3_6.l.getSize()[0] + " " + Task3_6.l.getSize()[1] + " " + Task3_6.l.getSize()[2] + " "
				+ Task3_6.l.getSize()[3];
		outputSize.write(text);
		outputSize.flush();

		text = "";
		for (Entry<Integer, List<G>> entry : map.entrySet()) {
			text += entry.getKey() + ":";
			for (G g : entry.getValue()) {
				text += g + " ";
			}
			text += "\n";
		}

		output.write(text);
		output.flush();
	}
}
