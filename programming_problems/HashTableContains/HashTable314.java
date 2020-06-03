public class HashTable314<E>{

    private static final int INITIAL_CAPACITY = 10;

    private BucketNode<E>[] con;
    private int size;

    public HashTable314(){
        con = (BucketNode<E>[]) (new BucketNode[INITIAL_CAPACITY]);
    }

    public boolean contains(E val){
        int index = Math.abs(val.hashCode() % con.length);
        return bucketContains(val, con[index]);
    }

    public boolean bucketContains(E val, BucketNode<E> n){
        if(n == null)
            return false;
        return n.data.equals(val) || bucketContains(val, n.next);
    }

    private static class BucketNode<E>{
        private E data;
        private BucketNode<E> next;
    }
}