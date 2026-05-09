class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            List<Integer> ring = extractRing(grid, layer, m, n);
            List<Integer> rotated = rotate(ring, k % ring.size());
            fillRing(grid, rotated, layer, m, n);
        }
        return grid;
    }

    private List<Integer> extractRing(int[][] grid, int l, int m, int n) {
        List<Integer> ring = new ArrayList<>();
        int top = l, bot = m - 1 - l, left = l, right = n - 1 - l;
        for (int c = left;   c <= right; c++) ring.add(grid[top][c]);
        for (int r = top+1;  r <= bot;   r++) ring.add(grid[r][right]);
        for (int c = right-1; c >= left; c--) ring.add(grid[bot][c]);
        for (int r = bot-1;  r > top;   r--) ring.add(grid[r][left]);
        return ring;
    }

    private List<Integer> rotate(List<Integer> ring, int k) {
        int n = ring.size();
        List<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));
        for (int i = 0; i < n; i++) res.set(i, ring.get((i + k) % n));
        return res;
    }

    private void fillRing(int[][] grid, List<Integer> ring, int l, int m, int n) {
        int top = l, bot = m - 1 - l, left = l, right = n - 1 - l, idx = 0;
        for (int c = left;   c <= right; c++) grid[top][c]   = ring.get(idx++);
        for (int r = top+1;  r <= bot;   r++) grid[r][right]  = ring.get(idx++);
        for (int c = right-1; c >= left; c--) grid[bot][c]   = ring.get(idx++);
        for (int r = bot-1;  r > top;   r--) grid[r][left]  = ring.get(idx++);
    }
}