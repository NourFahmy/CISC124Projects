import java.io.Serializable;


public class CarriageBolt extends Bolt implements Serializable {
	
	/** Carriagebolt here checks for legal finish values, throws errors if needed
	 * And also generates string
	 */
	private static final long serialVersionUID = -6907073035837620938L;
	
	public CarriageBolt(double lengthbolt, String threadbolt, String materialbolt,
			String finishbolt, double pricebolt, int sizebolt) throws IllegalFastener {
		
		super(lengthbolt, threadbolt, materialbolt, finishbolt, pricebolt, sizebolt); //calls Bolt class which validates thread, which calls Fastener which validates the legality of the other values
		checkValidFinishValue(finishbolt, materialbolt); //calls public method from fasteners, 
		//checks to make sure it has legal values specified that are shared by all otherwise it throws and error
	}
	@Override
	public String toString() {
		return "CarriageBolt " + super.toString() ; //calls toSTring in bolt which in turn calls toString in baase class
	}


	
	
	
	
}


