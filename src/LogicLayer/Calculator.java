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

	public static char askForField() {
			System.out.println("Over which field will we be working?" + '\n'
					+ "Enter 'Q' for Rational" + '\n'
					+ "Enter 'R' for Real");
	Scanner myScanner = new Scanner(System.in);
	String fieldSTR = myScanner.next();
	char fieldCH = fieldSTR.charAt(0);
	myScanner.close();
	return fieldCH;
	}

	public static int askForOperation() {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please select an operation:" + '\n'
							+ "1. Addition" + '\n'
							+ "2. Multiplication" + '\n'
							+ "3. Evaluate" + '\n'
							+ "4. Derivate" + '\n'
							+ "5. Exit" + '\n');
		int oper = myScanner.nextInt();
		myScanner.close();
		return oper;
	}

	public static Polynomial askForPolynomial(String s, char f) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please enter your " + s + " Polynomial");
		String polySTR = myScanner.next();
		myScanner.close();
		return new Polynomial(polySTR, f);
	}
	
	public static Scalar askForXValue(char f) {
		Scanner myScanner = new Scanner(System.in);
		Scalar output;
		System.out.println("please enter the a scalar");
		String scalarSTR = myScanner.next();
		if(f == 'R') {  output = new RealScalar(scalarSTR) ;}
		else if( f == 'Q') {output = new RationalScalar(scalarSTR);}
		return output;
		}
	}
	

}
