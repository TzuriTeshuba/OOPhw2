package LogicLayer;

public class Main {

	public static void main(String[] args) {
		RationalScalar myDick1 = new RationalScalar(-1,2);
		System.out.println(myDick1);
		RationalScalar myDick2 =(RationalScalar) myDick1.add(myDick1);
		System.out.println(myDick2);
		
		RealScalar zurysDick1 = new RealScalar(213.000001);
		System.out.println(zurysDick1);
		System.out.println(zurysDick1.getValue());
	}

}
