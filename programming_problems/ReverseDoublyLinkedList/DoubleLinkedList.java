public class DoubleLinkedList<E> {

    private DoubleNode<E> head;
    private DoubleNode<E> tail;
    private int size;

    private void add(E data){
        if(data == null)
            throw new IllegalArgumentException("Cannot add null value to list");
        DoubleNode<E> newNode = new DoubleNode<>(tail, data, null);
        if(size == 0)
            head = newNode;
        else
            tail.next = newNode;
        tail = newNode;
        size++;
    }

    private void addAll(E[] values){
        if(values == null){
            throw new IllegalArgumentException("Cannot add null value to list");
        }
        for(E x : values)
            add(x);
    }

    private void clear(){
        head = tail = null;
        size = 0;
    }

    /*
     * Reverses the order of elements in this linked list
     * pre: none
     * post: oldSize == newSize, 'this' is reversed
     */
    private void reverseList(){
        DoubleNode<E> currNode = head;
        while(currNode != null){
            swapReferences(currNode);
            currNode = currNode.prev;
        }
        DoubleNode<E> oldHead = head;
        head = tail;
        tail = oldHead;
    }

    private void swapReferences(DoubleNode<E> n){
        DoubleNode<E> temp = n.next;
        n.next = n.prev;
        n.prev = temp;
    }

    public String toString() {
        if(size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        DoubleNode<E> curr = head;
        while (curr.next != null) {
            sb.append(curr.data.toString());
            sb.append(", ");
            curr = curr.next;
        }
        sb.append(curr.data.toString());
        sb.append("]");
        return sb.toString();
    }

    private static class DoubleNode<E> {
        private DoubleNode<E> prev, next;
        private E data;

        private DoubleNode(DoubleNode<E> prev, E data, DoubleNode<E> next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }


    public static void main(String[] args){
        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
        for(int i = 0; i <= 10; i++){
            dl.add(i);
        }
        System.out.println("Before: " + dl);
        dl.reverseList();
        System.out.println("After: " + dl);
        
        dl.clear();
        dl.add(0);
        System.out.println("Before: " + dl);
        dl.reverseList();
        System.out.println("After: " + dl);

        dl.clear();
        System.out.println("Before: " + dl);
        dl.reverseList();
        System.out.println("After: " + dl);
        
        for(int i = 0; i <= 100; i++){
            dl.add(i);
        }
        System.out.println("Before: " + dl);
        dl.reverseList();
        System.out.println("After: " + dl); 
    }
}