package LogicLayer;

public class Polyterm  implements Comparable<Polyterm>{


	public Scalar getCoeff() {
		return coeff;
	}

	public void setCoeff(Scalar coeff) {
		this.coeff = coeff;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	
	private Scalar coeff;
	private int exp;
	
	public Polyterm (Scalar Coeff , int exp) {
		this.coeff = Coeff;
		this.exp = exp;
	}
	public Polyterm (String pt , char field) {
		int i = 0;
		String coefSTR = "";
		while(i<pt.length() && pt.charAt(i) != 'x') {
			coefSTR = coefSTR + pt.charAt(i);
			i++;
		}
		if(coefSTR.length()==pt.length()) { exp = 0;}
		else if(coefSTR.length() == pt.length()-1) {exp = 1;}
		else {
			exp = Integer.parseInt(pt.substring(i+2));
		}
		if(coefSTR.equals("+") | coefSTR.equals("-")) coefSTR = coefSTR + "1";
		if(field == 'R') {
			this.coeff = new RealScalar(coefSTR);
		}
		else {
			this.coeff = new RationalScalar(coefSTR);
		}
		
	}
	
	public boolean canAdd(Polyterm pt) {
		return this.exp == pt.exp;
	}
	
	public Polyterm add(Polyterm pt) {
		if(!canAdd(pt))return null;
		return new Polyterm(coeff.add(pt.coeff) , exp);
	}
	
	public Polyterm mul(Polyterm pt) {
		return new Polyterm (coeff.mul(pt.coeff) , exp + pt.exp);
	}
	
	public Scalar evaluate(Scalar scalar) {	
		return scalar.pow(exp).mul(coeff) ;
	}
	public Polyterm derivate() {
		Scalar newC = coeff.mul(exp);	
		return new Polyterm(newC , exp-1);
	}
	
	public boolean equals(Polyterm pt) {
		return (exp == pt.exp & coeff.equals(pt.coeff));
	}
	public boolean isPostive() {
		return coeff.isPostive();
	}
	
	public String  toString() {
		if(exp == 0)return coeff.toString();
		else if(exp == 1)return coeff.toString() + "x";
		return coeff.toString() + "X^" + exp;
	}

	@Override
	public int compareTo(Polyterm poly) {
		return this.exp - poly.exp;
	}



}
