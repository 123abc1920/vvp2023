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
}
