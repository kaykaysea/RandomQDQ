
public class Subset {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = Integer.parseInt(args[0]);
		RandomizedQueue<String> randQ = new RandomizedQueue<String>();
		
		while(!StdIn.isEmpty()){
			randQ.enqueue(StdIn.readString());		
			
		}
		for(int i=0;i<num;i++){
			System.out.println(randQ.dequeue());
		}

	}

}
