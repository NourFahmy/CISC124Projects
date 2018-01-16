import java.io.Serializable;

public class CommonNail extends Nail implements Serializable {
/** this class checks for legal size and length values 
 * and finish values since htey're unique to common nails
	 * all other atttributes 
	 * are called through a constuctor in a parent class to check for values of legality
	 */
	private static final long serialVersionUID = -8163537233879582313L;
	
	public CommonNail(String unitsize, double lengthunit, double gaugeunit,
			String unitfinish, double priceofobj, int ordersize) throws IllegalFastener{

		super(unitsize, lengthunit, gaugeunit, "Steel", unitfinish, priceofobj, ordersize); 
		checkValidFinishValue(unitfinish, "Steel"); //legaility of finish value is checked here and throws an error if needed
		checkLengthandSize(lengthunit, unitsize); //throws an error if length or unitsize is illegal (since nail parent class shouldn't, it has no specified values)
		checkGauge(gaugeunit); //throws an error as wel if needed
	}
	
	private void checkLengthandSize(double lengthunit, String unitsize ) throws IllegalFastener {
		//checks for size and length of nail
		if (unitsize == null ) {
			throw new IllegalFastener("illegal size");
		}
		if (!unitsize.equals("6D") && !unitsize.equals("8D") && !unitsize.equals("10D")
				&& !unitsize.equals("12D") && !unitsize.equals("16D") 
				&& !unitsize.equals("60D")) {
			throw new IllegalFastener("Illegal size");
		}
		if (lengthunit != 2 && lengthunit != 2.5 && lengthunit != 3 && lengthunit != 3.25
				&& lengthunit != 3.5 && lengthunit != 6) {
			throw new IllegalFastener("Illegal length");
		}
	}
	
	public void checkGauge(double gaugeunit) throws IllegalFastener {
		if (gaugeunit != 2 && gaugeunit != 8 && gaugeunit != 9 && gaugeunit != 10.25
				&& gaugeunit != 11.5) {
			throw new IllegalFastener("Illegal gauge");
		}
	}
	
	public void checkValidFinishValue(String unitfinish, String materialunit) throws IllegalFastener {
		String[] finishoptions = {"Hot Dipped Galvanized", "Bright"};
		//checks for null types, and legal finish values (including the additonal ones)
		//, recall we don't need to check the material
		//because it's set to Steel
		if (unitfinish == null || materialunit == null ) {
			throw new IllegalFastener("Illegal material or finish");
		}
		for (int i = 0; i < 2; i++) {
			if (unitfinish.equals(finishoptions[i])) {
				break;
			}
			if (i==1) { //reaches the end of the array and it clearly is not a specified legal value
				throw new IllegalFastener("Illegal Fastener");
			}
		}
	}
	@Override
	public String toString() {
		/**calls toString in Nail class, which creates a string for length and size of nail
		 * which then calls toString in Fasteners which creates a string for everything else
		 */
		return "CommonNail " + super.toString()  ;
	}


	
}
