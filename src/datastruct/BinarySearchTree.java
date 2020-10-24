package datastruct;

public class BinarySearchTree<T extends Comparable<? super T>> {
	public BinarySearchTree() {
		root = null;
	}
	
	public void makeEmpty() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public boolean contains(T x) {
		return contains(root, x);
	}
	
	public T findMin() {
		if (isEmpty()) {
			throw new RuntimeException("empty");
		}
		
		return findMin(root).element;
	}
	
	public T findMax() {
		if (isEmpty()) {
			throw new RuntimeException("empty");
		}
		
		return findMax(root).element;
	}
	
	public void insert(T x) {
		root = insert(root, x);
	}
	
	public void remove(T x) {
		root = remove(root, x);
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private boolean contains(BinaryNode<T> node, T key) {
		if (node == null) {
			return false;
		}
		
		int x = key.compareTo(node.element);
		if (x < 0) {
			return contains(node.left, key);
		} else if (x > 0) {
			return contains(node.right, key);
		}
		
		return true;
	}
	
	private BinaryNode<T> findMin(BinaryNode<T> node) {
		if (node == null) {
			return null;
		}
		
		if (node.left == null) {
			return node;
		}
		
		return findMin(node.left);
	}
	
	private BinaryNode<T> findMax(BinaryNode<T> node) {
		if (node == null) {
			return null;
		}
		
		if (node.right == null) {
			return node;
		}
		
		return findMax(node.right);
	}
	
	private BinaryNode<T> insert(BinaryNode<T> node, T t) {
		if (node == null) {
			return new BinaryNode<>(t, null, null);
		}
		
		int x = t.compareTo(node.element);
		if (x < 0) {
			node.left = insert(node.left, t);
		} else if (x > 0) {
			node.right = insert(node.right, t);
		} else {
			;
		}
		
		return node;
	}
	
	private BinaryNode<T> remove(BinaryNode<T> node, T x) {
		if (node == null) {
			return null;
		}
		
		int cmp = x.compareTo(node.element);
		if (cmp < 0) {
			node.left = remove(node.left, x);
		} else if (cmp > 0) {
			node.right = remove(node.right, x);
		} else {
			if (node.left != null && node.right != null) {
				T tmp = findMin(node.right).element;
				node.element = tmp;
				node.right = remove(node.right, tmp);
			} else {
				node = (node.left != null) ? node.left : node.right;
			}
		}
		
		return node;
	}
	
	private void printTree(BinaryNode<T> node) {
		if (node == null) {
			return;
		}
		
		printTree(node.left);
		System.out.println(node.element);
		printTree(node.right);
	}
	
	private static class BinaryNode<T> {
		BinaryNode(T e) {
			this(e, null, null);
		}
		
		public BinaryNode(T e, BinaryNode<T> left, BinaryNode<T> right) {
			this.element = e;
			this.left = left;
			this.right = right;
		}
		
		T element;
		
		BinaryNode<T> left;
		BinaryNode<T> right; 
	}
	
	private BinaryNode<T> root;
	
}
