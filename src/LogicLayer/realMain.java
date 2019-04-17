package LogicLayer;

import java.util.*;
public class realMain {

	public static void main(String[] args) {
	
	int operation;
	char field;
	Polynomial poly1;
	Polynomial poly2;
	Calculator myCalc = new Calculator();
	
	operation = Calculator.askForOperation();
	if(operation == 5) {
		return;
	}
	
	field = Calculator.askForField();
	poly1 = Calculator.askForPolynomial("first", field);
	
	if( operation == 1 | operation == 2) {
		poly1 = Calculator.askForPolynomial("second", field);		
	}
	//left to pick up a kusit
	//didn't finish code
	
	
	
	
	

	}

}
