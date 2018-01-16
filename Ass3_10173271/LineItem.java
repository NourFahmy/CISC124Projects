//Nour Moustafa-Fahmy 10173271
//LineItem Object, has two attributes: pizza and numPizza
//pizza attribute is instance of pizza object, legality is ensured through pizza class
//numPizza is number of pizzas that fit the same description of pizza instance 
//class also calulcates total cost of pizzas.
// 

import java.io.Serializable;


public class LineItem implements Comparable<LineItem>, Serializable {
	
	private static final long serialVersionUID = -4626429135670864791L;
	Pizza pizza;
	private int numPizza;
	/**
	 * 
	 * @param pizza object
	 * @throws IllegalPizza when pizza is null
	 * @return lineitem of ONE pizza object if it's legal
	 */
	public LineItem(Pizza pizza1) throws IllegalPizza {
		if (pizza1 == null) {
			throw new IllegalPizza("Illegal Pizza, cannot enter null");
		}
		this.numPizza = 1;
		this.pizza = pizza1; 
	}
	/**
	 * 
	 * @param number of pizzas and pizza object
	 * @return lineItem of user inputted number of pizzas and a legal pizza object
	 * @throws IllegalPizza if pizza is null or if number of pizzas is out of bounds
	 */
	public LineItem(int numPizzas, Pizza pizza1) throws IllegalPizza { //are my constructors okay?
		if (pizza1 == null) {
			throw new IllegalPizza("Illegal Pizza, cannot enter null");
		}
		if (numPizzas < 1 || numPizzas > 100) {
			throw new IllegalPizza("Illegal amount of pizzas. Stay between 1 and 100 inclusive, please.");
		}
		this.numPizza = numPizzas;
		this.pizza = pizza1;
	}
	/**
	 * @param none
	 * @return LineItem Pizza attribute instance
	 */
	 public Pizza getPizza() {
		 return this.pizza;
	 }
	 /**
	  * @param none
	  * @return LineItem numPizza attribute instance
	  */
	 public int getNumber() {
		 return this.numPizza;
	 }
	 /**
	  * @param none, accessed through instantiation
	  * @return cost of total number of pizzas of a particular description
	  */
	 public double getCost() {
		 double cost = numPizza * this.pizza.getCost();
		 if (numPizza > 9 & numPizza < 21) {
			 cost = cost * 0.90;
		 }
		 if (numPizza > 21) {
			 cost = cost * 0.85;
		 }
		 return cost;
	 }
	 /**
	  * 
	  * @param numPizzas
	  * @throws IllegalPizza if desired number of pizzas is out of bounds
	  * @return sets numPizza instance of LineItem to desired number of pizzas
	  */
	 public void setNumber(int numPizzas) throws IllegalPizza {
		 if (numPizzas < 1 | numPizzas > 100) {
				throw new IllegalPizza("Illegal amount of pizzas, stay between 1 and 100 inclusive.");
			}
		 this.numPizza = numPizzas;
	 }
/**
 * @param non
 * @return string of number of pizzas and its descrption and cost
 */
	@Override
	public String toString() {
		String str;
		if (numPizza < 10) {
		str =  " "+numPizza + " " + this.pizza.toString();
		}
		else {
			str = numPizza + " " +this.pizza.toString();
		}
		return str;
	}
	/**
	 * @param LineITem object
	 * @return 1 (if parameter is more expensive than lineItem instance), -1 (the opposite case of 1), or 0 (the difference in cost between the two pizzas is negligble) 
	 */
	public int compareTo(LineItem lineitem) {
		if (Math.abs(this.getCost() - lineitem.getCost()) < 1) {
			return 0;
		}
		if (this.getCost() > lineitem.getCost() ) {
			return -1;
		}
		return 1;
	}
}
