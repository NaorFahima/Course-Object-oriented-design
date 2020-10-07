package Task_3;

public abstract class Decorator implements Component {
	
	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}
	
	public double getTotal() {
		return component.getTotal();
	}
	
	public Pizza getPizza() {
		return component.getPizza();
	}


}
