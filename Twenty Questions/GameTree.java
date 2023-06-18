
import java.io.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree {
	private Node root;
	private Node current;

	private class Node {
		String val;
		Node left, right;

		public Node(String val) {
			this.val = val;
			left = right = null;
		}

		@Override
		public String toString() {
			return "" + this.val;
		}
	}

	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName this is the name of the file we need to import the game
	 *                 questions and answers from.
	 */
	public GameTree(String fileName) {
		Scanner input;
		try {
			input = new Scanner(new File(fileName));
			Node node;
			if (root == null)
				root = new Node(input.nextLine());
			preorder(input, root);
			current = root;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void preorder(Scanner input, Node currentNode) {
		if (!currentNode.val.contains("?"))
			return;
		if (input.hasNext()) {
			currentNode.left = new Node(input.nextLine());
			preorder(input, currentNode.left);
			currentNode.right = new Node(input.nextLine());
			preorder(input, currentNode.right);
		}
		return;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has the
	 * answer chicken, theGame.add("Does it swim?", "goose"); should change that
	 * node like this:
	 */
// -----------Feathers?-----------------Feathers?------
// -------------/----\------------------/-------\------
// ------- chicken  horse-----Does it swim?-----horse--
// -----------------------------/------\---------------
// --------------------------goose--chicken-----------
	/**
	 * @param newQ The question to add where the old answer was.
	 * @param newA The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA) {
		if (current != null) {
			Node node = new Node(current.val);
			current.val = newQ;
			current.left = new Node(newA);
			current.right = node;
		}

	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer() {
//TODO
		return (current.left == null && current.right == null); // replace
	}

	/**
	 * Return the data for the current node, which could be a question or an answer.
	 * Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		return this.current.val;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or right
	 * for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo == Choice.Yes&&current.left!=null)
			current = current.left;
		if (yesOrNo == Choice.No&&current.right!=null)
			current = current.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart() {
		current = root;
//TODO
	}

	@Override
	public String toString() {
//TODO
		return toString(root, 0);
	}

	private String toString(Node currentNode, int level) {
		String dash = "";
		for (int i = 0; i < level; i++)
			dash += "-";
		if (currentNode.right == null && currentNode.left == null) {
			return dash + currentNode.val + "\n";
		} else {
			return toString(currentNode.right, level + 1) + dash + currentNode.val + "\n"
					+ toString(currentNode.left, level + 1);
		}
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may have
	 * new questions added since the game started.
	 *
	 */
	public void saveGame() {
		String outputFileName = "animals.txt";
		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(new File(outputFileName));
			if(current!=null)
			diskFile.print(preorder(root));
			diskFile.close();
			
		} catch (IOException io) {
			System.out.println("Could not create file: " + outputFileName);
		}
//TODO
	}
	public String preorder(Node currentNode)
	{
			if (currentNode.right == null && currentNode.left == null) {
				return currentNode.val + "\n";
			} else 
				return currentNode.val + "\n" + preorder(currentNode.left) + preorder(currentNode.right);
			
	}
}