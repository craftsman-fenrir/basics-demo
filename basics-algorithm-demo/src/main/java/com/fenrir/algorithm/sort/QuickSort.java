package com.fenrir.algorithm.sort;

/**
 * 快速排序
 * @author fenrir
 *
 */
public class QuickSort {
	
	public static void main(String[] args) {
		int[] array = getArray();
		
		array = quickSort(array, 0, array.length - 1);
		
		int length = array.length;
		for (int i = 0; i < length; i++) {
			System.out.println(array[i]);
		}
	}

	/**
	 * 获取数组（乱序）
	 * @return
	 */
	private static int[] getArray() {
		return new int[]{32, 43, 23, 13, 5};
	}
	
	/**
	 * 快速排序
	 * @param array 乱序的数组
	 * @param beginIndex 从哪个下标开始排序
	 * @param endIndex 排序到哪个下标结束
	 * @return
	 */
	private static int[] quickSort(int[] array, int beginIndex, int endIndex) {
		if (beginIndex < endIndex) {
			int i = beginIndex, j = endIndex, x = array[beginIndex];
			
			while (i < j) {
				while (i < j && array[j] > x) {
					j--;
				}
				
				if (i < j) {
					array[i++] = array[j];
				}
				
				while (i < j && array[i] < x) {
					i++;
				}
				
				if (i < j) {
					array[j--] = array[i];
				}
			}
			
			array[i] = x;
			quickSort(array, beginIndex, i - 1);
			quickSort(array, i + 1, endIndex);
		}
		
		return array;
	}

}