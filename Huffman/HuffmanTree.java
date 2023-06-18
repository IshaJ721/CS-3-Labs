import java.io.*;
import java.util.*;
import java.util.Map.*;

public class HuffmanTree {
	Node root;
	HashMap<Integer, String> map;

	public HuffmanTree(int[] counts) {
		map = new HashMap<Integer, String>();
		Queue<Node> pq = new PriorityQueue<Node>();
		for (int i = 0; i < counts.length; i++) {
			Node node = new Node(counts[i]);
			node.value = i;
			if (counts[i] > 0)
				pq.add(node);
		}
		Node EOF = new Node(1);
		EOF.value = 256;
		pq.add(EOF);
		while (pq.size() != 1) {
			Node x = pq.poll();
			Node y = pq.poll();
			Node root = new Node(x.frequency + y.frequency);
			root.left = x;
			root.right = y;
			pq.add(root);
		}
		root = pq.peek();
		TreePrinter tp = new TreePrinter();
		tp.printTree(root);
	}

	public void write(String fileName) {
		PrintWriter diskFile = null;
		try {
			diskFile = new PrintWriter(new File(fileName + ".code"));
			writeHelper(diskFile, root, "");
			diskFile.close();
		} catch (IOException io) {
			System.out.println("Could not create file: " + fileName + ".code");
		}
	}

	public void writeHelper(PrintWriter pr, Node current, String code) {
		if (current.right == null && current.left == null) {
			pr.println(current.value);
			pr.println(code);
			map.put(current.value, code);
		} else if (current.right == null)
			writeHelper(pr, current.left, code + "0");
		else if (current.left == null)
			writeHelper(pr, current.right, code + "1");
		else {
			writeHelper(pr, current.left, code + "0");
			writeHelper(pr, current.right, code + "1");
		}
	}

	public void encode(BitOutputStream out, String filename) {
		try {
			Scanner input = new Scanner(new File(filename+".txt"));
			while (input.hasNext()) {
				char[] s = input.nextLine().toCharArray();
				for (char c : s) {
					String hc = map.get((int)c);
							while(hc.length()>0) {
								out.writeBit(Integer.parseInt(hc.substring(0,1)));
								hc=hc.substring(1);
					}
				}
			}
			String eof = findEOF(root, "");
			while(eof.length()>0)
			{
				out.writeBit(Integer.parseInt(eof.substring(0,1)));
				eof = eof.substring(1);
			}
			out.close();
		} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private String findEOF(Node current, String hc)
	{
		if (current.right == null && current.left == null&&current.value==256) 
			return hc;
		if(current.right==null && current.left==null)
			return "";
		else if (current.right == null)
			return findEOF(current.left, hc + "0");
		else if (current.left == null)
			return findEOF(current.right, hc + "1");
		else {
			return findEOF(current.left, hc + "0") + findEOF(current.right, hc + "1");
		}
	}

	public HuffmanTree(String codeFile) {
		root = new Node(1);
		try {
			Scanner input = new Scanner(new File(codeFile));
			do{
				int val = Integer.parseInt(input.nextLine());
				String freq = input.nextLine();
				Node current = root;
				while (freq.length() > 1) {
					int path = Integer.parseInt(freq.substring(0, 1));
					if (path == 0) {
						if (current.left == null)
							current.left = new Node(1);
						current = current.left;
					}
					if (path == 1) {
						if (current.right == null)
							current.right = new Node(1);
						current = current.right;
					}
					freq = freq.substring(1);
				}
				if (freq.equals("1")) {
					current.right = new Node(1);
					current.right.value = val;
				}
				if (freq.equals("0")) {
					current.left = new Node(1);
					current.left.value = val;
				}
			}
			while(input.hasNextLine());
		} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TreePrinter tp = new TreePrinter();
		tp.printTree(root);
		}

	public void decode(BitInputStream in, String outFile) {
		PrintWriter diskFile = null;
			try {
				diskFile = new PrintWriter(new File(outFile));
				Node current = root;
				while (true) {
					while (current.right != null && current.left != null) {
						int path = in.readBit();
						if (path == 1)
							current = current.right;
						if (path == 0)
							current = current.left;
					}
					if(current.value==256)
						break;
					System.out.print((char)current.value);
					diskFile.print((char)current.value);
					current = root;
				}
				diskFile.close();
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

