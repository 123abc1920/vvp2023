package ru.tasks.task4_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4_24 {
	public static <T> void main(String[] args) {
		/*
		 * int[] arr = new int[10]; for (int i = 0; i < arr.length; i++) { arr[i] =
		 * (int) (Math.random() * 100); System.out.print(arr[i] + " "); }
		 * System.out.println();
		 * 
		 * for (int i = 0; i < Massives.sort(arr).length; i++) {
		 * System.out.print(Massives.sort(arr)[i] + " "); }
		 */

		/*
		 * List<String> l = new ArrayList<>(Arrays.asList("ba", "djjj", "a", "c0",
		 * "a1")); l = Massives.sort(l); for (String t : l) { System.out.print(t + " ");
		 * }
		 */

		List<Product> l = new ArrayList<>(
		/*
		 * Arrays.asList(new Product("a", 120), new Product("b", 10), new Product("c",
		 * 37))
		 */);
		l.add(new Product("milk", 120));
		l.add(new Product("milk", 10));
		l.add(new Product("milka", 37));
		l = Massives.sort(l);
		for (Product t : l) {
			System.out.print(t.getName() + " " + t.getCost() + " ");
		}

	}
}
