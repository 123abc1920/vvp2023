package ru.tasks.task2_25;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite {
	private static File input = new File("InputFiles\\Task2_25\\input.txt");
	private static File output = new File("OutputFiles\\Task2_25\\output.txt");

	public static TheList<TheElement> read() throws FileNotFoundException {
		Scanner in = new Scanner(input);
		in.useDelimiter(" ");
		TheList<TheElement> lst = new TheList<>();

		while (in.hasNext()) {
			lst.addEnd(in.next());
		}

		return lst;
	}

	public static void write(TheList<TheElement> lst) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(output);
		for (TheElement i : lst) {
			pw.append(i.getValue() + " ");
		}
		pw.flush();
	}
}
