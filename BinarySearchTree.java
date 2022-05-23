package bst;


import org.w3c.dom.Node;

import javax.swing.tree.TreeNode;

public class BinarySearchTree <T extends Comparable<T>> implements iTree<T>{

    //fields....
    private Node root;
    private int size = 0;

    @Override
    public void add(T... elements) {
        for (T element : elements){
            add(element);
        }
    }

    @Override
    public boolean add(T element) {
       // start searching at the root for a place to
        // add the input parameter
        int savedSize = size;
      root =  add(root, element);

        return savedSize != size;
    }

    // add() is supported by a private recursive method

    private Node add(Node current, T element){
        // base case (we found a null reference, a place to put
        // our new node
        if (current == null){
            size++;
           return new Node(element);
        }


        // use the comparable interface to compare the current
        // node to the inserted element
        int compare = current.data.compareTo(element);
        if ( compare < 0){ // search to the right
            current.right = add(current.right, element);

        }
        else if( compare > 0){ //search to the left
            current.left = add(current.left, element);
        }
       // return the current node
        return current;

    }

    @Override
    public boolean contains(T element) {

        return contains(root, element);
    }

    public boolean contains(Node current, T element){
        if (current == null){
           // size++;
            return false;}

        int compares = current.data.compareTo(element);

        if (compares >0){
            return contains(current.left, element);
        }

        else if (compares < 0){
            return contains(current.right, element);
        }

        else {
            return true;
        }
        }


    @Override //this code is unknown
    public boolean remove(T element) {
        // remove(root, element);
         return false;
    }



   public boolean remove(Node current, T element){
        if (current == null){
            return false;
        }
        int compare = current.data.compareTo(element);

        if (compare < 0){
            return remove(current.right, element); //remove right
        }

        else if (compare > 0){
            return remove(current.left, element); //remove left
        }

        else {
            return false;
        }


    }



    private TreeNode remove (TreeNode current, T element){

        // we didn't find the element in the tree (base case)

        if (current == null) {
            return null;
        }
        int comparison = current.data.compareTo(element);

        if (comparison < 0){ // right

            current.right = remove(current.right, element);
        }

        else if (comparison > 0){ // left

            current.left = remove(current.left, element);
        }

        else { /// if comparison == 0

                /// we found it, let's remove it!

            // no children
            if (current.left == null && current.right == null){
                    return null;
            }

            // left child

            else if (current.right == null){
                return current.left;
            }
            // right child

            else if (current.left == null ){

            }
            // two children
            else {


            }
        }

    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    private class Node{
        private T data;
        private Node left;
        private Node right;

        public Node(T data){
            this.data = data;
        }

        public Node( T data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;

        }

        @Override
        public String toString() {
           String leftChild = (left == null) ? "null" : left.data.toString();
           String rightChild = (right == null) ? "null" : right.data.toString();

           return leftChild + " <--" + data.toString() + "-->" + rightChild;
        }
    }


}
