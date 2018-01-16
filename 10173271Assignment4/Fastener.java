import java.io.Serializable;
public class Fastener implements Serializable {

	/**By Nour Moustafa-Fahmy 10173271
	 * 
	 */
	private static final long serialVersionUID = -7021956658306458222L;
	private int unitSize;
	private double unitPrice;
	private String finish;
	private String material;
	
//// length, thread,  material, finish, head, drive, point, price/unit, unit size
	public Fastener ( String materialofobject, String finishofobj, double priceofobj, int unit )
		throws IllegalFastener{
		checkMaterialValue(materialofobject); //checks material for legal values
		checkLegality(unit, priceofobj, materialofobject, finishofobj); //checks for legal values of those attributes
		unitSize = unit;
		unitPrice = priceofobj;
		material = materialofobject;
		finish = finishofobj; //specific values of finish are checked for legality in the child classes
		
	}

	public double getOrderCost(int unitSize) {
		return unitSize * unitPrice;
	}
	private void checkLegality(int unit, double priceofobj, String materialofobject, String finishofobj) throws IllegalFastener {
		if (unit < 1 || unit > 10000) { //checks for appropriate unit size, null types, etc
			throw new IllegalFastener("Illegal unit size");
		}
		if (unit != 1 && unit % 5 != 0) {
			throw new IllegalFastener("Illegal unit size");
		}
		
		if (unitSize > 1) {
			if (priceofobj < 1) {
				throw new IllegalFastener("Illegal Price.");
			}
		}
		if (materialofobject == null || finishofobj == null) {
			throw new IllegalFastener("Illegal type for finish");
		}
	//	if (!(unit) || !(priceofobj instanceof double) ) {
		//	throw new IllegalFastener("Illegal type");
			
	//	}
	}
	@Override
	public String toString() {
		//pretty selfexplanatory what this does
		String cost = String.format("%.4f", getOrderCost(unitSize));
		String str = material + ", with a " + finish + ". " + unitSize + " in a unit, $" + cost
				+ " per unit.";
		return str;
	}
	public void checkMaterialValue(String materialofobject) throws IllegalFastener {
		//checks for legal material values
		if (!materialofobject.equals("Steel") && !materialofobject.equalsIgnoreCase("Brass") &&
				!materialofobject.equals("Stainless Steel")) {
			throw new IllegalFastener("Illegal material.");
		}
	}
	public void checkValidThreadValue(String thread) throws IllegalFastener{
		//checls for legal threadvalues
		String[] threadDiameters = {"#8-13", "#8-15", "#8-32","#10-13","#10-24", "#10-32",
				"1/4-20", "5/16-18", "3/8-16", "7/16-14", "1/2-13", "5/8-11", "3/4-10"};
		if (thread == null || ! (thread instanceof String)) {
			throw new IllegalFastener("Illegal type for thread dimater");
		}
		for (int i = 0; i < threadDiameters.length; i++) {
			if (thread.equals(threadDiameters[i])) {
				break;
			}
			if (i== (threadDiameters.length - 1)) {
				throw new IllegalFastener("Illegal thread diameter");
			}
		}
	}
	public void checkValidFinishValue(String finishValue, String materialValue) throws IllegalFastener{
		//checks for legal finishes depending on the material otherwise it throws an eror
		//checks for finishes that all child classes share
		String[] finish = {"Chrome", "Hot Dipped Galvanized", "Plain", "Zinc", "Yellow Zinc"};
		if (materialValue.equals("Steel")) {
			for (int i = 0; i < 5; i ++){
				if (finishValue.equals(finish[i])) {
					break;
				}
				if (i== 4) {//reaches the end of the array and it clearly is not a specified legal value
					throw new IllegalFastener("Illegal Finish for steel!");
				}
			}
		}
		if (materialValue.equals("Stainless Steel") || materialValue.equalsIgnoreCase("Brass")) {
			if (!finishValue.equalsIgnoreCase("Plain")) {
				throw new IllegalFastener("Illegal finish for steel!");
			}
		}
	}
}


