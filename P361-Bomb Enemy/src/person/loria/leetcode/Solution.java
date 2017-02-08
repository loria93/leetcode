package person.loria.leetcode;

public class Solution {
	public int maxKilledEnemies(char[][] grid) {
		int rows = grid.length, cols;
		if (rows > 0) {
			cols = grid[0].length;
		} else
			return 0;

		int[] maxCol = new int[cols];
		for (int i = 0; i < cols; i++)
			maxCol[i] = -1;
		int maxRow = -1, maxEnemies = 0;
		for (int i = 0; i < rows; i++) {
			maxRow = -1;
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 'W') {
					maxRow = -1;
					maxCol[j] = -1;
					continue;
				} else {
					if (maxRow == -1) {
						int enemies = 0;
						for (int k = j; k < cols; k++) {
							if (grid[i][k] == 'E')
								enemies++;
							if (grid[i][k] == 'W')
								break;
						}
						maxRow = enemies;
					}
					if (maxCol[j] == -1) {
						int enemies = 0;
						for (int k = i; k < rows; k++) {
							if (grid[k][j] == 'E')
								enemies++;
							if (grid[k][j] == 'W')
								break;
						}
						maxCol[j] = enemies;
					}
					if (grid[i][j] == '0')
						maxEnemies = Math.max(maxEnemies, maxRow + maxCol[j]);
				}
			}
		}
		return maxEnemies;
	}
}