package LogicLayer;

public interface Scalar {
	
	public Scalar add(Scalar s);
	public Scalar mul(Scalar s);
	public Scalar mul(int n);
	public Scalar pow(int exponent);
	public Scalar neg();
	public boolean isPostive();
	public boolean isZero();
	public boolean isOne();
	boolean equals(Scalar s);
	public char getField();

}
