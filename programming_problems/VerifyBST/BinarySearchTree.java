public class BinarySearchTree<E extends Comparable<? super E>>{

    private BSTNode<E> root;
    private int size;

    public boolean verifyBST(){
        if(root == null)
            return size == 0;
        int[] nodeCount = new int[1];
        boolean valid = validHelper(root, nodeCount, getMin(), getMax());
        return valid && nodeCount[0] == size;
    }

    public boolean validHelper(BSTNode<E> n, int[] nodeCount, E min, E max){
        if(n == null)
            return true;
        nodeCount[0]++;
        if(nodeCount[0] > size)
            return false;
        if(n.data.compareTo(min) <= 0 || n.data.compareTo(max) >= 0)
            return false;
        if(n.left != null && n.data.compareTo(n.left.data) <= 0)
            return false;
        if(n.right != null && n.data.compareTo(n.right.data) >= 0)
            return false;
        return validHelper(n.left, nodeCount, min, n.data) && validHelper(n.right, nodeCount, n.data, max);
    }

    private E getMax(){
        BSTNode<E> n;
        for(n = root; n.right != null; n = n.right){}
        return n.data;
    }

    private E getMin(){
        BSTNode<E> n;
        for(n = root; n.left != null; n = n.left){}
        return n.data;
    }

    private static class BSTNode<E extends Comparable<? super E>>{
        private E data;
        private BSTNode<E> left, right;
    }

}