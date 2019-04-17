package LogicLayer;

import java.util.Scanner;

public class Calculator {
	
	char field;
	int operation;
	
	public Calculator(){
		
	}
	
	
	public Calculator( char field, int operation, Polynomial Poly1, Polynomial poly2) {
		this.field = field;
		this.operation = operation;
		
	}
	
	public static Polynomial add(Polynomial poly1,Polynomial poly2) {
		return poly1.add(poly2);
	}
	
	public static Polynomial mul(Polynomial poly1,Polynomial poly2) {
		return poly1.mul(poly2);
	}
	
	public static Scalar evaluate(Polynomial poly, Scalar input) {
		return poly.evaluate(input);
	}
	
	public static Polynomial derivate(Polynomial poly) {
		return poly.derivate();
	}

	public static char askForField() {
			System.out.println("Over which field will we be working?" + '\n'
					+ "Enter 'Q' for Rational" + '\n'
					+ "Enter 'R' for Real");
	Scanner myScanner = new Scanner(System.in);
	String fieldSTR = myScanner.nextLine();
	char fieldCH = fieldSTR.charAt(0);
	//myScanner.close();
	return fieldCH;
	}

	public static int askForOperation() {
		System.out.println("Please select an operation:" + '\n'
							+ "1. Addition" + '\n'
							+ "2. Multiplication" + '\n'
							+ "3. Evaluate" + '\n'
							+ "4. Derivate" + '\n'
							+ "5. Exit" + '\n');
		Scanner myScanner = new Scanner(System.in);
		int oper = myScanner.nextInt();
		//myScanner.close();
		return oper;
	}

	public static Polynomial askForPolynomial(String s, char f) {
		System.out.println("Please enter your " + s + " Polynomial");
		Scanner myScanner = new Scanner(System.in);
		String polySTR = myScanner.nextLine();
		//myScanner.close();
		return new Polynomial(polySTR, f);
	}
	
	public static Scalar askForXValue(char f) {
		Scalar output;
		System.out.println("please enter the a scalar");
		Scanner myScanner = new Scanner(System.in);
		String scalarSTR = myScanner.nextLine();
		//myScanner.close();
		if(f == 'R') {  output = new RealScalar(scalarSTR) ;}
		else {output = new RationalScalar(scalarSTR);}
		return output;
		
	}
	

}
