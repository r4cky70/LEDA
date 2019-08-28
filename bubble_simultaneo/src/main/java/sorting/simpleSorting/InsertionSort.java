package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		T temp;
		for(int j = leftIndex; j <= rightIndex; ++j){
			temp = array[j];
			int i = j;
			while(--i >= leftIndex){
				if(array[i].compareTo(temp) > 0){
					array[i+1] = array[i];
				}else{
					break;
				}

			}
			array[i+1] = temp;
		}
	}
}
