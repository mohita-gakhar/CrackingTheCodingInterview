package tree;

/**
 * Min Binary heap
 * represented in array
 * root is in arr[0]
 * and for every ith node
 * arr[(i-1)/2] returns the parent node
 * arr[(2*i)+1] returns the left child
 * arr[(2*i)+2] returns the right child
 * @author Mohita
 *
 */
public class MinBinaryHeap {
	
	private int[] arr;
	private int size;
	private int capacity;
	
	public MinBinaryHeap(int capacity) {
		this.capacity=capacity;
		this.size=0;
		this.arr= new int[capacity];
	}
	
	public void insertKey(int key) {
		if(size==capacity) {
			System.out.println("Overflow Error");
			return;
		}
		int index = size;
		arr[size]=key;
		size++;
		while(index != 0 && arr[parent(index)] > arr[index]) {
			int parIndex = parent(index);
			int temp = arr[parIndex];
			arr[parIndex] = arr[index];
			arr[index] = temp;
			index = parIndex;
		}
	}
	
	//Decrease the value present at index to key
	//assumed that given key is less than original 
	public void decreaseKey(int index, int key) {
		arr[index] = key;
		while(index != 0 && arr[parent(index)] > arr[index]) {
			int parIndex = parent(index);
			int temp = arr[parIndex];
			arr[parIndex] = arr[index];
			arr[index] = temp;
			index = parIndex;
		}
	}
	
	public int extractMin() {
		if(size == 0) {
			return Integer.MAX_VALUE;
		}else if(size == 1) {
			size--;
			return arr[0];
		}
		int root = arr[0];
		arr[0] = arr[size-1];
		size--;
		minHeapify(0);
		return root;
	}
	
	public int deleteKey(int index) {
		decreaseKey(index, Integer.MIN_VALUE);
		return extractMin();
	}
	
	private void minHeapify(int index) {
		int left = left(index);
		int right = right(index);
		int smallest = index;
		if(left < size && arr[left] < arr[index]) {
			smallest = left;
		}
		if(right < size && arr[right] < arr[smallest]) {
			smallest = right;
		}
		if(smallest != index) {
			int temp = arr[smallest];
			arr[smallest] = arr[index];
			arr[index] = temp;
			minHeapify(smallest);
		}
	}

	public int parent(int index) {
		return (index-1)/2;
	}
	
	public int left(int index) {
		return (2*index)+1;
	}
	
	public int right(int index) {
		return (2*index)+2;
	}
	
	public int getMin() {
		return arr[0];
	}

	public static void main(String[] args) {
		MinBinaryHeap h = new MinBinaryHeap(11); 
	    h.insertKey(3); 
	    h.insertKey(2); 
	    h.deleteKey(1); 
	    h.insertKey(15); 
	    h.insertKey(5); 
	    h.insertKey(4); 
	    h.insertKey(45); 
	    System.out.println(h.extractMin() + " "); 
	    System.out.println(h.getMin() + " "); 
	    h.decreaseKey(2, 1); 
	    System.out.println(h.getMin()+" "); 
	}

}
