package edu.neu.coe.info6205.sort.simple;

public class HeapSort<X extends Comparable<X>> implements Sort<X> {

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public HeapSort(Helper<X> helper) {
        this.helper = helper;
    }

    public HeapSort() {
        this(new Helper<>("HeapSort"));
    }

    @Override
    public void sort(X[] array, int from, int to) {
        if (array == null || array.length <= 1) {
				return;
			}
 
			buildMaxHeap(array);
 
			for (int i = array.length - 1; i >= 1; i--) {
				X temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				maxHeap(array, i, 0);
 
				maxHeap(array, i, 0);
			}
    }
    private  void buildMaxHeap(X[] array) {
			if (array == null || array.length <= 1) {
				return;
			}
 
			int half = array.length / 2;
			for (int i = half; i >= 0; i--) {
				maxHeap(array, array.length, i);
			}
		}
 
		private  void maxHeap(X[] array, int heapSize, int index) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;
 
			int largest = index;
			if (left < heapSize && helper.compare(array[index],array[left])<0) {
				largest = left;
			}
 
			if (right < heapSize && helper.compare(array[largest],array[right])<0 ) {
				largest = right;
			}
 
			if (index != largest) {
				helper.swap(array, index, largest);
 
				maxHeap(array, heapSize, largest);
			}
		}

    @Override
    public String toString() {
        return helper.toString();
    }

    @Override
    public Helper<X> getHelper() {
        return helper;
    }

    private final Helper<X> helper;
}
