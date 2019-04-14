package LogicLayer;

public class RationalScalar implements Scalar {
	
	public int getNumer() {
		return numer;
	}
	public void setNumer(int numer) {
		this.numer = numer;
	}
	public int getDenom() {
		return denom;
	}
	public void setDenom(int denom) {
		this.denom = denom;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}

	private int numer;
	private int denom;
	private int sign;
	
	public RationalScalar(int numer, int denom, int sign) {
		this.numer = numer;
		this.denom = denom;
		this.sign = sign;
	}
	
	
	

	@Override
	public Scalar add(Scalar s) {
		
		RationalScalar newS = (RationalScalar)s;
		int newNumer = numer*newS.denom*sign + denom*newS.numer*newS.sign;
		int newDenom = denom*newS.denom;
		int newSign = 1;
		if (newNumer<0) {
			newSign = -1;
			newNumer=newNumer*(-1);
		}
		
		RationalScalar output = new RationalScalar(newNumer, newDenom, newSign );
		output.simplify();
		return output;
		
	}

	@Override
	public Scalar mul(Scalar s) {
		
		RationalScalar newS = (RationalScalar)s;
		int newNumer = numer * newS.numer;
		int newDenom = denom*newS.denom;
		int newSign = sign*newS.sign;
		RationalScalar output = new RationalScalar(newNumer, newDenom, newSign);
		output.simplify();
		return output;
	}

	@Override
	public Scalar pow(int exponent) {
		RationalScalar output;
		RationalScalar copy = new RationalScalar(numer, denom, sign);
		if(exponent == 0) {return new RationalScalar(1,1,1);}
		else if(exponent == 1) {return new RationalScalar(numer, denom, sign);}
		else if(exponent%2==0) {
			copy = (RationalScalar)pow(exponent/2);
			output = (RationalScalar) copy.mul(copy);
		}
		else {
			output = (RationalScalar) copy.mul(copy.mul(copy.pow(exponent-1)));
		}
		output.simplify();
		return output;
	}

	@Override
	public Scalar neg() {
		return new RationalScalar(numer, denom, sign * (-1));
	}

	@Override
	public boolean equals(Scalar s) {
		//because we always simplify, it is sufficient to just check the numer, denom, and sign
		RationalScalar newS = (RationalScalar)s;
		return(sign==newS.sign & numer==newS.numer & denom==newS.denom);
	}
	private void simplify() {
		int divideBy = gcd(numer, denom);
		numer = numer/divideBy;
		denom = denom/divideBy;
	}
	
 	private int gcd(int a, int b) {
		int gcd = 1;
		for(int i=2 ; i<=a && i<=b ; i++) {
			while(a%i==0 && b%i==0) {
				gcd=gcd*i;
				a=a/i;
				b=b/i;
			}
		}
		return gcd;
	}

}
