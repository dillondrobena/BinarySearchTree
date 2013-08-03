import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestMyBinarySearchTree {
	public static void main(String[] args) throws FileNotFoundException{
		ModifiedBinarySearchTree<Integer> myTree = new ModifiedBinarySearchTree<Integer>();
		myTree.treeInput("C:\\Users\\Dillon\\Desktop\\DataStructures-Programming2\\InputA1.txt", Integer.class);
		System.out.println("Max value: " + myTree.findMax());
		System.out.println("Min value: " + myTree.findMin());
		File file = new File("C:\\Users\\Dillon\\Desktop\\DataStructures-Programming2\\InputB1.txt");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			Integer x = Integer.valueOf(f.next());
			if (myTree.contains(x)) {
				myTree.remove(x);
				System.out.println("key " + x + " is removed.");
			}
			else {
				System.out.println("key " + x + " is not in the tree.");
			}
		}
		ModifiedBinarySearchTree<Double> myTree1 = new ModifiedBinarySearchTree<Double>();
		myTree1.treeInput("C:\\Users\\Dillon\\Desktop\\DataStructures-Programming2\\InputA2.txt", Double.class);
		System.out.println("Max value: " + myTree1.findMax());
		System.out.println("Min value: " + myTree1.findMin());
		file = new File("C:\\Users\\Dillon\\Desktop\\DataStructures-Programming2\\InputB2.txt");
		f = new Scanner(file);
		while (f.hasNext()) {
			Double y = Double.valueOf(f.next());
			if (myTree1.contains(y)) {
				myTree1.remove(y);
				System.out.println("key " + y + " is removed.");
			}
			else {
				System.out.println("key " + y + " is not in the tree.");
			}
		}
	}
}
