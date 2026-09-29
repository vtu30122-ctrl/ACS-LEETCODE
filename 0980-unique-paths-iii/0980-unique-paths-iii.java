class Solution {

    int rows, cols;
    int paths = 0;

    public int uniquePathsIII(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        int startRow = 0;
        int startCol = 0;
        int empty = 0;

        // Find start and count non-obstacle cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != -1) {
                    empty++;
                }

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        dfs(grid, startRow, startCol, empty);

        return paths;
    }

    private void dfs(int[][] grid, int r, int c, int empty) {

        // Outside the grid or obstacle
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || grid[r][c] == -1) {
            return;
        }

        // Reached the ending cell
        if (grid[r][c] == 2) {
            if (empty == 1) {
                paths++;
            }
            return;
        }

        // Mark current cell as visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        // Move in 4 directions
        dfs(grid, r + 1, c, empty - 1); // Down
        dfs(grid, r - 1, c, empty - 1); // Up
        dfs(grid, r, c + 1, empty - 1); // Right
        dfs(grid, r, c - 1, empty - 1); // Left

        // Backtrack
        grid[r][c] = temp;
    }
}