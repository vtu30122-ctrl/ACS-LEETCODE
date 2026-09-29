class Solution {

    int moves = 0;

    public int distributeCoins(TreeNode root) {
        moves = 0;
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        moves += Math.abs(left);
        moves += Math.abs(right);

        // Balance of this subtree
        return node.val + left + right - 1;
    }
}