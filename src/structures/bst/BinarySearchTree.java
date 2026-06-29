package structures.bst;

public class BinarySearchTree<T extends Comparable<T>> {

    private BSTNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Método público para insertar
    public void insert(T data) {
        root = insert(root, data);
    }

    // Método recursivo privado
    private BSTNode<T> insert(BSTNode<T> node, T data) {

        if (node == null) {
            return new BSTNode<>(data);
        }

        int comparacion = data.compareTo(node.getData());

        if (comparacion < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (comparacion > 0) {
            node.setRight(insert(node.getRight(), data));
        }

        // Si es igual, no inserta duplicados
        return node;
    }
}
