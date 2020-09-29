import java.util.ArrayList;
/** notationQueue implementation 
 *
 * @author Konstantin Tomashevsky
 *
 */
public class NotationQueue<T> implements QueueInterface{

	private int maxSize;
	private ArrayList<T> theQueue;

	public NotationQueue(){
		maxSize = 100;
		theQueue= new ArrayList<T>();
	}

	public NotationQueue(int size){
		maxSize = size;
		theQueue= new ArrayList<T>();
	}

	public NotationQueue(ArrayList<T> toMake){
		maxSize = 100;
		theQueue= new ArrayList<T>();

		for(T a:toMake) {
			theQueue.add(a);
		}
	}



	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		if(theQueue.size()==0)
			return true;
		return false;
	}

	/**
	 * Determines if the Queue is full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		if(theQueue.size()==maxSize)
			return true;
		return false;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	public T dequeue() throws QueueUnderflowException {
		if(theQueue.size()==0)
			throw new QueueUnderflowException();
		T toReturn = theQueue.remove(0);
		return toReturn;
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return theQueue.size();
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(Object e) throws QueueOverflowException {
		if(theQueue.size()==maxSize)
			throw new QueueOverflowException();
		theQueue.add(theQueue.size(), (T) e);
		return true;
	}



	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String toReturn = "";
		for(T s: theQueue)
			toReturn+=s+"";

		return toReturn;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String toReturn = "";
		for(T s: theQueue)
			toReturn+=s+""+delimiter;
		toReturn = toReturn.substring(0,toReturn.length()-1);
		return toReturn;
	}

}
