import java.io.Serializable;
public class WoodScrew extends Screw implements Serializable{
	
	/** creates concrete object of type woodscrew
	 * all of its attributes are checked in parent 
	 * classes since all screws or fasteners share those same
	 * attributes and attribute values 
	 * except for point, which it checks for here!
	 */
	private static final long serialVersionUID = 5822653680337943157L;
	private String point;
	
	public WoodScrew(double length, String threadscrew, String materialscrew,
			String finishscrew, String headScrew, String driveScrew, String pointScrew,
			double pricescrew, int sizescrew) throws IllegalFastener {
		//summary in the beginning should cover this
		super(length, threadscrew, materialscrew, finishscrew, headScrew, driveScrew, pricescrew, sizescrew);
		checkPoint(pointScrew);
		point = pointScrew;
	}
	
	private void checkPoint(String pointScrew) throws IllegalFastener{
		//checks for point legality, throws an error if needed
		if (pointScrew == null) {
			throw new IllegalFastener("illegal type!");
		}
		if (!pointScrew.equalsIgnoreCase("Doublecut") && !pointScrew.equals("Sharp") &&
				!pointScrew.equals("Type-17") && !pointScrew.equals("Type 17")) {
			throw new IllegalFastener("illegal point for woodscrew");
		}
	}
	@Override
	public String toString() {
		//calls toString in Screw which returns string of head drive and length, which 
		//calls a string in fastener which returns a string of all the other attributes except point
		return "Wood Screw, " + point + " point, " + super.toString();
	}

}
