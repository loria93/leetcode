package person.loria.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public class Visit {
		public int x, y, d;

		public Visit(int _x, int _y, int _d) {
			x = _x;
			y = _y;
			d = _d;
		}
	}

	public int shortestDistance(int[][] grid) {
		int m = grid.length;
		if (m == 0)
			return 0;
		int n = grid[0].length;
		List<Visit> queue = new LinkedList<Visit>();
		int[][] distances = new int[m][n];
		boolean[][] visited = new boolean[m][n];
		boolean[][] accessable = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				accessable[i][j] = true;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					for (int ii = 0; ii < m; ii++)
						for (int jj = 0; jj < n; jj++)
							visited[ii][jj] = false;
					for (int k = 0; k < 4; k++) {
						queue.add(new Visit(i + directions[k][0], j + directions[k][1], 1));
					}
					while (!queue.isEmpty()) {
						Visit visit = queue.remove(0);
						int x = visit.x, y = visit.y, d = visit.d;
						if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || grid[x][y] != 0)
							continue;
						visited[x][y] = true;
						distances[x][y] += d++;
						for (int k = 0; k < 4; k++) {
							queue.add(new Visit(x + directions[k][0], y + directions[k][1], d));
						}
					}
					for (int ii = 0; ii < m; ii++)
						for (int jj = 0; jj < n; jj++)
							accessable[ii][jj] = accessable[ii][jj] && visited[ii][jj];
				}
			}
		int minDistance = Integer.MAX_VALUE;
		boolean found = false;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					if (accessable[i][j] && distances[i][j] < minDistance) {
						found = true;
						minDistance = distances[i][j];
					}
				}
			}
		return found ? minDistance : -1;

	}
}