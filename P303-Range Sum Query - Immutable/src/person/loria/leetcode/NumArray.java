package person.loria.leetcode;

public class NumArray {

	int[] array;
	int[] sums;
	int toCalculate = 1;

	public NumArray(int[] nums) {
		array = nums;
		sums = new int[nums.length];
		if (nums.length < 1)
			return;
		sums[0] = array[0];
		
	}

	public int sumRange(int i, int j) {
		if (j - i < 10) {
			int sum = 0;
			for (int x = i; x <= j; x++) {
				sum += array[x];
			}
			return sum;
		}
		if (j >= toCalculate) {
			int temp = sums[toCalculate - 1];
			while (toCalculate <= j) {
				temp = array[toCalculate] + temp;
				sums[toCalculate] = temp;
				toCalculate++;
			}
		}

		if (i > 0)
			return sums[j] - sums[i - 1];
		else
			return sums[j];
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); int param_1 = obj.sumRange(i,j);
 */