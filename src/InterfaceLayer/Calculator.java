package InterfaceLayer;

import java.util.Scanner;
import LogicLayer.Polynomial;
import LogicLayer.RationalScalar;
import LogicLayer.RealScalar;
import LogicLayer.Scalar;

public class Calculator {
	public static void main(String[] args) {
	runCalculator();	
}
	
	public static void runCalculator() {
		int operation;
		char field;
		Polynomial poly1;
		Polynomial poly2;
		String answer = "";
		
		operation = Calculator.askForOperation();
		
		switch(operation) {
		
		case 1:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("the first", field);
			poly2 = Calculator.askForPolynomial("the second", field);
			answer = Calculator.add(poly1, poly2).toString();
			break;

				
		case 2:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("the first", field);
			poly2 = Calculator.askForPolynomial("the second", field);
			answer = Calculator.mul(poly1, poly2).toString();
			break;


		case 3:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("a", field);
			Scalar input = Calculator.askForXValue(field);
			answer = Calculator.evaluate(poly1, input).toString();
			break;

			
		case 4:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("the first", field);
			answer = Calculator.derivate(poly1).toString();
			break;
			
		case 5: return;
		
		}
		
		System.out.println("The solution is: "+ '\n'  + answer);
		runCalculator();
		}	
	
	
	public static Polynomial add(Polynomial poly1,Polynomial poly2) {
		return poly1.add(poly2);
	}
	
	public static Polynomial mul(Polynomial poly1,Polynomial poly2) {
		return poly1.mul(poly2);
	}
	
	public static Scalar evaluate(Polynomial poly, Scalar scalar) {
		return poly.evaluate(scalar);
	}
	
	public static Polynomial derivate(Polynomial poly) {
		return poly.derivate();
	}

	public static char askForField() {
			System.out.println("Please select the scalar field" + '\n'
					+ "Enter 'Q' for Rational" + '\n'
					+ "Enter 'R' for Real");
	Scanner myScanner = new Scanner(System.in);
	String fieldSTR = myScanner.nextLine();
	char fieldCH = fieldSTR.charAt(0);
	if(fieldCH == 'q')return 'Q';
	if(fieldCH == 'r')return 'R';
	if (fieldCH != 'Q' & fieldCH != 'R') {
		System.out.println("invaild field , try again");
		return askForField();
	}
	return fieldCH;
	}

	public static int askForOperation() {
		String vaildOper = "12345";
		System.out.println("Please select an operation" + '\n'
							+ "1. Addition" + '\n'
							+ "2. Multiplication" + '\n'
							+ "3. Evaluate" + '\n'
							+ "4. Derivate" + '\n'
							+ "5. Exit" + '\n');
		Scanner myScanner = new Scanner(System.in);
		String oper = myScanner.nextLine();
		if(!vaildOper.contains(oper)) {
			System.out.println("invaild operation, enter a number between 1 and 5.");
			return askForOperation();
		}
		return Integer.parseInt(oper);
	}

	public static Polynomial askForPolynomial(String s, char f) {
		System.out.println("Please insert " + s + " Polynomial");
		Scanner myScanner = new Scanner(System.in);
		String polySTR = myScanner.nextLine();
		if(!isVaildPoly(polySTR)) {
			System.out.println("invaild polynomial, try again ");
			return askForPolynomial(s,f);
		}
		return new Polynomial(polySTR, f);
	}
	
	public static Scalar askForXValue(char f) {
		Scalar output;
		System.out.println("please enter a scalar");
		Scanner myScanner = new Scanner(System.in);
		String scalarSTR = myScanner.nextLine();
		if(!isVaildPoly(scalarSTR)) {
			System.out.println("invaild scalar, try again");
			return askForXValue(f);
		}
		if(f == 'R') {  output = new RealScalar(scalarSTR) ;}
		else {output = new RationalScalar(scalarSTR);}
		return output;
		
	}
	
	public static boolean isVaildPoly(String poly) {
		Boolean output = true;
		String vaildOper = "/.+-x^";
		String vaildNum  = "0123456789";
		for(int i = 0 ;output & i < poly.length() ; i++) {
			output = vaildOper.contains("" + poly.charAt(i))
					|vaildNum.contains(""  +poly.charAt(i));	
		}
		return output;
	}
	

}
