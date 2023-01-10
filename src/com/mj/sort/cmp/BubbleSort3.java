package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class BubbleSort3<T extends Comparable<T>> extends Sort<T> {

	//尾部提前有序
	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;//记录最后一次交换的位置
			for (int begin = 1; begin <= end; begin++) {
				// if (array[begin] < array[begin - 1]) {
				if (cmp(begin, begin - 1) < 0) {
					swap(begin, begin - 1);
					sortedIndex = begin;
				}
			}
			end = sortedIndex; //下一次循环，直接从最后一次交换的位置结束，因为后面已经有序
		}
	}

}
