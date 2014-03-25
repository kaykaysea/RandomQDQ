import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int size;

	public Deque() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	private class Node {

		private Item item;
		private Node next;
		private Node previous;
				
				
	}

	public boolean isEmpty() {

		return size == 0;

	}

	public int size() {

		return size;
	}

	public void addFirst(Item item) {

		if (item == null)
			throw new NullPointerException("Cannot add a null item to a queue");

		Node newFirst = new Node();
		newFirst.item = item;
		newFirst.previous = null;

		if (!isEmpty()) {

			Node oldFirst = first;
			newFirst.next = oldFirst;
			newFirst.previous = null;
			oldFirst.previous = newFirst;
			first = newFirst;
		}

		else {

			first = newFirst;
			last = first;

		}

		size++;

	}

	public void addLast(Item item) {

		if (item == null)
			throw new NullPointerException("Cannot add a null item to a queue");

		Node newLast = new Node();
		newLast.item = item;
		newLast.next = null;

		if (!isEmpty()) {

			Node oldLast = last;
			newLast.previous = oldLast;
			oldLast.next = newLast;
			last = newLast;

		}

		else {
			last = newLast;
			first = last;
		}

		size++;

	}

	public Item removeFirst() {

		if (isEmpty())
			throw new NoSuchElementException(
					"Cannot remove from an empty queue");

		Item item = first.item;

		if (size == 1) {

			first = null;
			last = null;
		}

		else {
			first = first.next;
			first.previous = null;

		}

		size--;
		return item;

	}

	public Item removeLast() {

		if (isEmpty())
			throw new NoSuchElementException(
					"Cannot remove from an empty queue");

		Item item = last.item;

		if (size == 1) {

			first = null;
			last = null;
		}

		else {
			last = last.previous;
			last.next = null;

		}

		size--;
		return item;

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new DequeIterator();
	}

	private class DequeIterator implements Iterator<Item> {

		Node currNode = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currNode != null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new NoSuchElementException("There is no next element");
			}
			Item item = currNode.item;
			currNode = currNode.next;
			return item;

		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}
	
	
	public static void main(String[] args) {
		
		Deque<String> deq = new Deque<String>();
		
		
		deq.addFirst("1 ");
		deq.addLast("2 ");			
		deq.addLast("3");
		deq.addFirst("1 ");
		deq.addLast("4");
		deq.addFirst("1 ");
		deq.addLast("4");
		deq.addFirst("6");
		deq.addFirst("7 ");
		deq.addFirst("1 ");
		deq.addLast("34 ");
		deq.addLast("55 ");
		deq.addLast("weer");
		System.out.println(deq.size);
		Iterator<String> it = deq.iterator();
		while (it.hasNext()){
			System.out.print(it.next()+" ");
		}
		Object ob = deq.removeLast();
		System.out.println("\n"+ ob.toString());		
		while (it.hasNext()){
			System.out.print(it.next()+" ");
		}
   	
		
		
	}
	

}
