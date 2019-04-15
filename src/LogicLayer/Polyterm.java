package LogicLayer;

public class Polyterm {


public Scalar getCoeff() {
	return Coeff;
}

public void setCoeff(Scalar coeff) {
	Coeff = coeff;
}

public int getExp() {
	return exp;
}

public void setExp(int exp) {
	this.exp = exp;
}

	
	private Scalar Coeff;
	private int exp;
	
	public Polyterm (Scalar Coeff , int exp) {
		Coeff = Coeff;
		exp = exp;
	}
	public boolean canAdd(Polyterm pt) {
		//Change!!
		return true;
	}
	
	public Polyterm add(Polyterm pt) {
		//Change!!
		return null;
	}
	
	public Polyterm mul(Polyterm pt) {
		//Change!!
		return null;
	}
	
	public Scalar evaluate(Scalar scalar) {
		//Change!!
		return null;
	}
	public Polyterm derivate() {
		//Change!!
		return null;
	}
	
	public boolean equals(Polyterm pt) {
		//Change!!
		return true;
	}
	
	public String  toString() {
		//Change!!
		return "";
	}



}
