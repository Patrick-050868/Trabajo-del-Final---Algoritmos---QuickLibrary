package utils;

import model.EstadoLibro;
import model.Libro;
import service.BibliotecaService;

public class DatosIniciales {
    private DatosIniciales() {
      }

    public static void cargar(BibliotecaService biblioteca) {
        biblioteca.registrarLibro(new Libro(101, "Programacion en Java", "Herbert Schildt", "Programacion", 2022, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(102, "Estructuras de Datos", "Mark Allen Weiss", "Computacion", 2021, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(103, "Introduccion a los Algoritmos", "Thomas Cormen", "Algoritmos", 2022, EstadoLibro.PRESTADO));
        biblioteca.registrarLibro(new Libro(104, "Clean Code", "Robert C. Martin", "Programacion", 2008, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(105, "Effective Java", "Joshua Bloch", "Programacion", 2018, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(106, "Design Patterns", "Erich Gamma", "Software", 1994, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(107, "Sistemas Operativos Modernos", "Andrew Tanenbaum", "Sistemas", 2015, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(108, "Redes de Computadoras", "Andrew Tanenbaum", "Redes", 2012, EstadoLibro.PRESTADO));
        biblioteca.registrarLibro(new Libro(109, "Bases de Datos", "Abraham Silberschatz", "Bases de Datos", 2019, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(110, "Java Como Programar", "Paul Deitel", "Programacion", 2020, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(111, "Python Crash Course", "Eric Matthes", "Programacion", 2023, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(112, "The Pragmatic Programmer", "Andrew Hunt", "Software", 2019, EstadoLibro.PRESTADO));
        biblioteca.registrarLibro(new Libro(113, "Computer Organization", "David Patterson", "Arquitectura", 2021, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(114, "Artificial Intelligence", "Stuart Russell", "IA", 2021, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(115, "Machine Learning", "Tom Mitchell", "IA", 1997, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(116, "Compiladores", "Alfred Aho", "Lenguajes", 2007, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(117, "Calculo", "James Stewart", "Matematica", 2018, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(118, "Algebra Lineal", "Gilbert Strang", "Matematica", 2016, EstadoLibro.PRESTADO));
        biblioteca.registrarLibro(new Libro(119, "Discrete Mathematics", "Kenneth Rosen", "Matematica", 2019, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(120, "Operating System Concepts", "Abraham Silberschatz", "Sistemas", 2020, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(121, "Computer Networks", "James Kurose", "Redes", 2021, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(122, "Database System Concepts", "Henry Korth", "Bases de Datos", 2020, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(123, "Software Engineering", "Ian Sommerville", "Software", 2016, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(124, "Refactoring", "Martin Fowler", "Software", 2018, EstadoLibro.PRESTADO));
        biblioteca.registrarLibro(new Libro(125, "Head First Java", "Kathy Sierra", "Programacion", 2022, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(126, "Algorithms", "Robert Sedgewick", "Algoritmos", 2011, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(127, "Data Structures in Java", "Michael Goodrich", "Computacion", 2014, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(128, "Big Java", "Cay Horstmann", "Programacion", 2019, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(129, "Introduction to Databases", "Chris Date", "Bases de Datos", 2003, EstadoLibro.DISPONIBLE));
        biblioteca.registrarLibro(new Libro(130, "Deep Learning", "Ian Goodfellow", "IA", 2016, EstadoLibro.DISPONIBLE));
    }
}
