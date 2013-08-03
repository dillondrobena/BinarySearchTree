
public interface BinarySearchTree<E> {

	public void insert(E e);

	public void makeEmpty();

	public boolean contains(E e);

	public boolean isEmpty();

	public void remove(E e);

	public E findMax();

	public E findMin();

	public int size();
}
