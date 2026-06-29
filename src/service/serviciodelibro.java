package service;
import model.Book;
import model.LoanRequest;
import java.util.ArrayList;
import java.util.List;

public class serviciodelibro
{
  private final List<libro> catalogo = new Arraylist<>();
  
  private final List<solicitudprestamo> coladeprestamo = new Arraylist<>();

  public boolean registrarlibro(libro libro) {
        if (encontrarporcodigo(libro.getcodigo()) != null) {
            System.out.println("ya existe un libro con el código: " + libro.getcodigo());
            return false;
        }
        catalogo.add(libro);
        System.out.println("libro registrado exitosamente: " + libro.gettitulo());
        return true;
  
}
