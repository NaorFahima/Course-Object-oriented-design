package Task_3;

public class HugePizza extends Pizza {

	public HugePizza() {
		super("Huge Pizza",600,55);
	}

	@Override
	public double getTotal() {
		return price;
	}

	@Override
	public Pizza getPizza() {
		return this;
	}

}
