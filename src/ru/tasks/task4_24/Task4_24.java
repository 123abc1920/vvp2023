package ru.tasks.task4_24;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.JsonIOException;

public class Task4_24 {
	public static <T> void main(String[] args) throws JsonIOException, IOException {
		/*
		 * int[] arr = new int[10]; for (int i = 0; i < arr.length; i++) { arr[i] =
		 * (int) (Math.random() * 100); }
		 */
		int[] arr = readFile.readInts();
		for (int i = 0; i < Massives.sort(arr).length; i++) {
			System.out.print(Massives.sort(arr)[i] + " ");
		}

		System.out.println();

		/*
		 * List<String> l = new ArrayList<>(Arrays.asList("ba", "djjj", "a", "c0",
		 * "a1"));
		 */
		List<String> l = readFile.readStrings();
		l = Massives.sort(l);
		for (String t : l) {
			System.out.print(t + " ");
		}

		System.out.println();

		/*
		 * List<Product> l2 = new ArrayList<>(); l2.add(new Product("milk", 120));
		 * l2.add(new Product("milk", 10)); l2.add(new Product("milka", 37));
		 */
		List<Product> l2 = readFile.readProducts();
		l2 = Massives.sort(l2);
		for (Product t : l2) {
			System.out.print(t.getName() + " " + t.getCost() + " ");
		}
		System.out.println();

		System.out.println();
		System.out.println(Massives.indexOf(arr, -10));
		System.out.println(Massives.indexOfHigher(arr, 20));
		System.out.println(Massives.indexOfLower(arr, 49));

		System.out.println();
		System.out.println(Massives.indexOf(l, "c0"));
		System.out.println(Massives.indexOfHigher(l, "c00"));
		System.out.println(Massives.indexOfLower(l, "baa"));
		
		System.out.println();
		System.out.println(Massives.indexOf(l2, new Product("milk2", 309)));
		System.out.println(Massives.indexOfHigher(l2, new Product("milk", 309)));
		System.out.println(Massives.indexOfLower(l2, new Product("milk", 309)));

		Win4 win = new Win4(arr, l, l2);
		win.setVisible(true);
	}
}
