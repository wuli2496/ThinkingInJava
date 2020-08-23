package datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
  
    public static TreeNode createTree(Integer[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		
		TreeNode root = new TreeNode();
		int i = 0;
		root.val = nums[i++];
		Queue<TreeNode> queue = new LinkedList<>(); 
		queue.add(root);
		
		while (i < nums.length) {
			TreeNode node = queue.poll();
			if (node == null) {
				continue;
			}
			
			if (nums[i] != null) {
				node.left = new TreeNode(nums[i++]);
			} else {
				++i;
			}
			
			if (i >= nums.length) {
				break;
			}
			
			if (nums[i] != null) {
				node.right = new TreeNode(nums[i++]);
			} else {
				++i;
			}
			queue.add(node.left);
			queue.add(node.right);
		}
		
		return root;
	}
}
