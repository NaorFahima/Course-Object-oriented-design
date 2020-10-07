package Task_3;

public abstract class Pizza implements Component {
	
	protected String name;
	protected int numOfCalories;
	protected double price;
	
	public Pizza (String name,int numOfCalories,double price) {
		this.name=name;
		this.numOfCalories=numOfCalories;
		this.price=price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumOfCalories() {
		return numOfCalories;
	}
	public void setNumOfCalories(int numOfCalories) {
		this.numOfCalories = numOfCalories;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


}
