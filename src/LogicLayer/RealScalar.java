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
		if(s.length() == 0)this.value = 1.0;
		else this.value =Double.parseDouble(s);

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
		if(exponent == 0) {
			return new RealScalar(1.0);
			}
		RealScalar output = new RealScalar(value);
		if(exponent == 1)return output.mul(exponent);
		if(exponent % 2 == 0) {
			RealScalar temp =(RealScalar) output.pow(exponent/2);
			output =  (RealScalar)temp.mul(temp);
		}
		else output = (RealScalar) output.mul(output.pow(exponent-1));
		return output;
	}

	@Override
	public Scalar neg() {
		RealScalar newS = new RealScalar(value * (-1));
		return newS;
	}

	@Override
	public boolean equals(Object s) {
		return value.equals(((RealScalar)s).value) ;
	}
	
	public boolean isPostive() {
		return value > 0;
	}
	
	public boolean isZero() {
		//coefficients between -0.0005 and +0.0005 turn to zero
		//when round to the third decimal place
		return (value<0.0005 & value>-0.0005);
	}
	public boolean isOne() {
		return (value<1.0005 & value>=0.995);
	}
	public char getField() { return 'R';   }
	
	public String toString() {
		Double d = value;
		d = (d * 1000);
		d = (double) d.intValue();
		d =  d / 1000;
		if (d % 1 == 0)return  "" + d.intValue();
		return  "" + d;
	}

	
}
