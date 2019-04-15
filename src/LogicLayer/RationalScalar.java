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


	private int numer;
	private int denom;
	
	public RationalScalar(int numer, int denom) {
		this.numer = numer;
		this.denom = denom;
		this.simplify();
	}
	public RationalScalar(double input) {
		//check this constructor
		//left for work, not sure if complete
		double newNumer = input;
		this.denom = 1;
		while(input%1 != 0) {
			newNumer = newNumer*10;
			denom = denom*10;
		}
		numer = (int)newNumer;
		this.simplify();
	}
	
	@Override
	public Scalar add(Scalar s) {
		
		RationalScalar newS = (RationalScalar)s;
		int newNumer = (numer*newS.denom) + (denom*newS.numer);
		int newDenom = denom*newS.denom;
		
		RationalScalar output = new RationalScalar(newNumer, newDenom);
		output.simplify();
		return output;
		
	}

	@Override
	public Scalar mul(Scalar s) {
		
		RationalScalar newS = (RationalScalar)s;
		int newNumer = numer * newS.numer;
		int newDenom = denom*newS.denom;
		RationalScalar output = new RationalScalar(newNumer, newDenom);
		output.simplify();
		return output;
	}

	@Override
	public Scalar pow(int exponent) {
		RationalScalar output;
		RationalScalar copy = new RationalScalar(numer, denom);
		if(exponent == 0) {return new RationalScalar(1,1);}
		else if(exponent == 1) {return new RationalScalar(numer, denom);}
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
		return new RationalScalar(numer*(-1), denom);
	}

	@Override
	public boolean equals(Scalar s) {
		//because we always simplify, it is sufficient to just check the numer, denom, and sign
		RationalScalar newS = (RationalScalar)s;
		return(numer==newS.numer & denom==newS.denom);
	}
	
	private void simplify() {
		int divideBy = gcd(numer, denom);
		numer = numer/divideBy;
		denom = denom/divideBy;
	}
	
 	private int gcd(int a, int b) { //shitty algorithm!! change ASAP!!
 		//do with primes iterator from previous work
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
 	
 	public String toString() {
 		if(denom == 1)return "" + numer ;
 		return numer + "/" + denom;
 		
 	}
 	

}
