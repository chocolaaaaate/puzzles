package puzzles.binarytreelist;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

public class TestBinaryTreeListMaker {

	@Test
	public void testMakeListPerDepthLevel() {
		
		// create tree as such
		//		     4                	Depth level = 0
		//		   /   \				
		//		  1     7				Depth level = 1
		//		 / \   / \
		//		8   9 2   5				Depth level = 2
		
		BinaryNode rootNode = new BinaryNode(4);
		BinaryNode node1Depth1 = new BinaryNode(1);
		BinaryNode node2Depth1 = new BinaryNode(7);
		BinaryNode node1Depth2 = new BinaryNode(8);
		BinaryNode node2Depth2 = new BinaryNode(9);
		BinaryNode node3Depth2 = new BinaryNode(2);
		BinaryNode node4Depth2 = new BinaryNode(5);

		// Constructing depth 0
		rootNode.setLeft(node1Depth1);
		rootNode.setRight(node2Depth1);

		// Constructing depth 1
		node1Depth1.setLeft(node1Depth2);
		node1Depth1.setRight(node2Depth2);

		node2Depth1.setLeft(node3Depth2);
		node2Depth1.setRight(node4Depth2);

		Map<Integer, LinkedList<BinaryNode>> mapOfLists = new HashMap<Integer, LinkedList<BinaryNode>>();

		BinaryNode.createMapOfOneListPerDepth(rootNode, 0, mapOfLists);
		
		assertEquals(mapOfLists.get(0).get(0).getValue(), 4);
		assertEquals(mapOfLists.get(0).size(), 1);
		
		assertEquals(mapOfLists.get(1).get(0).getValue(), 1);
		assertEquals(mapOfLists.get(1).get(1).getValue(), 7);
		assertEquals(mapOfLists.get(1).size(), 2);		
		
		assertEquals(mapOfLists.get(2).get(0).getValue(), 8);
		assertEquals(mapOfLists.get(2).get(1).getValue(), 9);
		assertEquals(mapOfLists.get(2).get(2).getValue(), 2);
		assertEquals(mapOfLists.get(2).get(3).getValue(), 5);
		assertEquals(mapOfLists.get(2).size(), 4);
		
	}
	

}
