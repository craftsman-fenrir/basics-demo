package com.fenrir.algorithm.sort;

/**
 * 插入排序
 * 应用场景：把新数据插入到有序的序列
 * 原理：
 * 1、把所有元素两两比较，把最大的放在最后
 * 2、把剩余的元素两两比较，较大的放下一位
 * 3、重复第二步，直至只剩一个数
 * @author fenrir
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] array = getArray();
		
		array = insertionSort(array);
		
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
	 * 插入排序
	 * @param array
	 * @return
	 */
	private static int[] insertionSort(int[] array) {
		int comparisonIndex, minValue;
		
		// 待插入下标从第二位开始
		int length = array.length;
		for (int i = 1; i < length; i++) {
			// 初始化最小值小标
			comparisonIndex = i - 1;
			// 初始化待插入下标的值
	        minValue = array[i];
	        while (comparisonIndex >= 0 && array[comparisonIndex] > minValue) {
	            array[comparisonIndex + 1] = array[comparisonIndex];
	            comparisonIndex--;
	        }
	        array[comparisonIndex + 1] = minValue;
		}
		
		return array;
	}
	
}