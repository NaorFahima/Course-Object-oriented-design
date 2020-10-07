package Task_3;

public class FamilyPizza extends Pizza {

	public FamilyPizza() {
		super("Family Pizza",500,35);
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
