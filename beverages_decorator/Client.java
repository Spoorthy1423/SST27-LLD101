package beverages_decorator;

public class Client {

	public static void main(String[] args) {
		Beverage coffee = new Cappuccino();
        System.out.println("Coffee");
		System.out.println(coffee.cost());

		Beverage latte = new Latte();
		System.out.println("Latte");
		System.out.println(latte.cost());

		Beverage milkCoffee = new Milk(new Cappuccino());
		System.out.println("Cappuccino + Milk");
		System.out.println(milkCoffee.cost());

		Beverage sweetMilkLatte = new Sugar(new Milk(new Latte()));
		System.out.println("Latte + Milk + Sugar");
		System.out.println(sweetMilkLatte.cost());
	}

}