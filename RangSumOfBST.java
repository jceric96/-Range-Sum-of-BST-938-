import java.util.*;

//leetcode 938
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

public class RangSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current.val >= L && current.val <= R) {
                    sum += current.val;
                }
                if (current.left != null) {
                    queue2.offer(current.left);
                }
                if (current.right != null) {
                    queue2.offer(current.right);
                }
            }
            queue = queue2;
        }
        return sum;
    }

    public static void main(String[] args) {
        RangSumOfBST bst = new RangSumOfBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.left = null;
        root.right.right = new TreeNode(18);
        System.out.println(bst.rangeSumBST(root, 7, 15));
    }
}
