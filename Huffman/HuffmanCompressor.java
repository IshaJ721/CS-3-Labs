import java.io.*;
import java.util.*;

public class HuffmanCompressor {
	static int[] charFreq;

	public static void compress(String filename) {
		charFreq = new int[256];
		try {
			Scanner input = new Scanner(new File(filename + ".txt"));
			while (input.hasNextLine()) {
				String s = input.nextLine();
				for (int i = 0; i < s.toCharArray().length; i++) {
					charFreq[(int) s.charAt(i)]++;
				}
			}
		} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
//write encoding tree to file, generate compressed file
		HuffmanTree ht = new HuffmanTree(charFreq);
		ht.write(filename);
		ht.encode(new BitOutputStream(filename + ".short"), filename);
	}

	public static void main(String[] args) {
		compress("happy hip hop");
		expand("happy hip hop.code", "happy hip hop");
	}

	public static void expand(String codeFile, String fileName) {
		HuffmanTree ht = new HuffmanTree(codeFile);
		ht.decode(new BitInputStream(fileName+".short"), fileName+".new");

	}

}