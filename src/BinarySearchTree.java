import java.nio.BufferUnderflowException;

/**
 * Created by levent_j on 16-10-16.
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public BinarySearchTree() {
        root=null;
    }

    public void makeEmpty(){
        root=null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public boolean contains(T x){
        return contains(x,root);
    }



    public T findMax(){
        if (isEmpty())throw new BufferUnderflowException();
        return findMax(root).element;
    }


    public T findMin(){
        if (isEmpty())throw new BufferUnderflowException();
        return findMin(root).element;
    }


    public void insert(T x){
        root=insert(x,root);
    }


    public void remove(T x){
        root=remove(x,root);
    }
    public void printTree(){
        if (isEmpty()){
            System.out.print("树是空的");
        }else {
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.element);
            printTree(root.right);
        }
    }


    private BinaryNode<T> remove(T x, BinaryNode<T> root) {
        if (root==null){
            return root;
        }
        int compareResult=x.compareTo(root.element);
        if (compareResult<0){
            root.left=remove(x,root.left);
        }else if (compareResult>0){
            root.right=remove(x,root.right);
        }else if (root.left!=null&&root.right!=null){
            root.element=findMin(root.right).element;
            root.right=remove(root.element,root.right);
        }else {
            root=(root.left==null)?root.right:root.left;
        }
        return root;
    }

    private boolean contains(T x, BinaryNode<T> root) {
        if (root==null){
            return false;
        }
        int compareResult=x.compareTo(root.element);
        if (compareResult<0){
            return contains(x,root.left);
        }else if (compareResult>0){
            return contains(x,root.right);
        }else {
            return true;
        }
    }

    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root==null){
            return null;
        }else if (root.right==null){
            return root;
        }else {
            return findMax(root.right);
        }
    }
    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root==null){
            return null;
        }else if (root.left==null){
            return root;
        }else {
            return findMin(root.left);
        }
    }
    private BinaryNode<T> insert(T x, BinaryNode<T> root) {
        if (root==null){
            return new BinaryNode<T>(x,null,null);
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult<0){
            BinaryNode node = insert(x,root.left);
            root.left=node;
        }else {
            BinaryNode node = insert(x,root.right);
            root.right=node;
        }
        return root;
    }
    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T element){
            this.element=element;
        }

        BinaryNode(T element,BinaryNode<T> lt,BinaryNode<T> rt){
            this.element=element;
            left=lt;
            right=rt;
        }
    }
}
