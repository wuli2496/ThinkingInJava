package algo.test;

import java.util.List;

import org.junit.Test;

import algo.TreeTraversalAlgo;
import algo.TreeTraversalAlgo.TreeNode;

public class TreeTraveralAlgoTest {
	
	@Test
	public void testPostOrder() {
		TreeNode<Integer> node1 = new TreeNode<>(1);
		TreeNode<Integer> node2 = new TreeNode<>(2);
		TreeNode<Integer> node3 = new TreeNode<>(3);
		node1.setRight(node2);
		node2.setLeft(node3);
		
		List<Integer> result = TreeTraversalAlgo.postOrder(node1);
		System.out.println(result);
		
	}
}
