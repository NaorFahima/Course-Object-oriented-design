package Task_3; // Naor Fahima 315783563

public class Q2 {

	public static void main(String[] args) {
		//Make 3 pizzas
		Pizza Pizza_M=new PersonalPizza();
		Pizza Pizza_L=new FamilyPizza();
		Pizza Pizza_XL=new HugePizza();
		
		//Show the prices
		System.out.println(Pizza_M.getName()+" : "+Pizza_M.getTotal());
		System.out.println(Pizza_L.getName()+" : "+Pizza_L.getTotal());
		System.out.println(Pizza_XL.getName()+" : "+Pizza_XL.getTotal());
		
		//Put toppings on the pizza
		Component c1= new Bulgarit(new Tomatos(Pizza_M)) ;
		Component c2= new Tomatos(new Mushrooms(Pizza_L));
		Component c3= new Mushrooms(new Olives(Pizza_XL));
		
		//Print the order
		System.out.println(c1.getPizza().getName()+" with Tomatos and Bulgarit: "+c1.getTotal());
		System.out.println(c2.getPizza().getName()+" with Mushrooms and Tomatos: "+c2.getTotal());
		System.out.println(c3.getPizza().getName()+" with Olives and Mushrooms: "+c3.getTotal());



	}

}
