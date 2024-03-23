package ru.tasks.task4_24;

public class Product<T> implements Comparable<Product> {
	private String name = "";
	private int cost = 0;

	public Product(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Product o) {
		if (this.getName().compareTo(o.getName()) > 0) {
			return 1;
		} else if (this.getName().compareTo(o.getName()) == 0) {
			if (this.getCost() > o.getCost()) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return -1;
		}
	}
}
