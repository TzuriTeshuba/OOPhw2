package LogicLayer;

public interface Scalar {
	
	public Scalar add(Scalar s);
	public Scalar mul(Scalar s);
	public Scalar pow(int exponent);
	public Scalar neg();
	public boolean equals(Scalar s);

}
