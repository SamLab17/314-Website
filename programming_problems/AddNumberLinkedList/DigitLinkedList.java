public class DigitLinkedList{

    DigitNode first;
    int size;

    public DigitLinkedList(int value){
        if(value == 0){
            first = new DigitNode(0, null);
            size = 0;
            return;
        }
        size = 0;
        while(value > 0){
            first = new DigitNode(value % 10, first);
            size++;
            value /= 10;
        }
    }

    public String toString(){
        if(first == null){
            return "null";
        }
        String s = "";
        DigitNode n = first;
        while(n.next != null){
            s += n.digit + " -> ";
            n = n.next;
        }
        s += n.digit;
        return s;
    }

    public void addVal(int value){
        //Once we've updated the existing nodes, we may need to create new nodes
        //if the number we create is too large to fit in the number of nodes we had
        //in the beginning
        int overflow = helper(first, value);
        while(overflow > 0){
            first = new DigitNode(overflow % 10, first);
            overflow /= 10;
        }
    }   
    
    private int helper(DigitNode n, int valToAdd){
        int carry = valToAdd;
        if(n.next != null){
            carry = helper(n.next, valToAdd);
        }
        int sum = n.digit + carry;
        n.digit = sum % 10;
        return sum / 10;
    }

    private static class DigitNode{
        private int digit;
        private DigitNode next;
        private DigitNode(int d, DigitNode n){
            digit = d;
            next = n;
        }
    }

    public static void main(String[] args){
        DigitLinkedList d = new DigitLinkedList(0);
        System.out.println(d);
        d.addVal(314);
        System.out.println(d);

    }
}