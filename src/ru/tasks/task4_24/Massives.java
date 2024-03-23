package ru.tasks.task4_24;

import java.util.ArrayList;
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
	public static int indexOf(int[] data, int value) {
		if (data.length == 1) {
			return 0;
		} else if (data.length == 0) {
			return -1;
		}

		if (data[0] == value) {
			return 0;
		}

		int start = 0;
		while (data.length > 1) {
			if (data[data.length / 2] == value) {
				return data.length / 2 + start;
			} else {
				if (data[data.length / 2] > value) {
					data = copy(data, 0, data.length / 2);
				} else {
					start += data.length / 2;
					data = copy(data, data.length / 2, data.length);
				}
			}
		}

		return -1;
	}

	private static int[] copy(int[] arr, int start, int end) {
		int[] result = new int[end - start];
		for (int i = start, j = 0; i < end; i++, j++) {
			result[j] = arr[i];
		}
		return result;
	}

	// возвращает наименьший индекс элемента, строго большего value
	// или -1, если такого нет
	public static int indexOfHigher(int[] data, int value) {
		int result = -1;

		if (data[data.length - 1] < value) {
			return -1;
		}

		int start = 0;
		while (data.length > 1) {
			if (data[data.length / 2] > value) {
				data = copy(data, 0, data.length / 2);
			} else {
				start += data.length / 2;
				data = copy(data, data.length / 2, data.length);
			}
			result = data.length / 2 + start + 1;
		}

		return result;
	}

	// возвращает наибольший индекс элемента, строго меньшего value
	// или -1, если такого нет
	public static int indexOfLower(int[] data, int value) {
		int result = -1;

		if (indexOf(data, value) != -1) {
			return indexOf(data, value) - 1;
		}

		if (data[0] > value) {
			return -1;
		}

		int start = 0;
		while (data.length > 1) {
			if (data[data.length / 2] > value) {
				data = copy(data, 0, data.length / 2);
			} else {
				start += data.length / 2;
				data = copy(data, data.length / 2, data.length);
			}
			result = data.length / 2 + start;
		}

		return result;
	}

	// и такие же методы для списков (по сути копия кода
	// с разницей только в способе обращения к элементам)
	public static <T extends Comparable<? super T>> int indexOf(List<T> data, T value) {
		if (data.size() == 1) {
			return 0;
		} else if (data.size() == 0) {
			return -1;
		}

		if (data.get(0).compareTo(value) == 0) {
			return 0;
		}

		int start = 0;
		while (data.size() > 1) {
			if (data.get(data.size() / 2).compareTo(value) == 0) {
				return data.size() / 2 + start;
			} else {
				if ((data.get(data.size() / 2)).compareTo(value) > 0) {
					data = copy(data, 0, data.size() / 2);
				} else {
					start += data.size() / 2;
					data = copy(data, data.size() / 2, data.size());
				}
			}
		}

		return -1;
	}

	private static <T> List<T> copy(List<T> arr, int start, int end) {
		List<T> result = new ArrayList<>();
		for (int i = start; i < end; i++) {
			result.add(arr.get(i));
		}
		return result;
	}

	public static <T extends Comparable<? super T>> int indexOfHigher(List<T> data, T value) {
		int result = -1;

		if (data.get(data.size() - 1).compareTo(value) < 0) {
			return -1;
		}

		int start = 0;
		while (data.size() > 1) {
			if (data.get(data.size() / 2).compareTo(value) > 0) {
				data = copy(data, 0, data.size() / 2);
			} else {
				start += data.size() / 2;
				data = copy(data, data.size() / 2, data.size());
			}
			result = data.size() / 2 + start + 1;
		}

		return result;
	}

	public static <T extends Comparable<? super T>> int indexOfLower(List<T> data, T value) {
		int result = -1;

		if (indexOf(data, value) != -1) {
			return indexOf(data, value) - 1;
		}

		if (data.get(0).compareTo(value) > 0) {
			return -1;
		}

		int start = 0;
		while (data.size() > 1) {
			if (data.get(data.size() / 2).compareTo(value) > 0) {
				data = copy(data, 0, data.size() / 2);
			} else {
				start += data.size() / 2;
				data = copy(data, data.size() / 2, data.size());
			}
			result = data.size() / 2 + start;
		}

		return result;
	}

}
