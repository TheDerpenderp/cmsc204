public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{

	private java.util.Comparator<T> compare;



	public SortedDoubleLinkedList(java.util.Comparator<T> comparator2){
		super();
		compare = comparator2;
	}

	public SortedDoubleLinkedList<T> add(T data){

		if(size==0) {
			listStart = new Node(null,data,null);
			listEnd = listStart;
			size++;
			return this;
		}
		
		if(compare.compare(listStart.data, data)>0){
			listStart = new Node( null, data, listStart);
			listStart.next.previous = listStart;
			size++;
			
			return this;
		}
		
		if(compare.compare(listEnd.data, data)<0) {
			listEnd = new Node(listEnd, data, null);
			listEnd.previous.next = listEnd;
			size++;
			
			return this;
		}
		

		Node current = listStart;
		while((current.next!=null)&&(compare.compare(current.data, data)<0)) {
			current= current.next;
		}
		System.out.println(data);
		Node toInsert =new Node(current.previous, data,current);
		current.previous.next = toInsert;
		current.previous = toInsert;

		//listEnd.previous.next = listEnd; 			listStart.next.previous = listStart;


		size++;
		return this;

	}

	public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}


	public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}


	public java.util.ListIterator<T> iterator(){
		return super.iterator();

	}



	public SortedDoubleLinkedList<T> remove(T data, java.util.Comparator<T> comparator){
		super.remove(data, comparator);
		return this;
	}
}
