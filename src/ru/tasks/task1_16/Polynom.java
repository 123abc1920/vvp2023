package ru.tasks.task1_16;

import java.util.ArrayList;
import java.util.List;

public class Polynom {
	private List<Point> points = new ArrayList<>();

	public Polynom() {

	}

	public Polynom(List<Point> points) {
		this.points = points;
	}

	public List<Point> getTops() {
		return this.points;
	}

	public void setTops(List<Point> points) {
		this.points = points;
	}

	public double findS() {
		double S = 0;

		for (int i = 0; i < this.points.size() - 1; i++) {
			S += this.points.get(i).getX() * this.points.get(i + 1).getY()
					- this.points.get(i + 1).getX() * this.points.get(i).getY();
		}

		S += this.points.get(this.points.size() - 1).getX() * this.points.get(0).getY()
				- this.points.get(0).getX() * this.points.get(this.points.size() - 1).getY();

		return Math.abs(S * 0.5);
	}

	public double findP() {
		double P = 0;

		int i = 0, p = 1;
		while (i < this.points.size()) {
			if (p == this.points.size()) {
				p = 0;
			}
			P += Math.sqrt(Math.pow(this.points.get(p).getX() - this.points.get(i).getX(), 2)
					+ Math.pow(this.points.get(p).getY() - this.points.get(i).getY(), 2));
			i++;
			p++;
		}

		return P;
	}
}
