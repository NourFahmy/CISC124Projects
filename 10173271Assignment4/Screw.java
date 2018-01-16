import java.io.Serializable;

public class Screw extends Fastener implements Serializable{
	
	/** This abstract class creates object of type screw
	 * all objects of type scew have the same values of head drive length,
	 * thread, and finish values
	 * so those attributes are checked in this constructor 
	 */
	private static final long serialVersionUID = 5886539425759103621L;
	private double lengthScrew;
	private String thread;
	private String head;
	private String drive;
	
	
	public Screw (double length, String threadscrew, String materialscrew,
			String finishofobj, String headScrew, String driveScrew, 
			double pricescrew, int sizescrew) throws IllegalFastener {
		super(materialscrew, finishofobj, pricescrew, sizescrew);
		checkValidThreadValue(threadscrew); //public method in FAstener class
		checkLength(length);
		checkHeadandDrive(headScrew, driveScrew);
		checkFinish(materialscrew, finishofobj);
		head = headScrew;
		drive = driveScrew;
		lengthScrew = length;
		thread = threadscrew;
			
	}
	private void checkFinish(String materialscrew, String finishofobj) throws IllegalFastener {
		//checks for legal values of finishes of steel screws since they have special values
		//and checks for legal values of stainless steel and brass
		String[] additionalFinishes = {"Chrome", "Hot Dipped Glavanized", "Plain", "Yellow Zinc",
				"Zinc", "Black Phosphate", "ACQ 1000 Hour", "Lubricated"};
		if (materialscrew.equals("Steel")) {
			for (int i= 0; i <= (additionalFinishes.length); i++) {
				if (finishofobj.equals(additionalFinishes[i])) {
					break;
				}
				if (i== additionalFinishes.length) { //if it reached this point obviously the finish is not in the arry
					throw new IllegalFastener("Illegal finish for steel screw!");
				}
			}
		}
		if (materialscrew.equals("Stainless Steel") || materialscrew.equalsIgnoreCase("Brass")) {
			if (!finishofobj.equalsIgnoreCase("Plain")) {
				throw new IllegalFastener("Illegal finish for steel!");
			}
		}
	}
	private void checkHeadandDrive(String headScrew, String driveScrew) throws IllegalFastener {
		//checcks for head and drive values
		if (headScrew == null || driveScrew == null) {
			throw new IllegalFastener("Illegal type!");
		}
		if (!headScrew.equalsIgnoreCase("bugle") && !headScrew.equalsIgnoreCase("flat") &&
				!headScrew.equalsIgnoreCase("oval") && !headScrew.equalsIgnoreCase("pan") && !headScrew.equalsIgnoreCase("pan")) {
				throw new IllegalFastener("Illegal head value!");
		}
		if (!driveScrew.equals("6-Lobe") && !driveScrew.equals("Philips") &&
					!driveScrew.equals("Slotted") && !driveScrew.equals("Square")) {
				throw new IllegalFastener("Illegal drive value");
		}
	}
	
	private void checkLength(double length) throws IllegalFastener{
		//checks for legal length values
		if (length < 1/2) {
			throw new IllegalFastener("Illegal fasteners");
		}
		if (length >= 0.5 && length <= 6) {
			if ((length * 100) % 25 != 0 ) {
				throw new IllegalFastener("Illegal fastener length.");
			}
		}
		if (length > 6 && length < 11 ) {
			if ((length * 100) % 50 != 0 ) {
				throw new IllegalFastener("Illegal length");
			}
		}
		if (length >= 11 && length <= 20 ) {
			if ((length * 10) % 10 != 0 ) {
				throw new IllegalFastener("Illegal length");
			}
		}
		if (length > 20) {
			throw new IllegalFastener("Illegal length.");
		}
	}
	@Override
	public String toString() {
		return head +" head, " + drive+ " drive, " + lengthScrew + "\" long, " +thread +" thread, "+ super.toString();
	}
	
}
