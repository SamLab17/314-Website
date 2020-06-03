public class HashSet314<E>{
    private static final int INITIAL_CAPACITY = 10;
    private static final Object EMPTY = new Object();

    //All objects in this array are guaranteed to be null, EMPTY, or of type E
    private Object[] con;
    private int size;

    public HashSet314(){
        con = (E[]) new Object[INITIAL_CAPACITY];
    }

    public boolean add(E val){
        return true;
    }

    public HashSet314<E> difference(HashSet314<E> otherSet){
        HashSet314<E> result = new HashSet314<>();
        int numVisited = 0;
        for(int i = 0; i < con.length && numVisited < size; i++) {
            if(con[i] != null && con[i] != EMPTY){
                numVisited++;
                if(!otherSet.contains(con[i]))
                    result.add((E) con[i]); //Gacky cast, but necessary
            }
        }
        return result;
    }

    private boolean contains(Object val){
        int index = Math.abs(val.hashCode() % con.length);
        int numVisited = 0;
        while(con[index] != null && !con[index].equals(val) 
            && numVisited < con.length){
            numVisited++;
            index = (index + 1) % con.length;
        }
        return val.equals(con[index]);
    }
}