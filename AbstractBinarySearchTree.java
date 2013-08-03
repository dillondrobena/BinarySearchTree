
public abstract class AbstractBinarySearchTree<E> implements BinarySearchTree<E>{
	protected int size = 0;

	protected AbstractBinarySearchTree(){
	}

	public void insert(E e) {
		insert(e);
	}

	public void makeEmpty() {
		// TODO Auto-generated method stub

	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void remove(E e) {
		// TODO Auto-generated method stub

	}

	public E findMax() {
		// TODO Auto-generated method stub
		return null;
	}

	public E findMin() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return size;
	}

}
