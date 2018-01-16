import java.io.Serializable;
public class InnerThreaded extends Fastener implements Serializable {
	
	/**Checks for thread value in this class
	 * otherwise all other attributes are checked for legality in the parent class Fasteners
	 */
	private static final long serialVersionUID = 3993839261847588467L;
	private String thread;
	
	public InnerThreaded(String threadunit, String materialunit, String finishunit,
			double priceunit, int unitsize) throws IllegalFastener {
		
		super(materialunit, finishunit, priceunit,  unitsize);
		checkValidThreadValue(threadunit); //calls public metod in Fastener which checks for legality of thread diamerate values
		thread = threadunit;
	}

	@Override
	public String toString() {
		//calls to string in fastener which provides string for material
		// finish size and price since theyre all private attributes in parent class
		return thread + ", thread, " + super.toString();
	}
	
}
