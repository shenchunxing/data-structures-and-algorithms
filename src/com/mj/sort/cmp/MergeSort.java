package com.mj.sort.cmp;
import com.mj.sort.Sort;

@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
	private T[] leftArray;

	@Override
	protected void sort() {
		leftArray = (T[]) new Comparable[array.length >> 1];
		sort(0, array.length);
	}
	
	// T(n) = T(n/2) + T(n/2) + O(n)
	
	/**
	 * 对 [begin, end) 范围的数据进行归并排序
	 */
	private void sort(int begin, int end) {
		if (end - begin < 2) return;
		
		int mid = (begin + end) >> 1;
		sort(begin, mid); //归并左侧
		sort(mid, end); //归并右侧
		merge(begin, mid, end);
	}
	
	/**
	 * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
	 */
	private void merge(int begin, int mid, int end) {
		int li = 0, le = mid - begin;//左侧开始的位置和结束的位置
		int ri = mid, re = end; //右侧开始的位置和结束的位置
		int ai = begin;//可以填充的位置
		
		// 因为涉及到覆盖，需要备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		// 如果左边还没有结束
		while (li < le) {
			///右侧还没结束，同时右侧 < 左侧，则将右侧的值放到数组，同时ai++，ri++
			if (ri < re && cmp(array[ri], leftArray[li]) < 0) {
				array[ai++] = array[ri++];
			} else {//右侧已经结束，or  右侧还没结束，但是右侧 > 左侧。则左侧的数据直接填充到数组
				array[ai++] = leftArray[li++];
			}
		}
	}
}
