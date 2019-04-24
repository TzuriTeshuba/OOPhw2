package LogicLayer;

public class tests {
	public static void main(String []args) {
		Polynomial poly1 = new Polynomial("2" , 'R');
		Polynomial poly2 = new Polynomial("2" , 'R');
		System.out.println(poly1.equals(poly2));
		System.out.println(poly1.mul(poly2));

	}

}
