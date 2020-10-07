package Task_3;

public class Olives extends Decorator {

	public Olives(Component component) {
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


