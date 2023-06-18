
public class MyBST {
	private BSTNode root;

	private class BSTNode {
		Integer val;
		BSTNode left, right;

		public BSTNode(Integer val) {
			this.val = val;
			left = right = null;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}
	}

	public int size() {
		if (root != null)
			return size(root);
		return 0;
	}

	private int size(BSTNode current) {
		if (current == null)
			return 0;
		else
			return 1 + size(current.right) + size(current.left);
	}

	public void insert(int data) {
		this.root = insert(this.root, data);
	}

	private BSTNode insert(BSTNode node, int data) {
		if (node == null)
			node = new BSTNode(data);
		else {
			if (data <= node.val)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}

	public boolean contains(Integer n) {
		if (root != null)
			return contains(n, root);
		return false;
	}

	private boolean contains(Integer n, BSTNode current) {
		if (current.val == n) {
			return true;
		}
		if (current.right == null && current.left == null)
			return false;
		else {
			if (n > current.val)
				return contains(n, current.right);
			else
				return contains(n, current.left);
		}
	}

	public Integer getMax() {
		if (root != null)
			return getMax(root);
		return null;
	}

	private Integer getMax(BSTNode current) {
		if (current.right != null || current.left != null)
			return getMax(current.right);
		return current.val;
	}

	public Integer getMin() {
		if (root != null)
			return getMin(root);
		return null;
	}

	private Integer getMin(BSTNode current) {
		if (current.right != null || current.left != null)
			return getMin(current.left);
		return current.val;
	}

	public void delete(Integer n) {
		if (!contains(n) || root == null)
			return;
		else
			delete(root, null, n);
	}

	private void delete(BSTNode current, BSTNode parent, int n)
	{
		if(current==null)
			return;
		if(current.val==n&&current.right==null&&current.left==null)
		{
			if(parent.right==current)
				parent.right=null;
			if(parent.left==current)
				parent.left=null;
			}
		else if(current.val==n&&(current.right==null||current.left==null))
		{
			if(current.right==null&&parent.right==current)
				parent.right=current.left;
			if(current.right==null&&parent.left==current)
				parent.left=current.left;
			if(current.left==null&&parent.left==current)
				parent.left=current.right;
			if(current.left==null&&parent.right==current)
				parent.right=current.right;
		}
		else if(current.val==n)
		{
		BSTNode[] array = getMaxSubtree(current.left, null);
		current.val = array[0].val;
		if(array[0]==array[1].left)
			array[1].left = null;
		else
			array[1].right = null;
		}
		else
		{
		delete(current.right, current, n);
		delete(current.left, current, n);
		}
		}

	private BSTNode[] getMaxSubtree(BSTNode current, BSTNode parent) {
		if (current.right != null || current.left != null)
			return getMaxSubtree(current.right, current);
		BSTNode[] array = { current, parent };
		return array;
	}

	public void inOrder() {
		if (root != null)
			inOrder(root);
	}

	public void inOrder(BSTNode current) {
		if (current == null)
			return;
		else {
			inOrder(current.left);
			System.out.print(current.val + " ");
			inOrder(current.right);
		}
	}

	public void print() {
		if (root != null)
			print(root, 0);
	}

	public void print(BSTNode current, int level) {
		if (current == null)
			return;
		else {
			print(current.right, level + 1);
			String spaces = "";
			for (int i = 0; i < level; i++)
				spaces += "    ";
			System.out.print(spaces);
			System.out.println(current);
			print(current.left, level + 1);
		}
	}
}
