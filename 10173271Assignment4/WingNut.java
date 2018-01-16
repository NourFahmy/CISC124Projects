
import java.io.Serializable; 
public class WingNut extends InnerThreaded implements Serializable {
	
	/**
	 * creates a concrete class of object wingnut
	 * checks for finish values (since finish values for innerthreaded are shared by all classes
	 * I called the public method in FAstener to check for legality)
	 */
	private static final long serialVersionUID = -8180467010041757048L;

	public WingNut(String threadunit, String materialunit, String finishunit,
			double priceunit, int unitsize) throws IllegalFastener {
		
		super(threadunit, materialunit, finishunit, priceunit, unitsize);//calls constructor in innterthreaded 
		//which checks for legality of htread vlaues which then calls 
		//construcor in fastener which checks legality of other values
		checkValidFinishValue(finishunit, materialunit);//public method in fastener checks 
		//egality of finish value
	}

	@Override
	public String toString() {
		//calls tostring which provides string of thread in innerthreaded which calls to string in fastener which provides string for material
		// finish size and price sinze theyre all private attributes in parent classes
		return "Wing Nut " + super.toString();
	}
	

}

