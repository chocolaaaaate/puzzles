package puzzles.binarytreelist;

import java.util.LinkedList;
import java.util.Map;

public class BinaryNode {

	private BinaryNode left;
	private BinaryNode right;
	private int value;

	public BinaryNode(int value) {
		this.value = value;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	/**
	 * Populates the argument mapOfLists with a linked list of elements at each
	 * depth. The key of the map will be the depth (starting with 0).
	 * 
	 * To invoke this on an entire binary tree, call providing the root
	 * BinaryNode and a depth of 0.
	 * 
	 * @param node BinaryNode to process in the current iteration
	 * @param depth starting with 0
	 * @param mapOfLists see above
	 */
	public static void createMapOfOneListPerDepth(BinaryNode node, int depth,
			Map<Integer, LinkedList<BinaryNode>> mapOfLists) {
		if (node == null) {
			return;
		}
		if (mapOfLists.get(depth) == null) {
			mapOfLists.put(depth, new LinkedList<BinaryNode>());
		}
		mapOfLists.get(depth).add(node);
		depth++;
		createMapOfOneListPerDepth(node.getLeft(), depth, mapOfLists);
		createMapOfOneListPerDepth(node.getRight(), depth, mapOfLists);
		depth--;
		return;
	}

}
