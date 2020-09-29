import java.util.regex.Matcher;
import java.util.regex.Pattern;
/** This class makes infixes into post fixes and vice versa
 * 
 * @author Konstantin Tomashevsky
 *
 */
public class Notation {
	/**
	 * converts infix to postfix
	 * @return a postfix string
	 */
	public static String convertInfixToPostfix(String Infix) throws InvalidNotationFormatException{
		NotationQueue<Character> toConvert = new NotationQueue<Character>();
		NotationStack<Character> symbol = new NotationStack<Character>();


		for(int i = 0; i<Infix.length();i++) {
			char current = Infix.charAt(i); 
			try {

				if(current<58 && current>47)
					toConvert.enqueue(current); 

				if(current=='(')
					symbol.push(current);

				if ((current == '%' || current == '/' || current == '*' || current == '+' || current == '-')){

					if((symbol.size()!=0)&&(symbol.top() == '%' || symbol.top() == '/' || symbol.top() == '*' || symbol.top() == '+' || symbol.top() == '-')) {
						if(hasPres(current, symbol.top())==false)
							toConvert.enqueue(symbol.pop());

					}
					else {
						symbol.push(current);

					}
				}

				if(current==')') {
					while(symbol.top()!='('){
						toConvert.enqueue(symbol.pop());

						if(symbol.size()==0) {
							throw new InvalidNotationFormatException();
						}
					}
					symbol.pop();
				}


			} catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) {

			}


		}

		try {
			while(symbol.size()!=0)
				toConvert.enqueue(symbol.pop());
		} catch (QueueOverflowException e) {
		} catch (StackUnderflowException e) {

		}

		return toConvert.toString();
	}

	private static boolean hasPres(char c, char sec) {
		int first =  0;
		int second = 0;
		switch (c) {
		case '+': first = 1;
		case '-': first = 1;
		case '*': first = 2;
		case '/': first = 2;
		case '^': first = 3;
		}

		switch (sec) {
		case '+': second = 1;
		case '-': second = 1;
		case '*': second = 2;
		case '/': second = 2;
		case '^': second = 3;
		}

		if(first-second>0)
			return true;
		System.out.println(first-second);
		return false;

	}

	/**
	 * converts postfix to infix
	 * @return a infix string
	 */
	public static String convertPostfixToInfix(String Postfix) throws InvalidNotationFormatException{
		NotationStack convert = new NotationStack();


		for(int i = 0; i<Postfix.length();i++) {
			char current = Postfix.charAt(i);
			try {
				if(current<58 && current>47)
					convert.push(current);

				if ((current == '%' || current == '/' || current == '*' || current == '+' || current == '-')){
					if(convert.size()<2)
						throw new InvalidNotationFormatException();
					else {
						Object a = convert.pop();
						convert.push("("+convert.pop()+current+a+")");
					}

				}

			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}	
		}
		if(convert.size()!=1)
			throw new InvalidNotationFormatException();
		return convert.toString();
	}
	/**
	 * calculates a postfix string
	 * @return a double that is the solution
	 */
	public static double evaluatePostfixExpression(String Postfix) throws InvalidNotationFormatException{
		NotationStack<Double> convert = new NotationStack<Double>();
		for(int i = 0; i<Postfix.length();i++) {
			char current = Postfix.charAt(i);
			try {
				System.out.println(convert.toString());
				System.out.println("_______________________");
				if(current<58 && current>47)
					convert.push((double)current-48);

				if ((current == '%' || current == '/' || current == '*' || current == '+' || current == '-')){
					if(convert.size()<2)
						throw new InvalidNotationFormatException();
					else {
						double a = convert.pop();
						double b = convert.pop();
						if(current == '+') 
							convert.push(a+b);
						else if(current == '/')
							convert.push(b/a);
						else if(current == '-')
							convert.push(b-a);
						else if(current == '*')
							convert.push(a*b);

					}

				}

			} catch (StackOverflowException | StackUnderflowException e) {
				e.printStackTrace();
			}

		}
		if(convert.size()!=1)
			throw new InvalidNotationFormatException();
		return Double.parseDouble(convert.toString());
	}
}
