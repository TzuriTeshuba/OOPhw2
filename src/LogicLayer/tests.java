package LogicLayer;

public class tests {
	public static void main(String []args) {
		Polynomial poly1 = new Polynomial("x^2+3+x" , 'Q');
		Polynomial poly2 = new Polynomial("x+x^2+3" , 'Q');
		System.out.println(poly1.equals(poly2));
		System.out.println(poly1.mul(poly2));

	}

}
