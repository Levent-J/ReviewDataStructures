/**
 * Created by levent_j on 16-10-16.
 */
public class Main {
    public static void main(String[] args){
        AvlTree<Integer> tree = new AvlTree<Integer>();
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(3);
        tree.insert(5);
        tree.insert(15);
        tree.insert(7);
        tree.insert(16);
        tree.insert(14);
        tree.insert(0);
        tree.insert(11);
        tree.insert(3);
        tree.printTree();

    }
}
