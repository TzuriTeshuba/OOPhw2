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
	
	public RationalScalar(String s) {
		s = s.replaceAll("/~", "/-");
		String[] components = s.split("/");
		if(components.length==1) {
			if( components[0].equals("")) {
				numer = 1;
				denom = 1;
			}
			else {
				numer=Integer.parseInt(s);
				denom=1;
			}
		}
		else {
			numer = Integer.parseInt(components[0]); 
			denom = Integer.parseInt(components[1]); 
			if( denom < 0) {
				denom = denom*(-1);
				numer = numer*(-1);
			}
			simplify();
		}
		
	}
	
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
	public Scalar mul(int n) {
		return new RationalScalar(numer * n , denom);
	}

	@Override
	public Scalar pow(int exponent) {
		if(exponent == 0) {
			return new RationalScalar(1,1);
			}
		RationalScalar output = new RationalScalar(numer , denom);
		if(exponent == 1)return output.mul(exponent);
		if(exponent % 2 == 0) {
			RationalScalar temp =(RationalScalar) output.pow(exponent/2);
			output =  (RationalScalar)temp.mul(temp);
		}
		else output = (RationalScalar) output.mul(output).pow(exponent-1);
		return output;
	}
	

	@Override
	public Scalar neg() {
		return new RationalScalar(numer*(-1), denom);
	}

	@Override
	public boolean equals(Object s) {
		//because we always simplify, it is sufficient to just check the numer, denom, and sign
		RationalScalar newS = (RationalScalar)s;
		return(numer==newS.numer & denom==newS.denom);
	}
	
	public boolean isPostive() {
		return numer > 0;
	}
	
	private void simplify() {
		int divideBy = gcd(Math.abs(numer), denom);
		numer = numer/divideBy;
		denom = denom/divideBy;
	}
	
 	private int gcd(int a, int b) { 
 		int r = a % b;
 		if(r == 0 )return b;
 		return gcd(b , r);
	}
 	public boolean isZero() {
 		return numer ==0;
 	}
 	public boolean isOne() {
 		return numer == denom;
 	}
 	public char getField() { return 'Q';   }
 	
 	
 	public String toString() {
 		if(denom == numer) return "";
 		else if(numer == denom*(-1)) return "-";
 		else if(denom == 1)return "" + numer ;
 		else return numer + "/" + denom;
 		
 	}
 	

}
