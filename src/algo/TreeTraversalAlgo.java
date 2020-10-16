package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TreeTraversalAlgo {
	
	private TreeTraversalAlgo() {}
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class TreeNode<T> {
		private T val;
		private TreeNode<T> left;
		private TreeNode<T> right; 
		
		public TreeNode(T v) {
			val = v;
		}
	}
	
	public static <T> List<T> postOrder(TreeNode<T> root) {
		List<T> result = new ArrayList<>(); 
		if (root == null) {
			return result;
		}
		
		Stack<TreeNode<T>> stack = new Stack<>();
		stack.add(root);
		TreeNode<T> prevNode = null; 
		while (!stack.isEmpty()) {
			TreeNode<T> curNode = stack.peek();
			
			if ((curNode.left == null && curNode.right == null) 
					|| (prevNode != null && prevNode == curNode.right) 
					|| (prevNode != null && curNode.right == null && prevNode == curNode.left)) {
				curNode = stack.pop();
				result.add(curNode.getVal());
				prevNode = curNode;
			} else {
				if (curNode.left != null) {
					stack.add(curNode.left);
				}
				
				if (curNode.right != null) {
					stack.add(curNode.right);
				}
			}
		}
		return result;
	}
}
