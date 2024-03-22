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

	public Labirynt(int col, int row, int top, int left, Map<Integer, List<G>> map) {
		update(col, row, top, left, map);
	}

	public void update(int col, int row, int top, int left, Map<Integer, List<G>> map) {
		if (col != -1 || row != -1 || top != -1 || left != -1) {
			this.width = col;
			this.height = row;
			this.top = top;
			this.left = left;
		}

		for (int i = 0; i < this.height * this.width; i++) {
			Cell cell = new Cell();
			cell.setNum(i);
			array.add(cell);
		}
		
		for (int j = 0; j < this.height; j++) {
			for (int i = 0; i < this.width; i++) {
				if (i != this.width - 1) {
					if (!map.containsKey(j * this.width + i)) {
						array.get(j * this.width + i).addTop(array.get(j * this.width + i + 1), G.RIGHT);
					} else {
						if (!map.get(j * this.width + i).contains(G.RIGHT)) {
							array.get(j * this.width + i).addTop(array.get(j * this.width + i + 1), G.RIGHT);
						}
					}
				}
				if (i != 0) {
					if (!map.containsKey(j * this.width + i - 1)) {
						array.get(j * this.width + i).addTop(array.get(j * this.width + i - 1), G.LEFT);
					} else {
						if (!map.get(j * this.width + i - 1).contains(G.RIGHT)) {
							array.get(j * this.width + i).addTop(array.get(j * this.width + i - 1), G.LEFT);
						}
					}
				}
				if (j != this.height - 1) {
					if (!map.containsKey(j * this.width + i)) {
						array.get(j * this.width + i).addTop(array.get((j + 1) * this.width + i), G.BOTTOM);
					} else {
						if (!map.get(j * this.width + i).contains(G.BOTTOM)) {
							array.get(j * this.width + i).addTop(array.get((j + 1) * this.width + i), G.BOTTOM);
						}
					}
				}
				if (j != 0) {
					if (!map.containsKey((j - 1) * this.width + i)) {
						array.get(j * this.width + i).addTop(array.get((j - 1) * this.width + i), G.TOP);
					} else {
						if (!map.get((j - 1) * this.width + i).contains(G.BOTTOM)) {
							array.get(j * this.width + i).addTop(array.get((j - 1) * this.width + i), G.TOP);
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

	public void setAllNotDone() {
		for (Cell c : this.array) {
			c.setDone(false);
			c.setPrev(null);
		}
	}
}
