package LogicLayer;

public class Polyterm  implements Comparable<Polyterm>{


	public Scalar getCoeff() {
		return coeff;
	}

	public void setCoeff(Scalar coeff) {
		coeff = coeff;
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
		return coeff.toString() + "X^" + exp;
	}

	@Override
	public int compareTo(Polyterm poly) {
		return 1;
	}



}
