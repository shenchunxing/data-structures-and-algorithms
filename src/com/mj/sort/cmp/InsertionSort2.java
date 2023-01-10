package com.mj.sort.cmp;
import com.mj.sort.Sort;

public class InsertionSort2<T extends Comparable<T>> extends Sort<T> {

	//减少交换次数，将交换变成挪动
	@Override
	protected void sort() {
		for (int begin = 1; begin < array.length; begin++) {
			int cur = begin;
			T v = array[cur];//待插入元素备份
			while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
				array[cur] = array[cur - 1];//移出1个位置给cur插入
				cur--;
			}
			array[cur] = v;//插入
		}
	}

}
