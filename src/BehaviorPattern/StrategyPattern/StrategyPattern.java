package BehaviorPattern.StrategyPattern;

import java.util.ArrayList;
import java.util.List;

public class StrategyPattern {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(3);
		nums.add(1);
		nums.add(2);
		Sorting sorting = new BubbleSort();
		sorting.sorting(nums);
	}

}

interface Sorting {
	public List<Integer> sorting(List<Integer> nums);
}

class BubbleSort implements Sorting {
	@Override
	public List<Integer> sorting(List<Integer> nums) {
		System.out.print("start buble sorting");
		return nums;
	}
}

class HeapSort implements Sorting {
	@Override
	public List<Integer> sorting(List<Integer> nums) {
		System.out.print("start heap sorting");
		return nums;
	}
}