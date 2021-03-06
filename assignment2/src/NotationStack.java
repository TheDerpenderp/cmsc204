import java.util.ArrayList;
/** notationStack implementation 
 * 
 * @author Konstantin Tomashevsky
 *
 */
public class NotationStack<T> implements StackInterface{


	private ArrayList<T> theStack;
	private int maxSize;

	public NotationStack(){
		maxSize = 100;
		theStack = new ArrayList<T>();
	}


	public NotationStack(int size){
		maxSize = size;
		theStack = new ArrayList<T>();
	}

	public NotationStack(ArrayList<T> toMake){
		maxSize = 100;
		theStack= new ArrayList<T>();

		for(int i = toMake.size()-1; i>=0;i--) {
			theStack.add(toMake.get(i));
		}
	}

	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		if(theStack.size()==0)
			return true;
		return false;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		if(theStack.size()==maxSize)
			return true;
		return false;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() throws StackUnderflowException {
		if(theStack.size()==0)
			throw new StackUnderflowException();
		T toReturn = theStack.remove(0);
		return toReturn;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	public T top() throws StackUnderflowException {
		if(theStack.size()==0)
			throw new StackUnderflowException();
		return theStack.get(0);
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {

		return theStack.size();
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(Object e) throws StackOverflowException {
		if(theStack.size()==maxSize)
			throw new StackOverflowException();
		theStack.add(0, (T) e);
		return true;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String toReturn = "";
		for(int i = theStack.size()-1; i>=0;i--) 
			toReturn+=theStack.get(i)+"";

		return toReturn;
	}


	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String toReturn = "";
		for(int i = theStack.size()-1; i>=0;i--) 
			toReturn+=theStack.get(i)+""+delimiter;
		toReturn = toReturn.substring(0,toReturn.length()-1);
		return toReturn;


	}
}
