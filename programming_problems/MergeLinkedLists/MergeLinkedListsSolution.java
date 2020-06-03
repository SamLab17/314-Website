

/*public class LinkedList314<E extends Comparable<? super E>>{

	public Node<E> first;
	public Node<E> last;
	public int size;
	
	private class Node<E>{
		private E data;
		private Node<E> next;
	}

	public void merge(LinkedList314<E> other){
		Node<E> thisNode = first;
		Node<E> otherNode = other.first;
		while(thisNode != null && otherNode != null){
			int comp = thisNode.data.compareTo(otherNode.data);
			if(comp <= 0){
				thisNode = thisNode.next;
			} else{
				Node<E> temp = thisNode.next;
				thisNode.next = otherNode;
				otherNode.next = temp;
				otherNode = otherNode.next;
			}
		}
		Node<E> restOfList;
		if(thisNode == null && otherNode != null)
			restOfList = otherNode;
		else
			return;
		
		last.next = otherNode;
		while(last.next != null)
			last = last.next;

		size += other.size;
	}

}
*/