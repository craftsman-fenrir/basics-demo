package com.fenrir.algorithm.sort;

/**
 * 冒泡排序
 * 应用场景：一般不用
 * 原理：
 * 1、把所有元素两两比较，把最大的放在最后
 * 2、把剩余的元素两两比较，较大的放下一位
 * 3、重复第二步，直至只剩一个数
 * @author fenrir
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		int[] array = getArray();
		
		array = bubbleSort(array);
		
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
	 * 冒泡排序
	 * @param array
	 * @return
	 */
	private static int[] bubbleSort(int[] array) {
		// 对每一位进行排序，除了最后一位
		int length = array.length;
		for (int i = 0; i < length - 1; i++) {
			// 不处理最高位
			for (int j = 0; j < length - i - 1; j++) {
				// 对比当前下标跟下一位，当前位较大时跟下一位换位
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
				}
			}
		}
		
		return array;
	}
	
}