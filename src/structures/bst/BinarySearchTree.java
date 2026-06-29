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
    // Método público para buscar un elemento
    public T search(T data) {
        BSTNode<T> result = search(root, data);
    
        if (result == null) {
            return null;
        }
    
        return result.getData();
    }
    
    // Método recursivo privado
    private BSTNode<T> search(BSTNode<T> node, T data) {
    
        if (node == null) {
            return null;
        }
    
        int comparacion = data.compareTo(node.getData());
    
        if (comparacion == 0) {
            return node;
        }
    
        if (comparacion < 0) {
            return search(node.getLeft(), data);
        }
    
        return search(node.getRight(), data);
    }
   
    // Método público para recorrer el árbol en inorden
    public void inOrder() {
        inOrder(root);
    }

    // Método recursivo privado
    private void inOrder(BSTNode<T> node) {

        if (node != null) {

            inOrder(node.getLeft());

            System.out.println(node.getData());

            inOrder(node.getRight());

        }
    }  
    // Método público para contar los nodos del árbol
    public int count() {
        return count(root);
    }

    // Método recursivo privado
    private int count(BSTNode<T> node) {

        if (node == null) {
            return 0;
        }

        return 1 + count(node.getLeft()) + count(node.getRight());
    }
    
    // Método público para eliminar un elemento
    public void delete(T data) {
        root = delete(root, data);
    }

    // Método recursivo privado
    private BSTNode<T> delete(BSTNode<T> node, T data) {

        if (node == null) {
            return null;
        }

        int comparacion = data.compareTo(node.getData());

        if (comparacion < 0) {

            node.setLeft(delete(node.getLeft(), data));

        } else if (comparacion > 0) {

            node.setRight(delete(node.getRight(), data));

        } else {

            // Caso 1: no tiene hijo izquierdo
            if (node.getLeft() == null) {
                return node.getRight();
            }

            // Caso 2: no tiene hijo derecho
            if (node.getRight() == null) {
                return node.getLeft();
            }

            // Caso 3: tiene dos hijos
            BSTNode<T> successor = findMin(node.getRight());

            node.setData(successor.getData());

            node.setRight(delete(node.getRight(), successor.getData()));
        }

        return node;
    }
    // Obtiene el menor elemento del subárbol
    private BSTNode<T> findMin(BSTNode<T> node) {

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }
}
