package poly;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This class implements a term of a polynomial.
 * 
 * @author runb-cs112
 *
 */
class Term {
	/**
	 * Coefficient of term.
	 */

	public float coeff;

	/**
	 * Degree of term.
	 */

	public int degree;

	/**
	 * Initializes an instance with given coefficient and degree.
	 * 
	 * @param coeff Coefficient
	 * @param degree Degree
	 */
	public Term(float coeff, int degree) {
		this.coeff = coeff;
		this.degree = degree;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		return other != null &&
				other instanceof Term &&
				coeff == ((Term)other).coeff &&
				degree == ((Term)other).degree;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (degree == 0) {
			return coeff + "";
		} else if (degree == 1) {
			return coeff + "x";
		} else {
			return coeff + "x^" + degree;
		}
	}
}

/**
 * This class implements a linked list node that contains a Term instance.
 * 
 * @author runb-cs112
 *
 */
class Node {

	/**
	 * Term instance. 
	 */
	Term term;

	/**
	 * Next node in linked list. 
	 */
	Node next;

	/**
	 * Initializes this node with a term with given coefficient and degree,
	 * pointing to the given next node.
	 * 
	 * @param coeff Coefficient of term
	 * @param degree Degree of term
	 * @param next Next node
	 */
	public Node(float coeff, int degree, Node next) {
		term = new Term(coeff, degree);
		this.next = next;
	}
}

/**
 * This class implements a polynomial.
 * 
 * @author runb-cs112
 *
 */
public class Polynomial {

	/**
	 * Pointer to the front of the linked list that stores the polynomial. 
	 */ 
	Node poly;

	/** 
	 * Initializes this polynomial to empty, i.e. there are no terms.
	 *
	 */
	public Polynomial() {
		poly = null;
	}

	/**
	 * Reads a polynomial from an input stream (file or keyboard). The storage format
	 * of the polynomial is:
	 * <pre>
	 *     <coeff> <degree>
	 *     <coeff> <degree>
	 *     ...
	 *     <coeff> <degree>
	 * </pre>
	 * with the guarantee that degrees will be in descending order. For example:
	 * <pre>
	 *      4 5
	 *     -2 3
	 *      2 1
	 *      3 0
	 * </pre>
	 * which represents the polynomial:
	 * <pre>
	 *      4*x^5 - 2*x^3 + 2*x + 3 
	 * </pre>
	 * 
	 * @param br BufferedReader from which a polynomial is to be read
	 * @throws IOException If there is any input error in reading the polynomial
	 */
	public Polynomial(BufferedReader br) throws IOException {
		String line;
		StringTokenizer tokenizer;
		float coeff;
		int degree;

		poly = null;

		while ((line = br.readLine()) != null) {
			tokenizer = new StringTokenizer(line);
			coeff = Float.parseFloat(tokenizer.nextToken());
			degree = Integer.parseInt(tokenizer.nextToken());
			poly = new Node(coeff, degree, poly);
		}
	}


	/**
	 * Returns the polynomial obtained by adding the given polynomial p
	 * to this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial to be added
	 * @return A new polynomial which is the sum of this polynomial and p.
	 */
	public Polynomial add(Polynomial p) {
		/** COMPLETE THIS METHOD **/

		Node a = poly;
		Node b = p.poly;

		Polynomial ans = new Polynomial();
		Node temp = null;
		float sum;
		
		while (a != null){
			if (b == null){
				temp = new Node(a.term.coeff, a.term.degree, temp);
				a = a.next;
				continue;
			}else if (a.term.degree == b.term.degree){
				sum = a.term.coeff + b.term.coeff;
				temp = new Node(sum, a.term.degree, temp);
				a = a.next;
				b = b.next;
			}else if (a.term.degree > b.term.degree){
				temp = new Node(b.term.coeff, b.term.degree, temp);
				b = b.next;
			}else if (a.term.degree < b.term.degree){
				temp = new Node(a.term.coeff, a.term.degree, temp);
				a = a.next;
			}
		}

		while (b != null){
			if (a == null){
				temp = new Node(b.term.coeff, b.term.degree, temp);
				b = b.next;
				continue;
			}else if (a.term.degree == b.term.degree){
				sum = a.term.coeff + b.term.coeff;
				temp = new Node(sum, a.term.degree, temp);
				a = a.next;
				b = b.next;	
			}else if (a.term.degree > b.term.degree){
				temp = new Node(b.term.coeff, b.term.degree, temp);
				b = b.next;
			}else if (a.term.degree < b.term.degree){
				temp = new Node(a.term.coeff, a.term.degree, temp);
				a = a.next;
			}
		}

		Node reverse=temp;
		Node result=null;
		while (reverse!=null){
			if (reverse.term.coeff==0){
				reverse = reverse.next;
				continue;
			}else{
				result = new Node(reverse.term.coeff, reverse.term.degree, result);
				reverse = reverse.next;
			}
		}

		if (result == null)
			return null;
		else{
			ans.poly = result;
			return ans;
		}	

	}

	/**
	 * Returns the polynomial obtained by multiplying the given polynomial p
	 * with this polynomial - DOES NOT change this polynomial
	 * 
	 * @param p Polynomial with which this polynomial is to be multiplied
	 * @return A new polynomial which is the product of this polynomial and p.
	 */
	public Polynomial multiply(Polynomial p) {
		/** COMPLETE THIS METHOD **/
		Node a = poly;
		Node b = p.poly;
		
		if (poly == null || p.poly == null){
			Node zero = null;
			zero = new Node(0, 0, zero);
			Polynomial zeroAns = new Polynomial();
			zeroAns.poly = zero;
			return zeroAns;
		}
		
		float multCoeff;
		int multDegree;
		
		Node multTemp = null;
		Polynomial temp = new Polynomial();
		Polynomial ans = new Polynomial();

		while (a != null){
			while (b != null){
				multCoeff = a.term.coeff * b.term.coeff;
				multDegree = a.term.degree + b.term.degree;
				multTemp = new Node(multCoeff, multDegree, multTemp);				
				b = b.next;
			}
			
			Node reverse = multTemp;
			Node tReverse = null;
			while (reverse != null){
				if (reverse.term.coeff == 0){
					reverse = reverse.next;
					continue;
				}else{
					tReverse = new Node(reverse.term.coeff, reverse.term.degree, tReverse);
					reverse = reverse.next;
				}
			}
			temp.poly = tReverse;
			
			ans = ans.add(temp);					
			a = a.next;	
			b = p.poly;												
			multTemp = null;
		}
		return ans;
	}

	/**
	 * Evaluates this polynomial at the given value of x
	 * 
	 * @param x Value at which this polynomial is to be evaluated
	 * @return Value of this polynomial at x
	 */
	public float evaluate(float x) {
		/** COMPLETE THIS METHOD **/
		double ans=0;
		int degree;
		float coeff;
		
		Node a = poly;
			while(a!=null){
				coeff = a.term.coeff;
				degree = a.term.degree;
				
				ans = coeff*Math.pow(x, degree)+ans;
				a=a.next;
			}
			
			float total=(float)ans;
			
		return total;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String retval;

		if (poly == null) {
			return "0";
		} else {
			retval = poly.term.toString();
			for (Node current = poly.next ;
					current != null ;
					current = current.next) {
				retval = current.term.toString() + " + " + retval;
			}
			return retval;
		}
	}
}
