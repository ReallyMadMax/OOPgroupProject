package appDomain;

import java.util.ArrayList;
import java.util.Arrays;

public class AppDriver
{

	public static Integer[] BubbleSort(Integer[] list) {
		boolean sorted = false;
		int tmp;
	
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.length; i++) {
				if (list[i-1] < list[i]) {
					tmp = list[i-1];
					list[i-1] = list[i];
					list[i] = tmp;
					sorted = false;
				}
			}
		}
		return list;
	}

	public static Integer[] InsertionSort(Integer[] list) {
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		boolean added = false;
	
		for (int num : list) {
			added = false;
			if (sortedArray.isEmpty()) {
				sortedArray.add(num);
			} else {
				for (int i = 0; i < sortedArray.size(); i++) {
					if (num > sortedArray.get(i)) {
						sortedArray.add(i, num);
						added = true;
						break;
					}
				}
				if (!added) {
					sortedArray.add(num);
				}
			}
		}
		return sortedArray.toArray(new Integer[0]);
	}

	public static Integer[] SelectionSort(Integer[] list) {
		int largest;
		int tmp;
	
		for (int i = 0; i < list.length; i++) {
			tmp = list[i];
			largest = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] > list[largest]) {
					largest = j;
				}
			}
			list[i] = list[largest];
			list[largest] = tmp;
		}
		return list;
	}

	public static boolean Sorted(Integer[] list) {
		if (list.length == 1){
			return true;
		}

		for (int i = 0; i < list.length - 1; i++) {
			if (list[i] > list[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static Integer[] quickSort(Integer[] list) {
		if (list.length <= 1) {
			return list;
		}
	
		int pivotPos = list.length / 2;
		int pivotNum = list[pivotPos];
		Integer[] smallerValues = new Integer[list.length];
		Integer[] equalValues = new Integer[list.length];
		Integer[] largerValues = new Integer[list.length];
		int smallerCount = 0, equalCount = 0, largerCount = 0;
	
		for (int num : list) {
			if (num > pivotNum) {
				smallerValues[smallerCount++] = num;
			} else if (num == pivotNum) {
				equalValues[equalCount++] = num;
			} else {
				largerValues[largerCount++] = num;
			}
		}
	
		smallerValues = quickSort(Arrays.copyOf(smallerValues, smallerCount));
		largerValues = quickSort(Arrays.copyOf(largerValues, largerCount));
	
		System.arraycopy(smallerValues, 0, list, 0, smallerCount);
		System.arraycopy(equalValues, 0, list, smallerCount, equalCount);
		System.arraycopy(largerValues, 0, list, smallerCount + equalCount, largerCount);
	
		return list;
	}
	
	public static Integer[] heapSort(Integer[] list) {
		int len = list.length;
		
		// order heap once. len / 2 - 1 is the first guranteed non childless element
		for (int i = len / 2 - 1; i >= 0; i--) {
			heapify(list, i, len);
		}

		for (int i = len - 1; i > 0; i--) {
			//this swaps the largest value to the end of the list before beginning again
			int tmp = list[0];
			list[0] = list[i];
			list[i] = tmp;
			
			// Call heapify on reduced list
			heapify(list, 0, i);
		}
		
		return list;
	}

	/* the tree is definied by head = i, left child = i*2+1 and right child = i*2+2 
	 * head needs to be the largest of the three values by the time this is done
	 * heap size is similar to arraysize, it gets smaller as the sorted values are stored at
	 * end of the array. 
	*/
	public static void heapify(Integer[] list, int head, int heap_size) {
		System.out.println(Arrays.toString(list));
		int smallest = head;
		int l = 2 * head + 1;  // Left child
		int r = 2 * head + 2;  // Right child
		
		if (l < heap_size && list[l] < list[smallest])
        	smallest = l;
    
		if (r < heap_size && list[r] < list[smallest])
			smallest = r;
		
		
		if (smallest != head) {
			// Swap values
			int tmp = list[head];
			list[head] = list[smallest];
			list[smallest] = tmp;
			
			// Recursively heapify the affected sub-tree
			heapify(list, smallest, heap_size);
		}
	}

	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo001 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

		// refer to demo03 OfficeManager.java on how to create specific
		// objects using reflection from a String

		Integer[] tmpList = {1,5,1,6,7,2,2,34,2,432,43,2,1,7,675,0,345,3,2,4,5,3,234,2,111};

		heapSort(tmpList);
	}
}
