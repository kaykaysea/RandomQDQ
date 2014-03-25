import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private int size;
	private Item[] itemArray;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue(){
		
		itemArray = (Item[]) new Object[1];
		size = 0;
	}
	
	
	public boolean isEmpty(){
		
		return size == 0;
	}
	
	public int size(){
		
		return size;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int N){
		//create a new array of size N and copy contents of the present array iteratively to the new one.pass references back to original
		Item[] tempItemArray = (Item[])new Object[N];
		for(int i=0; i<size; i++){
			tempItemArray[i]=itemArray[i];
		}
		
		itemArray = tempItemArray;
		
	}
	
	public void enqueue(Item item){
		
		if(item==null) throw new NullPointerException("cannot add a null item");
		//resize the array to twice the present size if the number of elements reaches the present size of the array
		if(size==itemArray.length)resize(2*itemArray.length);
		//add the incoming item at index 'size'
		itemArray[size] = item;
		size++;
	}
	

//	private void adjustArray(int index){
//		
//		for(int i=index;i<size;i++){
//			itemArray[i]=itemArray[i+1];
//		}
//		itemArray[size]=null;
//		
//	}
//	
	
	public Item dequeue(){
		
		//1.Generate a random index 
		//2.copy the item at that index to temp location 'removedItem'
		//3. copy the item at index 'size-1'(last element in the array) to the location at random index and free the 'size-1' position
		//4. decrement size
		if(isEmpty()) throw new NoSuchElementException("cannot dequeue from an already empty queue");
		
		int randIndex = StdRandom.uniform(size);
		Item removedItem = itemArray[randIndex];
		itemArray[randIndex] = itemArray[size-1];
		itemArray[size-1]=null;
		//adjustArray(randIndex);
		size--;
		if(size>0 && size==itemArray.length/4){
			resize(itemArray.length/2);
		}
		
		return removedItem;
		
		
	}
	
	public Item sample(){
		if(isEmpty()) throw new NoSuchElementException("cannot sample an empty array");
		int randIndex = StdRandom.uniform(size);
		return itemArray[randIndex];
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new RandomQueueIterator();
	}
	
	private class RandomQueueIterator<Item> implements Iterator<Item>{
		
		public RandomQueueIterator() {
			//shuffleArray();
			StdRandom.shuffle(itemArray, 0, size-1);
		}
		
		int pointer = 0;
		@Override
		public boolean hasNext() {
			
			return pointer < size;
			//return itemArray[pointer+1]!=null;
		}
		
		private void shuffleArray(){
			
			
			StdRandom.shuffle(itemArray, 0, size-1);
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if(!hasNext()) throw new NoSuchElementException("No next element found");
			//not sure why its forcing me to cast here			
			//
			
			return (Item) itemArray[pointer++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	

public static void main(String[] args) {
	   // unit testing
		RandomizedQueue<Object> rq = new RandomizedQueue<Object>();
		
		rq.enqueue("1 ");
		rq.enqueue("2 ");
		rq.enqueue("3 ");
		rq.enqueue("4 ");
		rq.enqueue("5 ");
		rq.enqueue("6 ");
		rq.enqueue("7 ");
		System.out.println(rq.size);
		Iterator it = rq.iterator();
		System.out.println(it);
		Iterator it2 = rq.iterator();
		System.out.println(it2);
		while (it.hasNext()){
			System.out.print("iterator 1:");
			System.out.println(it.next()+" ");
		}
		while (it2.hasNext()){
			System.out.print("iterator 2:");
			System.out.println(it2.next()+" ");
		}	
		Object ob = rq.dequeue();
		System.out.println("\n"+ ob.toString());
		//Iterator it2 = rq.iterator();
//		while (it2.hasNext()){
//			System.out.print(it2.next()+" ");
		
		System.out.println(rq.sample().toString());
		Object ob1 = rq.dequeue();
		System.out.println("\n"+ ob1.toString());		
		while (it.hasNext()){
			System.out.print(it.next()+" ");
		}
}
	

}


