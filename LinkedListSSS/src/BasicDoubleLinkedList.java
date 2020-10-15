import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;




public class BasicDoubleLinkedList<T> implements java.lang.Iterable<T>{
	public int size;
	public Node listStart;
	public Node listEnd;

	public BasicDoubleLinkedList() {
		listEnd = null;
		listStart = null;
		size = 0;
	}

	public BasicDoubleLinkedList<T> addToEnd(T data){
		if(listStart == null) {
			listEnd = new Node(null, data, null);
			listStart = listEnd;
			
		}
		else {
			listEnd = new Node(listEnd, data, null);
			listEnd.previous.next = listEnd;
			
		}
		size++;

		return this;
	}

	public BasicDoubleLinkedList<T> addToFront(T data){
		if(listStart == null) {
			listStart = new Node( null, data, null);
			listEnd = listStart;
		}
		else {

			listStart = new Node( null, data, listStart);
			listStart.next.previous = listStart;
		}
		size++;

		return this;
	}

	public T getFirst() {
		return listStart.data;
	}

	public T getLast() {
		return listEnd.data;
	}


	public int getSize() {
		return size;
	}
	//iterator

	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
		
		if(size == 0)
			throw new NoSuchElementException();
		else if(comparator.compare(listStart.data, targetData)==0)
			retrieveFirstElement();

		else if(comparator.compare(listEnd.data, targetData)==0)
			retrieveLastElement();

		else {

			Node current = listStart;
			
			while(comparator.compare(current.data, targetData)!=0){
				current = current.next;

			}
			if(current == null)
				throw new NoSuchElementException();
			current.previous.next = current.next;
			current.next.previous = current.previous;

			current.previous = null;
			current.next = null;
			size--;
		}

		return this;
	}

	public T retrieveFirstElement(){
		if(listStart == null)
			return null;

		else if(listStart==listEnd) {
			T toRem =listStart.data;
			listStart = null;
			listEnd = null;
			size--;
			return toRem;
		}

		Node toRem = listStart;
		listStart = listStart.next;
		listStart.previous=null;
		
		
		
		size--;
		return toRem.data;
	}



	public T retrieveLastElement() {
		if(listEnd == null)
			return null;

		else if(listStart==listEnd) {
			T toRem =listEnd.data;
			listStart = null;
			listEnd = null;
			size--;
			return toRem;
		}

		Node toRem =listEnd;
		listEnd = listEnd.previous;
		listEnd.next = null;
		
		size--;
		return toRem.data;
	}

	public ArrayList<T> toArrayList() {
		if(listStart == null) {
			return new ArrayList<T>();
		}
		Node current = listStart;
		ArrayList<T> toReturn = new ArrayList<T>();
		
		while (current!=null) {
			System.out.println(current.data);
			toReturn.add(current.data);
			current = current.next;
		}
		return toReturn;
	}


	public class Node{

		public T data;
		public Node next;
		public Node previous;

		public Node(Node prev, T dat, Node nex) {
			data = dat;
			previous =prev;
			next =nex;

		}

	}


	@Override
	public ListIterator<T> iterator() {
		
		return new ListIterator <T>() {
			private Node iterLoc = listStart;

			@Override
			public void add(T e) throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
				
			}

			@Override
			public boolean hasNext() {
				return iterLoc != null;
			}

			@Override
			public boolean hasPrevious() {
				if((iterLoc==null))
					return true; 
				return (listStart!=null)&&(iterLoc.previous != null);

			}

			@Override
			public T next() {
				
				if(hasNext() == false)
					throw new NoSuchElementException();

				T toReturn = iterLoc.data;
				iterLoc = iterLoc.next;
				

				return toReturn;
			}

			@Override
			public int nextIndex() throws  UnsupportedOperationException{
				throw new UnsupportedOperationException();
			}

			@Override
			public T previous() {
				if(hasPrevious() == false)
					throw new NoSuchElementException();

				else if((iterLoc==null)) {
					iterLoc = listEnd;
				}

				else 
					iterLoc = iterLoc.previous;

				return iterLoc.data;
			}

			@Override
			public int previousIndex() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
			}

			@Override
			public void remove() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
				
			}

			@Override
			public void set(T e) throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
				
			}
			
			
		};
	}


	



}
