package application;

import java.io.Serializable;

import application.IllegalPizza;

//import IllegalPizza;

public class Pizza implements Serializable{
	private static final long serialVersionUID = 9022214213404860367L;
	final private String size;
	final private String cheese;
	final private String pepperoni;
	final private String mushrooms;

/**
 * @param default constructor, sets pizza to small cheese pizza with single pepperoni.
 */
	public Pizza() {
			this.size = "small";
			this.cheese = "single";
			this.pepperoni = "single";
			this.mushrooms = "none";
		}
	/**
	 * 
	 * @param size, must be small medium or large
	 * @param cheese must be single, double or triple
	 * @param mushrooms must be none single or double
	 * @param pepperoni must be none single or double
	 * @throws IllegalPizza
	 */
	public Pizza(String size, String cheese,String mushrooms,  String pepperoni) throws IllegalPizza {
		if (cheese == null || mushrooms == null || pepperoni == null || size == null) {
			throw new IllegalPizza("Cannot enter null.");
		}
		size = size.toLowerCase();
		cheese = cheese.toLowerCase();
		pepperoni = pepperoni.toLowerCase();
		mushrooms = mushrooms.toLowerCase();
		if (!size.equals("small") && !size.equals("medium") && !size.equals("large")) {
			throw new IllegalPizza("You chose an illegal size.");
		}
		if (!cheese.equalsIgnoreCase("single") && !cheese.equalsIgnoreCase("double") && !cheese.equalsIgnoreCase("triple")) {
			throw new IllegalPizza("You chose an illegal selection for cheese toppings, we will default to single cheese.");
		}
		if (!pepperoni.equalsIgnoreCase("none") && !pepperoni.equalsIgnoreCase("single") && !pepperoni.equalsIgnoreCase("double")) {
			throw new IllegalPizza("You have made an illegal pepperoni selection, we will default to no pepperoni.");
		}
		if (!mushrooms.equalsIgnoreCase("single") && !mushrooms.equalsIgnoreCase("double")//
				&& !mushrooms.equalsIgnoreCase("none")) {
			throw new IllegalPizza("You have made an illegal mushroom selection, we will default to mushrooms.");
		}
		if (pepperoni.equalsIgnoreCase("none") && !mushrooms.equalsIgnoreCase("none")) {
			throw new IllegalPizza("You cannot have mushrooms without pepperoni.");
		}

		this.size=size;
		this.cheese=cheese;
		this.pepperoni=pepperoni;
		this.mushrooms=mushrooms;
	}
	/**
	 * @param none. is instantiated with pizza object.
	 * @return Price of toppings
	 */
	public double checkPriceofToppings() { 
		double cost = 0;
		if (pepperoni.equalsIgnoreCase("single")) {
			cost += 1.50;
		}
		else if (pepperoni.equalsIgnoreCase("double")) {
			cost += 3;
		}
		if (cheese.equalsIgnoreCase("double")) {
			cost += 1.50;
		}
		if (cheese.equalsIgnoreCase("triple")) {
			cost += 3;
		}
		if (mushrooms.equalsIgnoreCase("single")) {
			cost += 1.50;
		}
		if (mushrooms.equalsIgnoreCase("double")) {
			cost += 3;
		}
		return cost;
	}
	/**
	 * @param no parameters. accessed through instance of Pizza object.
	 * @return cost of pizza, which is dependent on its size, and the number of toppings (price of toppings can be referred to in checkPriceToppings) .
	 */
	public double getCost() {
		double cost = 0;
		if (size.equalsIgnoreCase("small")) {
			cost += 7;
		}
		if (size.equalsIgnoreCase("medium")) {
			cost += 9;
		}
		if (size.equalsIgnoreCase("large")) {
			cost += 11;
		}
		cost += checkPriceofToppings();
		return cost;
	}
/**
 * @param object, supposed to be a pizza object.
 * @return boolean based on equality of object passed through parameter and instance of pizza.
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (cheese == null) {
			if (other.cheese != null)
				return false;
		} else if (!cheese.equals(other.cheese))
			return false;
		if (mushrooms == null) {
			if (other.mushrooms != null)
				return false;
		} else if (!mushrooms.equals(other.mushrooms))
			return false;
		if (pepperoni == null) {
			if (other.pepperoni != null)
				return false;
		} else if (!pepperoni.equals(other.pepperoni))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	@Override
	/** 
	 * @param No parameters. Accessed through instance of pizza object.
	 * @return String with pizza order description and its cost.
	 */
	public String toString() {
		String str;
		if (mushrooms.equals("none") && pepperoni.equals("none")) {
			str = size + " pizza, " + cheese + " cheese, " + "no mushrooms, no pepperoni. Cost: $" + String.format("%.2f", getCost()) + " each." ;
			return str;
		}
		if (mushrooms.equals("none")) {
			str = size + " pizza, " + cheese + " cheese, " + "no mushrooms, " + pepperoni + " pepperoni. Cost: $" + String.format("%.2f", getCost())+" each." ;
			return str;
		}
		if (pepperoni.equals("none")) {
			str = size + " pizza, " + cheese + " cheese, " + mushrooms+ " mushrooms, no pepperoni. Cost: $" + String.format("%.2f", getCost()) +" each.";
			return str;
		}
		str = size + " pizza, " + cheese + " cheese, " + mushrooms+ " mushrooms, " + pepperoni+ " pepperoni. Cost: $" + String.format("%.2f", getCost())+" each." ;
		return str;
	}
	/**
     * Returns a copy of the of the current Pizza object.
     * @return A copy of the current Pizza object.
     */
    @Override
	public Pizza clone() {
	        Pizza pizzaCopy = null;
	        try {
	            pizzaCopy = new Pizza(size, cheese, mushrooms, pepperoni);
	        } catch (IllegalPizza e) {
	            // Should never get here!
	            return null;
	        } // end try/catch
	        return pizzaCopy;
	} // end clone
    public static void main(String[] args) throws IllegalPizza {
    Pizza pizza1 = new Pizza("large", null, "single", "double");
    System.out.println(pizza1.clone());
    }
}

