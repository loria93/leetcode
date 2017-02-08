package person.loria.leetcode;

import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {

	List<List<Integer>> lists = null;
	int i = 0, j = 0;

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		lists.add(v1);
		lists.add(v2);
		internalConstructor(lists);
	}

	public void internalConstructor(List<List<Integer>> _lists) {
		lists = _lists;
		i--;
		findNext();
	}

	public int next() {
		if (lists.size() == 0)
			return 0;
		int result = lists.get(i).get(j).intValue();
		findNext();
		return result;
	}

	private void findNext() {
		boolean flag = true;
		while (flag && lists.size() > 0) {
			i++;
			if (i >= lists.size()) {
				i = 0;
				j++;
			}
			if (j >= lists.get(i).size()) {
				lists.remove(i);
				i--;
				continue;
			}
			flag = false;
		}
	}

	public boolean hasNext() {
		if (lists.size() > 0)
			if (lists.get(i).size() > j)
				return true;
		return false;
	}
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */
