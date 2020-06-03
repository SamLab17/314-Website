package RemoveOddIndices;

import java.util.*;

public class GenericList<E> {

	//Instance variables
	private E[] con;
	private int size;

	//Constructor
	public GenericList(){
		con = (E[]) new Object[10];
		//size = 0
    }
    
    public GenericList(E[] elems){
        con = (E[]) new Object[elems.length * 2];
        for(int i = 0; i < elems.length; i++)
            con[i] = elems[i];
        size = elems.length;
    }

	//Resize method
	private void resize(){
		E[] temp = (E[]) new Object[con.length * 2];
		for(int i = 0; i < size; i++){
			temp[i] = con[i];
		}
		con = temp;
	}

	//Add method
	public void add(E o){
		if(size == con.length)
			resize();
		con[size] = o;
		size++;
	}
	
	public E get(int index){
		//check precons
		return con[index];
	}

	public int size(){
		return size;
	}

	public String toString(){
		//Don't actually do this on assignments, just
		//for demo purposes

		//Prints out the entire con array, not just size
		//elements to make sure that elements past size
		//are nulled out
		return Arrays.deepToString(con);
    }
    
    public int removeOddIndices(){
        int numToRemove = size / 2;
        if(numToRemove == 0)
            return 0;

        int indexToReplace = 1;
        for(int i = 2; i < size; i += 2){
            con[indexToReplace] = con[i];
            indexToReplace++;
        }
        int newSize = size - numToRemove;
        for(int i = newSize; i < size; i++){
            con[i] = null;
        }
        size = newSize;
        return numToRemove;
    }

	public static void main(String[] args){
        GenericList<Integer> l = new GenericList<>(new Integer[]{0, 1, 2, 3, 4, 5});
        System.out.println(l);
        l.removeOddIndices();
        System.out.println(l);
        l = new GenericList<>(new Integer[]{0, 7, 1, 7, 2, 7, 3, 7, 4, 7, 5});
        System.out.println(l);
        l.removeOddIndices();
        System.out.println(l);
    }
}
