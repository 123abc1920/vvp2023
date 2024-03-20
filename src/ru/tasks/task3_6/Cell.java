package ru.tasks.task3_6;

public class Cell {
	private Cell[] tops = new Cell[4];
	private int num;

	public enum G {
		TOP(0), BOTTOM(1), RIGHT(2), LEFT(3);

		private final int i;

		G(int i) {
			this.i = i;
		}

		public int getI() {
			return this.i;
		}
	}

	public Cell() {
		for (int i = 0; i < 4; i++) {
			tops[i] = null;
		}
	}

	public void addTop(Cell a, G g) {
		tops[g.i] = a;
	}

	public Cell[] getTops() {
		return this.tops;
	}

	public Cell getOneTop(G g) {
		return this.tops[g.i];
	}

	public void setNum(int a) {
		this.num = a;
	}

	public int getNum() {
		return this.num;
	}
}
