
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ModifiedBinarySearchTree<E extends Comparable> extends AbstractBinarySearchTree<E> {
	private BinaryNode<E> root;
	private Scanner inputFile;
	public ModifiedBinarySearchTree(){
	}
	@SuppressWarnings("unchecked")
	public void treeInput(String f, Class<?> c) throws FileNotFoundException{
		File file = new File(f);
		inputFile = new Scanner(file);
		while (inputFile.hasNext()){
			if (c == Integer.class){
				insert((E)Integer.valueOf(inputFile.next()));
			}
			if (c == Double.class) {
				insert((E)Double.valueOf(inputFile.next()));
			}
		}
	}
	@Override
	public void insert(E e) {
		BinaryNode<E> current = root;
		if (root == null){
			BinaryNode<E> newNode = new BinaryNode<E>(e);
			root = newNode;
			size++;
		}
		else {
			for(int i = 0; i < size; i++){
				if (e.compareTo(current.element) < 0){
					if (current.left == null) {
						current.left = new BinaryNode<E>(e);
						size++;
						break;
					}
					else {
						current = current.left;
					}
				}
				if (e.compareTo(current.element) > 0){
					if (current.right == null){
						current.right = new BinaryNode<E>(e);
						size++;
						break;
					}
					else {
						current = current.right;
					}
				}
			}
		}
	}
	@Override
	public void makeEmpty() {
		root = root.left = root.right = null;
		size = 0;
	}
	@Override
	public boolean contains(E e){
		boolean contains = false;
		if (size != 0) {
			BinaryNode<E> current = root;
			if (current.element.equals(e)){
				contains = true;
			}
			else {
				for (int i = 0; i < size; i++){
					if (e.compareTo(current.element) < 0 && current.left != null){
						if (current.left.element.equals(e)) {
							contains = true;
							break;
						}
						else {
							current = current.left;
						}
					}
					if (e.compareTo(current.element) > 0 && current.right != null){
						if (current.right.element.equals(e)){
							contains = true;
							break;
						}
						else {
							current = current.right;
						}
					}
				}
			}
		}
		return contains;
	}

	public BinaryNode<E> find(E e){
		BinaryNode<E> current = root;
		if (current.equals(e)){
			return current;
		}
		else {
			for (int i = 0; i < size; i++){
				if (e.compareTo(current.element) < 0){
					if (current.left == e) {
						return current.left;
					}
					else {
						current = current.left;
					}
				}
				if (e.compareTo(current.element) > 0){
					if (current.right == e){
						return current.right;
					}
					else {
						current = current.right;
					}
				}
			}
		}
		return null;
	}
	@Override
	public boolean isEmpty(){
		return root == null;
	}
	@Override
	public void remove(E e){
		BinaryNode<E> current = root;
		if (current.element.equals(e)){
			if (current.left == null && current.right == null) {
				root = null;
				size--;
			}
			if (current.left != null) {
				BinaryNode<E> tempNode = current.left;
				BinaryNode<E> subTempNode = tempNode;
				while (tempNode.right != null) {
					subTempNode = tempNode;
					tempNode = tempNode.right;
				}
				tempNode.right = current.right;
				BinaryNode<E> tempChild = tempNode.left;
				if (current.left != tempNode) {
					tempNode.left = current.left;
				}
				if (subTempNode.right == tempNode) {
					subTempNode.right = null;
				}
				current = tempNode;
				root = current;
				if (tempChild != null){
					insert(tempChild.element);
				}
				size--;
			}
			else {
				if (current.right != null) {
					BinaryNode<E> tempNode = current.right;
					BinaryNode<E> subTempNode = tempNode;
					while (tempNode.left != null) {
						subTempNode = tempNode;
						tempNode = tempNode.left;
					}
					tempNode.left = current.left;
					BinaryNode<E> tempChild = tempNode.right;
					if (current.right != tempNode) {
						tempNode.right = current.right;
					}
					if (subTempNode.left == tempNode) {
						subTempNode.left = null;
					}
					current = tempNode;
					root = current;
					if (tempChild != null) {
						insert(tempChild.element);
					}
					size--;
				}
			}
		}
		else {
			for (int i = 0; i < size; i++) {
				if (e.compareTo(current.element) < 0) {
					if (current.left.element.equals(e)){
						if (current.left.right != null) {
							BinaryNode<E> tempNode = current.left.right;
							BinaryNode<E> subTempNode = tempNode;
							while (tempNode.left != null) {
								subTempNode = tempNode;
								tempNode = tempNode.left;
							}
							tempNode.left = current.left.left;
							BinaryNode<E> tempChild = tempNode.right;
							if (current.left.right != tempNode) {
								tempNode.right = current.left.right;
							}
							current.left = tempNode;
							if (subTempNode.left == tempNode) {
								subTempNode.left = null;
							}
							if (tempChild != null) {
								insert(tempChild.element);
							}
							size--;
							break;
						}
						else {
							current.left = current.left.left;
							size--;
							break;
						}
					}
					else {
						current = current.left;
					}
				}
				if (e.compareTo(current.element) > 0) {
					if (current.right.element.equals(e)) {
						if (current.right.left != null) {
							BinaryNode<E> tempNode = current.right.left;
							BinaryNode<E> subTempNode = tempNode;
							while (tempNode.right != null) {
								subTempNode = tempNode;
								tempNode = tempNode.right;
							}
							tempNode.right = current.right.right;
							BinaryNode<E> tempChild = tempNode.left;
							if (current.right.left != tempNode) {
								tempNode.left = current.right.left;
							}
							current.right = tempNode;
							if (subTempNode.right == tempNode) {
								subTempNode.right = null;
							}
							if (tempChild != null) {
								insert(tempChild.element);
							}
							size--;
							break;
						}
						else {
							current.right = current.right.right;
							size--;
							break;
						}
					}
					else {
						current = current.right;
					}
				}
			}
		}
	}
	@Override
	public E findMax() {
		if (size != 0) {
			BinaryNode<E> current = root;
			while (current.right != null) {
				current = current.right;
			}
			return current.element;
		}
		return null;
	}
	@Override
	public E findMin() {
		if (size != 0) {
			BinaryNode<E> current = root;
			while (current.left != null) {
				current = current.left;
			}
			return current.element;
		}
		return null;
	}

	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		BinaryNode(E e) { 
			this(e, null, null);
		}

		BinaryNode(E e, BinaryNode<E> lt, BinaryNode<E> rt) { 
			element = e; left = lt; right = rt;
		}
	}
}
