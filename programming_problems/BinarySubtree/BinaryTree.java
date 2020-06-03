public class BinaryTree<E> {

    private BNode<E> root;
    private int size;

    public static void main(String[] args) {
        BinaryTree<Integer> b1 = new BinaryTree<>();
        b1.root = new BNode<>(10);
        b1.root.left = new BNode<>(12);
        b1.root.right = new BNode<>(14);
        b1.root.left.left = new BNode<>(16);
        b1.root.left.right = new BNode<>(18);
        b1.root.right.left = new BNode<>(20);
        b1.root.right.right = new BNode<>(22);
        b1.root.right.right.right = new BNode<>(23);

        BinaryTree<Integer> b2= new BinaryTree<>();
        b2.root = new BNode<>(14);
        b2.root.left = new BNode<>(20);
        b2.root.right = new BNode<>(22);

        System.out.println("Result = " + b1.isSubtree(b2));
    }

    public boolean isSubtree(BinaryTree<E> other) {
        if(this.size < other.size)
            return false;
        return findRoot(root, other.root);
    }

    private boolean findRoot(BNode<E> thisN, BNode<E> otherN) {
        if (otherN == null || thisN == null) {
            return false;
        }
        // Check if these two nodes are equal
        boolean equal = thisN.data.equals(otherN.data);
        if (equal) {
            if (containsAllNodes(thisN, otherN))
                return true;
        }
        boolean trySkipping = findRoot(thisN.left, otherN) || findRoot(thisN.right, otherN);
        return trySkipping;
    }

    private boolean containsAllNodes(BNode<E> thisTreeStart, BNode<E> otherNode) {
        if (otherNode == null)
            return true;
        if (thisTreeStart == null)
            return false;
        return thisTreeStart.data.equals(otherNode.data) && containsAllNodes(thisTreeStart.left, otherNode.left)
                && containsAllNodes(thisTreeStart.right, otherNode.right);
    }

    private static class BNode<E> {
        E data;
        BNode<E> left, right;

        public BNode(E data) {
            this.data = data;
        }
    }
}