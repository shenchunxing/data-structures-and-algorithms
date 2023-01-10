package com.mj.sort.cmp;
import com.mj.sort.Sort;

@SuppressWarnings("unchecked")
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
	private T[] leftArray;

	@Override
	protected void sort() {
		//需要暂时保存的最大元素数量就是总数组的一半
		leftArray = (T[]) new Comparable[array.length >> 1];
		sort(0, array.length);
	}
	
	// T(n) = T(n/2) + T(n/2) + O(n)
	
	/**
	 * 对 [begin, end) 范围的数据进行归并排序
	 * 分治 + 递归
	 */
	private void sort(int begin, int end) {
		if (end - begin < 2) return;//只剩下一个数据，退出合并

		int mid = (begin + end) >> 1;//每次的数据规模减半
		sort(begin, mid); //对 [begin, mid) 范围的数据进行归并排序
		sort(mid, end); //对 [mid, end) 范围的数据进行归并排序
		merge(begin, mid, end);//合并
	}
	
	/**
	 * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
	 */
	private void merge(int begin, int mid, int end) {
		//li:左侧数组开始的位置 le:左侧数组的长度
		int li = 0, le = mid - begin;
		//ri:右侧数组开始的位置 re:右侧数组的边界
		int ri = mid, re = end;
		//ai:可以填充的位置
		int ai = begin;
		
		// 备份左边数组
		for (int i = li; i < le; i++) {
			leftArray[i] = array[begin + i];
		}
		
		// 如果左边数组还没有结束
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
