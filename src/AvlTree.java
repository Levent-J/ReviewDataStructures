/**
 * Created by levent_j on 16-10-16.
 */
public class AvlTree<T extends Comparable<? super T>> {

    private AvlNode<T> root;

    public AvlTree() {
        this.root = null;
    }


    private AvlNode<T> insert(T x,AvlNode<T> root){
        if (root==null){
            return new AvlNode<T>(x,null,null);
        }

        int compareResult = x.compareTo(root.element);
        if (compareResult<0){
            root.left=insert(x,root.left);
            if (height(root.left)-height(root.right)==2){
                if (compare(x,root.left.element)<0){
                    root=rotateWithLeftCihld(root);
                }else {
                    root=doubleWithLeftChild(root);
                }
            }
        }else {
            root.right=insert(x,root.right);
            if (height(root.right)-height(root.left)==2){
                if (compare(x,root.right.element)>0){
                    root=rotateWithRightCihld(root);
                }else {
                    root=doubleWithRightChild(root);
                }
            }
        }

        root.height=Math.max(height(root.left),height(root.right))+1;
        return root;
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> root) {
        root.right=rotateWithLeftCihld(root.right);
        return rotateWithRightCihld(root);
    }

    private AvlNode<T> rotateWithRightCihld(AvlNode<T> root) {
        AvlNode<T> newRoot=root.right;
        root.right=newRoot.left;
        newRoot.left=root;
        root.height=Math.max(height(root.left),height(root.right))+1;
        newRoot.height=Math.max(height(newRoot.left),root.height)+1;
        return newRoot;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> root) {
        root.left=rotateWithRightCihld(root.left);
        return rotateWithLeftCihld(root);
    }

    private AvlNode<T> rotateWithLeftCihld(AvlNode<T> root) {
        AvlNode<T> newRoot=root.left;
        root.left=newRoot.right;
        newRoot.right=root;
        root.height=Math.max(height(root.left),height(root.right))+1;
        newRoot.height=Math.max(height(newRoot.left),root.height)+1;
        return newRoot;
    }

    private int compare(T x, T element) {
        return x.compareTo(element);
    }

    private int height(AvlNode<T> node){
        return node==null?-1:node.height;
    }

    public void printTree(){
        if (isEmpty()){
            System.out.print("树是空的");
        }else {
            printTree(root);
        }
    }

    public void insert(T x){
        root=insert(x,root);
    }

    private boolean isEmpty() {
        return root==null;
    }

    private void printTree(AvlNode<T> root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.element+"|");
            printTree(root.right);
        }
    }
    private static class AvlNode<T>{
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
        public AvlNode(T element) {
            this(element,null,null);
        }

        public AvlNode(T element, AvlNode<T> lt, AvlNode<T> rt) {
            this.element=element;
            left=lt;
            right=rt;
        }
    }
}
