package ru.tasks.task3_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ru.tasks.task3_6.Cell.G;

public class readWrite {
	private static File input = new File("InputFiles//Task3_6//input.txt");
	private static File inputSize = new File("InputFiles//Task3_6//inputSize.txt");
	private static File output = new File("/OutputFiles/Task3_6/output.txt");

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

	public static void write() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(input);

		pw.flush();
	}
}
