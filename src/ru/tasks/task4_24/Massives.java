package ru.tasks.task4_24;

import java.util.Comparator;
import java.util.List;

public class Massives {
	public static int[] sort(int[] arr) {
		if (arr.length <= 1) {
			return null;
		}

		int ind = 1, start = 0;
		while (start < arr.length) {
			change(arr, start, (arr.length - start) / 2 + start);
			ind = start + 1;
			while (ind < arr.length) {
				if (arr[start] > arr[ind]) {
					change(arr, start, ind);
				}
				ind++;
			}
			start++;
		}

		return arr;
	}

	public static <T extends Comparable<? super T>> List<T> sort(List<T> arr) {
		if (arr.size() <= 1) {
			return null;
		}

		int ind = 1, start = 0;
		while (start < arr.size()) {
			change(arr, start, (arr.size() - start) / 2 + start);
			ind = start + 1;
			while (ind < arr.size()) {
				if (arr.get(start).compareTo(arr.get(ind)) > 0) {
					change(arr, start, ind);
				}
				ind++;
			}
			start++;
		}

		return arr;
	}

	private static void change(int[] arr, int right, int left) {
		int c = arr[right];
		arr[right] = arr[left];
		arr[left] = (int) c;
	}

	private static <T> void change(List<T> arr, int right, int left) {
		T c = arr.get(right);
		arr.set(right, arr.get(left));
		arr.set(left, c);
	}

	// возвращает индекс элемента в массиве со значением value
	// или -1, если такого нет
	public static <T extends Comparable<? super T>> int indexOf(T[] data, T value) {
		return 0;
	}

	// возвращает наименьший индекс элемента, строго большего value
	// или -1, если такого нет
	public static <T extends Comparable<? super T>> int indexOfHigher(T[] data, T value) {
		return 0;
	}

	// возвращает наибольший индекс элемента, строго меньшего value
	// или -1, если такого нет
	public static <T extends Comparable<? super T>> int indexOfLower(T[] data, T value) {
		return 0;
	}

	// и такие же методы для списков (по сути копия кода
	// с разницей только в способе обращения к элементам)
	public static <T extends Comparable<? super T>> int indexOf(List<? super T> data, T value) {
		return 0;
	}

	public static <T extends Comparable<? super T>> int indexOfHigher(List<? super T> data, T value) {
		return 0;
	}

	public static <T extends Comparable<? super T>> int indexOfLower(List<? super T> data, T value) {
		return 0;
	}

}
