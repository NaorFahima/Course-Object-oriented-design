package Task_3;

public class PersonalPizza extends Pizza {

	public PersonalPizza() {
		super("Personal Pizza",300,20);
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
