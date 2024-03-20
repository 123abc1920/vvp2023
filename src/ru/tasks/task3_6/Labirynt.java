package ru.tasks.task3_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.tasks.task3_6.Cell.G;

public class Labirynt {
	private List<Cell> array = new ArrayList<>();
	private int width, height, top, left;
	private Cell start;
	private Cell end;

	public Labirynt(int row, int col, int top, int left, Map<Integer, List<G>> map) {
		this.width = col;
		this.height = row;
		this.top = top;
		this.left = left;

		update(row, col, top, left, map);
	}

	public void update(int row, int col, int top, int left, Map<Integer, List<G>> map) {
		for (int i = 0; i < row * col; i++) {
			Cell cell = new Cell();
			cell.setNum(i);
			array.add(cell);
		}

		for (int j = 0; j < row; j++) {
			for (int i = 0; i < col; i++) {
				if (i != col - 1) {
					if (!map.containsKey(j * col + i)) {
						array.get(j * col + i).addTop(array.get(j * col + i + 1), G.RIGHT);
					} else {
						if (!map.get(j * col + i).contains(G.RIGHT)) {
							array.get(j * col + i).addTop(array.get(j * col + i + 1), G.RIGHT);
						}
					}
				}
				if (j != row - 1) {
					if (!map.containsKey(j * col + i)) {
						array.get(j * col + i).addTop(array.get((j + 1) * col + i), G.BOTTOM);
					} else {
						if (!map.get(j * col + i).contains(G.BOTTOM)) {
							array.get(j * col + i).addTop(array.get((j + 1) * col + i), G.BOTTOM);
						}
					}
				}
			}
		}
	}

	public void clear() {
		this.array.clear();
	}

	public List<Cell> getArray() {
		return this.array;
	}

	public int[] getSize() {
		return new int[] { this.width, this.height, this.top, this.left };
	}

	public Cell getStart() {
		return this.start;
	}

	public Cell getEnd() {
		return this.end;
	}

	public void setStart(int num) {
		this.start = this.getArray().get(num);
	}

	public void setEnd(int num) {
		this.end = this.getArray().get(num);
	}
}
