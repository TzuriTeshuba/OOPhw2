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
		this.value = value;		

	}
	
	public RealScalar(String s) {
		this(Double.parseDouble(s));
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
	
	
	public Scalar mul(int n) {
		return new RealScalar(value * n);
	}

	@Override
	public Scalar pow(int exponent) {
		RealScalar output = new RealScalar(value);
		if(exponent % 2 == 0) {
			RealScalar temp =(RealScalar) output.pow(exponent/2);
			output =  (RealScalar)temp.mul(temp);
		}
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
	
	public boolean isPostive() {
		return value >= 0;
	}
	
	public String toString() {
		Double d = value;
		d = (d * 1000);
		d = (double) d.intValue();
		d =  d / 1000;
		if (d % 1 == 0)return  "" + d.intValue();
		return  "" + d;
	}

	
}
