package Task_3;

public class Mushrooms extends Decorator {

	public Mushrooms(Component component) {
		super(component);
	}
	
	public double getTotal() {
		return (super.getTotal()+ADDITION_PAY);
	}
	@Override
	public Pizza getPizza() {
		return super.getPizza();
	}

}


