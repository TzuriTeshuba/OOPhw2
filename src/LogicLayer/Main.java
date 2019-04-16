package LogicLayer;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Double.parseDouble("-3"));
		
		String s = "-30x^13+9.3x^7-2.4x^2+4-x";	
		Polynomial eladush = new Polynomial(s  , 'R');
		System.out.println(eladush);
		System.out.println(eladush.add(eladush));
		
		
		
		
		
		
//		RationalScalar zuri1 = new RationalScalar(-3 , 15);
//		RationalScalar zuri2 = new RationalScalar(4 , 43);
//		RationalScalar zuri3 = new RationalScalar(7 , 16);
//		RationalScalar zuri4 = new RationalScalar(-19, 32);
//		RationalScalar zuri5 = new RationalScalar(0 , 5);
//
//		System.out.println((RationalScalar)zuri1.add(zuri2));
//		System.out.println((RationalScalar)zuri2.add(zuri3));
//		System.out.println((RationalScalar)zuri3.add(zuri4));
//		System.out.println((RationalScalar)zuri4.add(zuri5));
//
//		System.out.println((RationalScalar)zuri1.mul(zuri2));
//		System.out.println((RationalScalar)zuri2.mul(zuri3));
//		System.out.println((RationalScalar)zuri3.mul(zuri4));
//		System.out.println((RationalScalar)zuri4.mul(zuri5));
//		
//		for(int i=0 ; i<5 ; i++)
//		System.out.println((RationalScalar)zuri4.pow(i));
	}
	
	
		
}


