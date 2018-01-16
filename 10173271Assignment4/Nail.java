import java.io.Serializable;
public class Nail extends Fastener implements Serializable {
	/**this class constructs a Nail object with attrubites finish material gauge
	 * size length price unitsize but does not check for legality
	 * the parent class or the child class checks for it depending ont he attrubute
	 */
	private static final long serialVersionUID = -4224570054585658523L;
	//size, length, gauge, finish, price/unit, unit size
	private double gauge;
	private String size;
	private double length;
	
	public Nail(String unitsize, double lengthofobject, double gaugeofobj, String materialofobject, String finishofobj,
			double priceofobj, int unit ) throws IllegalFastener{
		super("Steel", finishofobj, priceofobj, unit);
		size = unitsize; //since Nail has no specified size or lengths or aguges
		gauge = gaugeofobj; //child classes will check for legality and throw an error if needed
		length = lengthofobject; //as well as finish values
	}

	@Override
	public String toString() {
		/** calls toSTring in FAsteners for finish material price and unit size
		 * creates string forsize of nail, length of nail and guage
		 */
		return  size + " size, " + length + "\" length, " + gauge + " gauge, " + super.toString() ;
	}
	
}
