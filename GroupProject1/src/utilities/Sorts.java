package utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import shapes.Shape;

public class Sorts {
    public static Shape[] bubbleSort(Shape[] list, Comparator<Shape> comparator) {
    boolean sorted = false;
    Shape tmp;
    while (!sorted) {
        sorted = true;
        for (int i = 1; i < list.length; i++) {
            // Changed < to > for descending order
            if (comparator.compare(list[i - 1], list[i]) > 0) {
                // Swap elements
                tmp = list[i - 1];
                list[i - 1] = list[i];
                list[i] = tmp;
                sorted = false;
            }
        }
    }
    return list;
}

    public static Shape[] InsertionSort(Shape[] list, Comparator<Shape> comparator) {
        for (int i = 1; i < list.length; i++) {
            Shape key = list[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(key, list[j]) < 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
        return list;
    }

    public static Shape[] SelectionSort(Shape[] list, Comparator<Shape> comparator) {
        int largest;
        Shape tmp;

        for (int i = 0; i < list.length; i++) {
            tmp = list[i];
            largest = i;
            for (int j = i + 1; j < list.length; j++) {
                // Changed from > 0 to < 0 for descending order
                if (comparator.compare(list[j], list[largest]) < 0) {
                    largest = j;
                }
            }
            list[i] = list[largest];
            list[largest] = tmp;
        }
        return list;
    }

    public static Shape[] quickSort(Shape[] list, Comparator<Shape> comparator) {
        if (list.length <= 1) {
            return list;
        }

        int pivotPos = list.length / 2;
        Shape pivotShape = list[pivotPos];
        Shape[] smallerValues = new Shape[list.length];
        Shape[] equalValues = new Shape[list.length];
        Shape[] largerValues = new Shape[list.length];
        int smallerCount = 0, equalCount = 0, largerCount = 0;

        for (Shape shape : list) {
            // Compare shapes using comparator
            int compareResult = comparator.compare(shape, pivotShape);
            if (compareResult > 0) {
                smallerValues[smallerCount++] = shape;
            } else if (compareResult == 0) {
                equalValues[equalCount++] = shape;
            } else {
                largerValues[largerCount++] = shape;
            }
        }

        // Recursively sort subarrays
        smallerValues = quickSort(Arrays.copyOf(smallerValues, smallerCount), comparator);
        largerValues = quickSort(Arrays.copyOf(largerValues, largerCount), comparator);

        // Changed order: largerValues first, then equal, then smaller for descending order
        System.arraycopy(largerValues, 0, list, 0, largerCount);
        System.arraycopy(equalValues, 0, list, largerCount, equalCount);
        System.arraycopy(smallerValues, 0, list, largerCount + equalCount, smallerCount);

        return list;
    }

    public static Shape[] heapSort(Shape[] list, Comparator<Shape> comparator) {
        int len = list.length;

        // order heap once. len / 2 - 1 is the first guaranteed non childless element
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(list, comparator, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            // this swaps the largest value to the end of the list before beginning again
            Shape tmp = list[0];
            list[0] = list[i];
            list[i] = tmp;

            // Call heapify on reduced list
            heapify(list, comparator, 0, i);
        }

        return list;
    }

    /*
     * the tree is defined by head = i, left child = i*2+1 and right child = i*2+2
     * head needs to be the largest of the three values by the time this is done
     * heap size is similar to arraysize, it gets smaller as the sorted values are
     * stored at
     * end of the array.
     */
    public static void heapify(Shape[] list, Comparator<Shape> comparator, int head, int heap_size) {
        int largest = head; // Changed from smallest to largest for descending order
        int l = 2 * head + 1; // Left child
        int r = 2 * head + 2; // Right child

        // Changed comparisons to use comparator
        // For descending order, we want the larger value to be the parent
        if (l < heap_size && comparator.compare(list[l], list[largest]) > 0)
            largest = l;

        if (r < heap_size && comparator.compare(list[r], list[largest]) > 0)
            largest = r;

        if (largest != head) {
            // Swap values
            Shape tmp = list[head];
            list[head] = list[largest];
            list[largest] = tmp;

            // Recursively heapify the affected sub-tree
            heapify(list, comparator, largest, heap_size);
        }
    }

    public static Shape[] mergeSort(Shape[] list, Comparator<Shape> comparator) {
        // Base case - if list has 1 or fewer elements, it's already sorted
        if (list.length <= 1) {
            return list;
        }

        int middle = list.length / 2;

        Shape[] left = new Shape[middle];
        Shape[] right = new Shape[list.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = list[i];
        }

        for (int i = middle; i < list.length; i++) {
            right[i - middle] = list[i];
        }

        left = mergeSort(left, comparator);
        right = mergeSort(right, comparator);

        return merge(left, right, list, comparator);
    }

    private static Shape[] merge(Shape[] left, Shape[] right, Shape[] originalArray, Comparator<Shape> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        // Compare elements from both arrays and merge
        while (leftIndex < left.length && rightIndex < right.length) {
            if (comparator.compare(left[leftIndex], right[rightIndex]) < 0) {  // Change this for ascending/descending
                originalArray[resultIndex] = left[leftIndex];
                leftIndex++;
            } else {
                originalArray[resultIndex] = right[rightIndex];
                rightIndex++;
            }
            resultIndex++;
        }

        while (leftIndex < left.length) {
            originalArray[resultIndex] = left[leftIndex];
            leftIndex++;
            resultIndex++;
        }

        while (rightIndex < right.length) {
            originalArray[resultIndex] = right[rightIndex];
            rightIndex++;
            resultIndex++;
        }

        return originalArray;
    }
}
