package work.files.exercise;

public class Product {

	private String name;
	private double value;
	private int quantitie;

	public Product(String name, double value, int quantitie) {
		this.name = name;
		this.value = value;
		this.quantitie = quantitie;
	}

	public String getName() {
		return name;
	}

	public double getValue() {
		return value;
	}

	public int getQuantitie() {
		return quantitie;
	}

	public double getSummary () {
		return quantitie * value;
	}
}