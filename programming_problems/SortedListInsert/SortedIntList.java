import java.util.*;
public class SortedIntList {

    private int size;
    private int[] con;

    public SortedIntList(){
        con = new int[10];
        size = 0;
    }

    public static void main(String[] args){
        SortedIntList l = new SortedIntList();
        l.insert(3);
        l.insert(1);
        l.insert(2);
        l.insert(6);
        l.insert(5);
        l.insert(4);
        l.insert(0);
        System.out.println(Arrays.toString(l.con));
    }

    public void insert(int val){
        if(con.length == size){
            int[] newCon = new int[con.length * 2 + 1];
            for(int i = 0; i < con.length; i++)
                newCon[i] = con[i];
            con = newCon;
        }
        int index = 0;
        while(index < size && con[index] < val)
            index++;
        for(int i = size; i > index; i--){
            con[i] = con[i-1];
        }
        con[index] = val;
        size++;
    }

}