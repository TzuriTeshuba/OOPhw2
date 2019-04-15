package LogicLayer;

public class RealScalar implements Scalar{
	
	private Double value;


	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
	public RealScalar(Double value) {
		value = value;		

	}

	@Override
	public Scalar add(Scalar s) {
		RealScalar newS = (RealScalar) s;
		Double newValue  = value  + newS.value ;
		RealScalar output = new RealScalar(newValue );
		return output;
	}

	@Override
	public Scalar mul(Scalar s) {
		RealScalar newS = (RealScalar) s;
		Double newValue  = value  * newS.value ;
		RealScalar output = new RealScalar(newValue );
		return output;
	}

	@Override
	public Scalar pow(int exponent) {
		RealScalar output = new RealScalar(value);
		if(exponent % 2 == 0)output =  (RealScalar)output.pow(exponent/2).mul(output.pow(exponent/2));
		else output = (RealScalar) output.mul(output).pow(exponent-1);
		return output;
	}

	@Override
	public Scalar neg() {
		RealScalar newS = new RealScalar(value * (-1));
		return newS;
	}

	@Override
	public boolean equals(Scalar s) {
		return value.equals(((RealScalar)s).value) ;
	}

	
}
