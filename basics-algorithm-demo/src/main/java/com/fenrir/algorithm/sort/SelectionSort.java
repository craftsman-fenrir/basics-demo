package com.fenrir.algorithm.sort;

/**
 * 选择排序
 * @author fenrir
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = getArray();
		
		array = selectionSort(array);
		
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
	 * 选择排序
	 * @param array
	 * @return
	 */
	private static int[] selectionSort(int[] array) {
		// 临时目标的下标和值
		int minIndex, minValue;
		
		// 遍历排序，除最后一位（最高位）
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			// 初始化当前最小值下标
			minIndex = i;
			// 从最小值下标开始，找到相对最小值下标
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			// 把最小值放到前面
			minValue = array[i];
			array[i] = array[minIndex];
			array[minIndex] = minValue;
		}
		
		return array;
	}
	
}