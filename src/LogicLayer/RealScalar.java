package LogicLayer;

public class RealScalar implements Scalar{
	


	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	private Double value;
	private int sign;
	
	
	public RealScalar(Double value , int sign) {
		value = value;
		sign = sign;
		

	}

	@Override
	public Scalar add(Scalar s) {
		RealScalar newS = (RealScalar) s;
		int newSign = 1;
		Double newValue  = value * sign +newS.value * newS.sign;
		if(newValue < 0 )newSign = -1;
		return RealScalar output = new RealScalar(newValue , newSign);
	}

	@Override
	public Scalar mul(Scalar s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scalar pow(Scalar s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scalar neg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Scalar s) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
