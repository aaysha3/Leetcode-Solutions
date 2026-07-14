import java.util.*;

class Solution {
    private Map<Integer, Integer> map;
    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        preIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = helper(preorder, left, mid - 1);
        root.right = helper(preorder, mid + 1, right);
        return root;
    }
}
