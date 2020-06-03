import java.util.*;

public class List314<E> {

    private int size;
    private E[] con;

    public List314(){
        con = (E[]) new Object[100];
    }

    private void resize(){
        E[] newCon = (E[]) new Object[con.length * 2];
        for(int i = 0; i < size; i++)
            newCon[i] = con[i];
        con = newCon;
    }

    public void add(E obj){
        if (size == con.length - 1)
            resize();
        con[size] = obj;
        size++;
    }

    public void addAll(E[] arr){
        for(E x : arr)
            add(x);
    }

    public E mostFrequent(){
        HashMap<E, Integer> freqs = new HashMap<E, Integer>();
        E mostSeen = null;
        int maxFreq = -1;
        for(int i = 0; i < size; i++){
            int freq = freqs.getOrDefault(con[i], 0);
            freq++;
            freqs.put(con[i], freq);
            if(freq > maxFreq){
                mostSeen = con[i];
                maxFreq = freq;
            }
        }
        return mostSeen;
    }

    public String toString(){
        if(size == 0)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < size - 1; i++){
            sb.append(con[i].toString());
            sb.append(", ");
        }
        sb.append(con[size - 1]);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        List314<Integer> list = new List314<>();
        list.addAll(new Integer[]{3, 1, 4});
        System.out.println(list);
        System.out.println("Most frequent = " + list.mostFrequent());

        List314<String> sList = new List314<>();
        sList.addAll(new String[]{"A", "B", "C", "A", "B", "A", "BB"});
        System.out.println(sList);
        System.out.println("Most frequent = " + sList.mostFrequent());
 
    }

}