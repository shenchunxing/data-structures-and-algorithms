package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class InsertionSort1<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;//当前待排序的位置
			while (cur > 0 && cmp(cur, cur - 1) < 0) { //让到begin位置为止的序列有序
				swap(cur, cur - 1);
				cur--;
			}
		}
	}

}
