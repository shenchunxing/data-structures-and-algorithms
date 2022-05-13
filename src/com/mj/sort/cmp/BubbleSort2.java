package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class BubbleSort2<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		for (int end = array.length - 1; end > 0; end--) {
			boolean sorted = true; //查看是否已经提前有序，可以提前结束遍历
			for (int begin = 1; begin <= end; begin++) {
				// if (array[begin] < array[begin - 1]) {
				if (cmp(begin, begin - 1) < 0) {
					swap(begin, begin - 1);
					sorted = false; //存在交换，说明没有提前有序
				}
			}
			if (sorted) break; //已经有序，直接退出
		}
	}

}
