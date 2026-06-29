package test;

import structures.bst.BinarySearchTree;

public class TestBST {

    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        System.out.println("¿El árbol está vacío? " + tree.isEmpty());

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.println("\nRecorrido InOrder:");
        tree.inOrder();

        System.out.println("\nCantidad de nodos: " + tree.count());

        System.out.println("\nBuscar 40:");
        System.out.println(tree.search(40));

        System.out.println("\nBuscar 90:");
        System.out.println(tree.search(90));

        System.out.println("\nEliminar 20");
        tree.delete(20);

        System.out.println("\nRecorrido después de eliminar:");
        tree.inOrder();

    }

}
