package LogicLayer;

public interface Scalar {
	
	public Scalar add(Scalar s);
	public Scalar mul(Scalar s);
	public Scalar pow(int exponent);
	public Scalar neg();
	public Scalar mul(int n);
	public boolean equals(Scalar s);
	public boolean isPostive();

}
