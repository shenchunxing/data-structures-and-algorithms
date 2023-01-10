package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class InsertionSort3<T extends Comparable<T>> extends Sort<T> {

	
//	protected void sort() {
//		for (int begin = 1; begin < array.length; begin++) {
//			T v = array[begin];
//			int insertIndex = search(begin);
//			// 将 [insertIndex, begin) 范围内的元素往右边挪动一个单位
////			for (int i = begin - 1; i >= insertIndex; i--) {
////				
////			}
//			for (int i = begin; i > insertIndex; i--) {
//				array[i] = array[i - 1];
//			}
//			array[insertIndex] = v;
//		}
//	}
	
	@Override
	protected void sort() {
		for (int begin = 1; begin < array.length; begin++) {
			//将待插入的begin位置的值，插入到search(begin)的位置
			insert(begin, search(begin));
		}
	}
	
	/**
	 * source：待插入元素的索引
	 * dest：待插入的元素通过二分搜索找到的插入位置
	 */
	private void insert(int source, int dest) {
		//记录下当前的值，移动后需要插入到指定位置
		T v = array[source];
		for (int i = source; i > dest; i--) { //腾出目标位置
			array[i] = array[i - 1];
		}
		array[dest] = v;//插入
	}
	
	/**
	 * 利用二分搜索找到 index 位置元素的待插入位置
	 * 已经排好序数组的区间范围是 [0, index)
	 */
	private int search(int index) {
		int begin = 0;
		int end = index;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (cmp(array[index], array[mid]) < 0) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return begin;
	}
}
