/**
 * Created by levent_j on 16-10-16.
 */
public class Main {
    public static void main(String[] args){
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(8);
        tree.printTree();
        System.out.println();
        tree.remove(2);
        tree.printTree();

    }
}
