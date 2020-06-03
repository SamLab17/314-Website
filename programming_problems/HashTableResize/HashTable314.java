public class HashTable314<E>{

    private static final int INITIAL_CAPACITY = 10;

    private BucketNode<E>[] con;
    private int size;

    public HashTable314(){
        con = (BucketNode<E>[])(new Object[INITIAL_CAPACITY]);
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

    private int resize(){
        BucketNode<E>[] temp = (BucketNode<E>[]) new Object[con.length * 2];
        int largestChange = 0;
        for(int i=0; i < con.length; i++){
            while(con[i] != null){
                BucketNode<E> n = con[i];
                con[i] = n.next;
                int index = Math.abs(n.data.hashCode() % temp.length);
                n.next = temp[index];
                temp[index] = n;

                //Find largest change
                int change = Math.abs(i - index);
                largestChange = Math.max(largestChange, change);
            }
        }
        return largestChange;

    }

    private static class BucketNode<E>{
        private E data;
        private BucketNode<E> next;
    }
}