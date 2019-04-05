package apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import structures.Stack;

public class Expression {

	/**
	 * Expression to be evaluated
	 */
	String expr;                

	/**
	 * Scalar symbols in the expression 
	 */
	ArrayList<ScalarSymbol> scalars;   

	/**
	 * Array symbols in the expression
	 */
	ArrayList<ArraySymbol> arrays;

	/**
	 * Positions of opening brackets
	 */
	ArrayList<Integer> openingBracketIndex; 

	/**
	 * Positions of closing brackets
	 */
	ArrayList<Integer> closingBracketIndex; 

	/**
	 * String containing all delimiters (characters other than variables and constantants), 
	 * to be used with StringTokenizer
	 */
	public static final String delims = " \t*+-/()[]";

	/**
	 * Initializes this Expression object with an input expression. Sets all other
	 * fields to null.
	 * 
	 * @param expr Expression
	 */
	public Expression(String expr) {
		this.expr = expr;
		scalars = null;
		arrays = null;
		openingBracketIndex = null;
		closingBracketIndex = null;
	}

	/**
	 * Matches parentheses and square brackets. Populates the openingBracketIndex and
	 * closingBracketIndex array lists in such a way that closingBracketIndex[i] is
	 * the position of the bracket in the expression that closes an opening bracket
	 * at position openingBracketIndex[i]. For example, if the expression is:
	 * <pre>
	 *    (a+(b-c))*(d+A[4])
	 * </pre>
	 * then the method would return true, and the array lists would be set to:
	 * <pre>
	 *    openingBracketIndex: [0 3 10 14]
	 *    closingBracketIndex: [8 7 17 16]
	 * </pe>
	 * 
	 * See the FAQ in project description for more details.
	 * 
	 * @return True if brackets are matched correctly, false if not
	 */
	public boolean isLegallyMatched() {
		// COMPLETE THIS METHOD

		Stack<Integer> openParen = new Stack<Integer>();
		Stack<Integer> closeParen = new Stack<Integer>();
		Stack<Integer> openBrac = new Stack<Integer>();
		Stack<Integer> closeBrac = new Stack<Integer>();

		openingBracketIndex = new ArrayList<Integer>();
		closingBracketIndex = new ArrayList<Integer>();

		//Assigns the arrays with proper closing brackets.
		for(int i=0;i<expr.length();i++){
			if(expr.charAt(i)=='['||expr.charAt(i)=='('){
				openingBracketIndex.add(i);
			}
		}

		for(int i = expr.length()-1;i>=0;i--){
			if(expr.charAt(i)==')'||expr.charAt(i)==']'){
				closingBracketIndex.add(i);
			}
		}

		//Checks if the sizes are the same. If sizes are not same, that means there is a mismatch in the brackets
		//so return false.
		if(openingBracketIndex.size()!=closingBracketIndex.size()){
			System.out.println("Mismatched Expression!");
			return false;
		}

		for(int i = 0;i<expr.length();i++){
			if(expr.charAt(i)=='('){
				openParen.push(i);
				System.out.println("'(' at: "+ openParen.peek());
			}else if(expr.charAt(i)=='['){
				openBrac.push(i);
				System.out.println("'[' at: "+ openBrac.peek());
			}
		}

		for(int i = expr.length()-1;i>=0;i--){
			if(expr.charAt(i)==')'){
				closeParen.push(i);
				System.out.println("')' at: "+ closeParen.peek());
			}else if(expr.charAt(i)==']'){
				closeBrac.push(i);
				System.out.println("']' at: "+ closeBrac.peek());
			}
		}

		//If the start of the expression is ')' or ']', then returns false
		if(expr.charAt(0)==')'||expr.charAt(0)==']'){
			System.out.println("Incorrect expression");
			return false;
		}
		if(expr.charAt(expr.length()-1)=='('||expr.charAt(expr.length()-1)=='['){
			System.out.println("Incorrect expression. Ending with '(' or '['");
		}


		//Returns false if ([ax-b)] or [(ax-b])
		int testOpenBrac = -2, testCloseBrac = -2, testOpenParen = -2, testCloseParen = -2;
		if(openBrac.size()>=1){
			testOpenBrac = openBrac.peek();
		}
		if(closeBrac.size()>=1){
			testCloseBrac = closeBrac.peek();
		}
		if(openParen.size()>=1){
			testOpenParen = openParen.peek();
		}
		if(closeParen.size()>=1){
			testCloseParen = closeParen.peek();
		}

		if(openBrac.size()>=1 && openParen.size()>=1){
			//[ax]-a+(b)     o[0] c[3]    p(7)  c(9)

			//([ax-b]*(bx))

			if(testOpenBrac>testOpenParen && (testCloseParen>testOpenBrac && testCloseParen<testCloseBrac)){
				System.out.println("([ax-b)] error with bracket mismatch");
				return false;
			}

			if(testOpenParen>testOpenBrac && (testCloseBrac>testOpenParen &&testCloseBrac<testCloseParen)){
				System.out.println("testOpen( "+testOpenParen);
				System.out.println("testOpen[ "+testOpenBrac);
				System.out.println("testClose) "+testCloseParen);
				System.out.println("testClose] "+testCloseBrac);
				System.out.println("[(ax-b]) error with bracket mismatch");
				return false;
			}
		}


		//Check if the brackets match up. ie the ( precedes ) and [ precedes ]
		//example:  (a+(b-c))*(d+A[4])
		if(openBrac.size()>=1){
			while(openBrac!=null){
				if(openBrac.size()==1){
					if(openBrac.peek()>closeBrac.peek()){
						System.out.println("False input: ']' and '['");
						return false;
					}else{
						System.out.println("size 1");
						break;
					}
				}else{
					System.out.println("Pop []");
					openBrac.pop();
					closeBrac.pop();
					System.out.println(openBrac.size());
				}
			}
		}

		if(openParen.size()>=1){
			while(openParen!=null){
				if(openParen.size()==1){
					if(openParen.peek()>closeParen.peek()){
						System.out.println("False input: ')' and '('");
						return false;
					}else{
						System.out.println("() size 1");
						break;
					}
				}else{
					System.out.println("Pop ()");
					openParen.pop();
					closeParen.pop();
				}
			}
		}




		System.out.println("Reached end of code!");
		// FOLLOWING LINE ADDED TO MAKE COMPILER HAPPY
		return true;
	}

	/**
	 * Populates the scalars and arrays lists with symbols for scalar and array
	 * variables in the expression. For every variable, a SINGLE symbol is created and stored,
	 * even if it appears more than once in the expression.
	 * At this time, the constantructors for ScalarSymbol and ArraySymbol
	 * will initialize values to zero and null, respectively.
	 * The actual values will be loaded from a file in the loadSymbolValues method.
	 */
	public void buildSymbols() {
		// COMPLETE THIS METHOD

		scalars = new ArrayList<ScalarSymbol>();
		arrays = new ArrayList<ArraySymbol>();

		for(int i =0; i<expr.length();i++){
			if(Character.isLetter(expr.charAt(i))){
				String scalarSymbol = "";

				while(i<expr.length()&&Character.isLetter(expr.charAt(i))){
					scalarSymbol+=expr.charAt(i);
					i++;
				}

				if(i<expr.length()&&expr.charAt(i)=='['){
					ArraySymbol array = new ArraySymbol(scalarSymbol);

					boolean check = false;
					for(int k = 0; k < arrays.size(); k++){
						if(arrays.get(k).equals(array)){
							check = true;
						}
					}
					if(!check){
						arrays.add(array);
					}

				}else{
					ScalarSymbol scalar = new ScalarSymbol(scalarSymbol);
					boolean check = false;
					for(int j = 0; j < scalars.size(); j++){
						if(scalars.get(j).equals(scalar)){
							check = true;
						}
					}
					if(!check){
						scalars.add(scalar);
					}
				}


			}
		}
		printArrays();
		printScalars();


	}

	/**
	 * Loads values for symbols in the expression
	 * 
	 * @param sc Scanner for values input
	 * @throws IOException If there is a problem with the input 
	 */
	public void loadSymbolValues(Scanner sc) 
			throws IOException {
		while (sc.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine().trim());
			int numTokens = st.countTokens();
			String sym = st.nextToken();
			ScalarSymbol ssymbol = new ScalarSymbol(sym);
			ArraySymbol asymbol = new ArraySymbol(sym);
			int ssi = scalars.indexOf(ssymbol);
			int asi = arrays.indexOf(asymbol);
			if (ssi == -1 && asi == -1) {
				continue;
			}
			int num = Integer.parseInt(st.nextToken());
			if (numTokens == 2) { // scalar symbol
				scalars.get(ssi).value = num;
			} else { // array symbol
				asymbol = arrays.get(asi);
				asymbol.values = new int[num];
				// following are (index,val) pairs
				while (st.hasMoreTokens()) {
					String tok = st.nextToken();
					StringTokenizer stt = new StringTokenizer(tok," (,)");
					int index = Integer.parseInt(stt.nextToken());
					int val = Integer.parseInt(stt.nextToken());
					asymbol.values[index] = val;              
				}
			}
		}
	}

	/**
	 * Evaluates the expression, using RECURSION to evaluate subexpressions and to evaluate array 
	 * subscript expressions. (Note: you can use one or more private helper methods
	 * to implement the recursion.)
	 * 
	 * @return Result of evaluation
	 */
	public float evaluate() {
		// COMPLETE THIS METHOD

		//return float taking in expression and its length
		return evaluateVal(expr,expr.length()-1);

	}
	
	private int bracCount=0;
	
	private float evaluateVal(String expression, int exprEnd){
		
		Stack <String> operators = new Stack <String>();
		Stack <Float> values = new Stack <Float>();
		
		StringTokenizer st = new StringTokenizer(expression, delims, true);
		
		String token = "", letters = "";      
		float constant = 0, scalarVal = 0, bracVal = 0, arrayIndex = 0, paren = 0;
	
		

		while (st != null) {
			if (!st.hasMoreTokens()){
				break;
			}
			
			token = st.nextToken();
			
			if(token.equals("(")||token.equals("[")){
				
				int openBracIndex = openingBracketIndex.get(bracCount);
				int closeBracIndex = closingBracketIndex.get(bracCount);
				bracCount++;
				
				//recursive to get values inside ( and [
				paren = evaluateVal(expr.substring(openBracIndex+1, closeBracIndex), closeBracIndex-1);
				
				System.out.println("token: "+token);
				
				if (token.equals("[")){
					for(int i = 0; i < arrays.size(); i++){
						if(arrays.get(i).equals(letters)){
							arrayIndex = (int)i;
							System.out.println("array Index: "+arrayIndex);
						}
					}
					
					int[] arrayVal = arrays.get((int)arrayIndex).values;
					
					bracVal = arrayVal[(int)paren];
					values.push(bracVal);
					
				}else{
					values.push(paren);
				}
				
				if (closeBracIndex == exprEnd){
					st = null;
				}else{
					st = new StringTokenizer(expr.substring(closeBracIndex + 1, exprEnd + 1), delims, true);
				}

			}else if ((token.charAt(0) >= 'a' && token.charAt(0) <= 'z')){
				letters = token;    
				ScalarSymbol scalarSymbol = new ScalarSymbol(token);
				int scalarIndex = scalars.indexOf(scalarSymbol);
				scalarVal = scalars.get(scalarIndex).value;
				values.push(scalarVal);
				checkDivMult(operators, values);

			}else if((token.charAt(0) >= 'A' && token.charAt(0) <= 'Z')){
				letters = token;	       

			}else if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
				operators.push(token);

			}else{
				constant = Integer.parseInt(token);
				values.push(constant);
				checkDivMult(operators, values);
			}
		}

		if (operators.isEmpty())
			return values.pop();

		Stack <Float> recVal = new Stack <Float>();
		Stack <String> recOperator = new Stack <String>();
		
		while (!operators.isEmpty()){
			recOperator.push(operators.pop());
		}
		while(!values.isEmpty()){
			recVal.push(values.pop());
		}
		while (!recOperator.isEmpty()){
			evalStack(recOperator, recVal, false);
		}
		return recVal.pop();
	}

	private void checkDivMult(Stack <String> operators, Stack <Float> values)
	{
		if (!operators.isEmpty())
		{
			String topOperator = operators.peek();
			if (topOperator.equals("/") || topOperator.equals("*"))
				evalStack(operators, values, true);
		}
	}

	private void evalStack(Stack <String> operators, Stack <Float> values, boolean inOrder)
	{
		String topOperator = operators.pop();
		float temp1 = 0, temp2 = 0, answer = 0;
		if (inOrder){
			temp2 = values.pop();
			temp1 = values.pop();
		}else{
			temp1 = values.pop();
			temp2 = values.pop();
		}

		if (topOperator.equals("/")){
			answer = temp1 / temp2;       
		}else if (topOperator.equals("*")){
			answer = temp1 * temp2;
		}else if (topOperator.equals("+")){
			answer = temp1 + temp2;
		}else if (topOperator.equals("-")){ 
			answer = temp1 - temp2;
		}
		
		values.push(answer);
	}









	/**
	 * Utility method, prints the symbols in the scalars list
	 */
	public void printScalars() {
		for (ScalarSymbol ss: scalars) {
			System.out.println(ss);
		}
	}

	/**
	 * Utility method, prints the symbols in the arrays list
	 */
	public void printArrays() {
		for (ArraySymbol as: arrays) {
			System.out.println(as);
		}
	}

}
