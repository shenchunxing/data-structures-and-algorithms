package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

	@Override
	protected void sort() {
		
//		for (int end = array.length - 1; end > 0; end--) {
//			int max = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				if (cmp(max, begin) <= 0) {
//					max = begin;
//				}
//			}
//			swap(max, end);
//		}
		
		for (int end = array.length - 1; end > 0; end--) {
			int max = 0;//默认最大的值下标是0
			for (int begin = 1; begin <= end; begin++) {
				if (cmp(max, begin) < 0) {
					max = begin; //重新记录最大值的下标
				}
			}
			swap(max, end);//只需要和最后的元素交换就行，选择排序每一轮只交换一次。
		}
		
		// 7 5 10 1 4 2 10 
	}

}
