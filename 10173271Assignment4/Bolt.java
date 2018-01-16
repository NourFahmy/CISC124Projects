import java.io.Serializable;
public class Bolt extends Fastener implements Serializable {
	/**This class checks the length of the bolt and the thread value, 
	 * if material, thread price or size of unit is illegal it catches the error in the base class
	 * finish is checked in Cariage bolt
	 */
	private static final long serialVersionUID = -7523023999752172077L;
	private double lengthbolt;
	private String thread;
	
	public Bolt(double length, String threadbolt, String materialbolt,
			String finishbolt, double pricebolt, int sizebolt) throws IllegalFastener{
		
		super(materialbolt, finishbolt, pricebolt, sizebolt);
		checkValidThreadValue(threadbolt);
		checkLength(length);
		thread = threadbolt;
		lengthbolt = length;
		
	}
	private void checkLength(double length) throws IllegalFastener {
		if (length < 0.5) {
			throw new IllegalFastener("Illegal fasteners");
		}
		else if (length >= 0.5 && length <= 6) {
			if ((length * 100) % 25 != 0 ) {
				throw new IllegalFastener("Illegal fastener length.");
			}
		}
		else if (length > 6 && length < 11 ) {
			if ((length * 100) % 50 != 0 ) {
				throw new IllegalFastener("Illegal length");
			}
		}
		else if (length >= 11 && length <= 20 ) {
			if ((length * 10) % 10 != 0 ) {
				throw new IllegalFastener("Illegal length");
			}
		}
		else if (length > 20) {
			throw new IllegalFastener("Illegal length.");
		}
	}
	@Override
	public String toString() {
		return lengthbolt + "\" long, " + thread +" thread, "+ super.toString() ;
	}
	
}
