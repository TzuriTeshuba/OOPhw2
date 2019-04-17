package LogicLayer;

public class CalcController {
	
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
			poly1 = Calculator.askForPolynomial("first", field);
			poly2 = Calculator.askForPolynomial("second", field);
			answer = Calculator.add(poly1, poly2).toString();
			break;

				
		case 2:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("first", field);
			poly2 = Calculator.askForPolynomial("second", field);
			answer = Calculator.mul(poly1, poly2).toString();
			break;


		case 3:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("first", field);
			Scalar input = Calculator.askForXValue(field);
			answer = Calculator.evaluate(poly1, input).toString();
			break;

			
		case 4:
			field = Calculator.askForField();
			poly1 = Calculator.askForPolynomial("first", field);
			answer = Calculator.derivate(poly1).toString();
			break;
			
		case 5: return;
		
		}
		
		System.out.println(answer);
		runCalculator();
		}				
}
