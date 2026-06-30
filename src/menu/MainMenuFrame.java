package menu;

import javax.swing.*;
import java.awt.*;

import service.BibliotecaService;
import service.PrestamoService;
import service.ReporteService;

public class MainMenuFrame extend JFrame {

  private BibliotecaService bibliotecaService;
  private PrestamoService prestamoService;
  private ReporteService reporteService;
  
  public MainMenuFrame() {
    bibliotecaService = new BibliotecaService();
    prestamoService = new PrestamoService();
    reporteService = new ReporteService();

    setTitle("QUICKLIBRARY");
    setSixe(500,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(12, 1, 5, 5));

    String[] options = {
                "1. Registrar libro",
                "2. Mostrar libros",
                "3. Buscar libro por código",
                "4. Buscar libros por categoría",
                "5. Modificar libro",
                "6. Eliminar libro",
                "7. Registrar solicitud de préstamo",
                "8. Mostrar cola de solicitudes",
                "9. Atender siguiente solicitud",
                "10. Registrar devolución",
                "11. Mostrar reporte",
                "12. Salir"
    };

    for (String option : options) {
        JButton btn = new JButton(option);
        panel.add(btn);

        btn.addActionListener(e -> {
            JoptionPane.showMessageDialog(this, option);
        }};
    }

    add(panel);
    setVisible(true);
  }

  private void ejecutar(String opcion) {
        switch (opcion) {
            case "Registrar libro":
              String codigo = JOptionPane.showInputDialog("Código:");
              String titulo = JOptionPane.showInputDialog("Título:");
              String autor = JOptionPane.showInputDialog("Autor:");
              String categoria = JOptionPane.showInputDialog("Categoría:");
              int anio = Integer.parseInt(JOptionPane.showInputDialog("Año:"));
          
              bibliotecaService.registrarLibro(codigo, titulo, autor, categoria, anio);
          
              JOptionPane.showMessageDialog(this, "Libro registrado");
              break;

            case "Mostrar libros":
              String libros = bibliotecaService.mostrarLibros();

              JTextArea area = new JTextArea(20, 40);
              area.setText(libros);
              area.setEditable(false);

              JOptionPane.showMessageDialog(this, new JScrollPane(area));
              break;
      
            case "Buscar libro por código":
              String codBuscar = JOptionPane.showInputDialog("Código:");
              String libro = bibliotecaService.buscarPorCodigo(codBuscar);

              JOptionPane.showMessageDialog(this, libro);
              break;

            case "Buscar libros por categoría":
              String cat = JOptionPane.showInputDialog("Categoría:");
              String resultado = bibliotecaService.buscarPorCategoria(cat);

              JOptionPane.showMessageDialog(this, resultado);
              break;
      
            case "Modificar libro":
              String codigoMod = JOptionPane.showInputDialog("Código del libro:");

              String nuevoTitulo = JOptionPane.showInputDialog("Nuevo título:");
              String nuevoAutor = JOptionPane.showInputDialog("Nuevo autor:");
              String nuevaCategoria = JOptionPane.showInputDialog("Nueva categoría:");

              bibliotecaService.modificarLibro(codigoMod, nuevoTitulo, nuevoAutor, nuevaCategoria);

              JOptionPane.showMessageDialog(this, "Libro modificado");
              break;
      
            case "Eliminar libro":
              String codigoEliminar = JOptionPane.showInputDialog("Código:");
          
              bibliotecaService.eliminarLibro(codigoEliminar);
          
              JOptionPane.showMessageDialog(this, "Libro eliminado");
              break;

            case "Registrar solicitud":
              String codEstudiante = JOptionPane.showInputDialog("Código estudiante:");
              String nombre = JOptionPane.showInputDialog("Nombre:");
              String codLibro = JOptionPane.showInputDialog("Código libro:");
          
              prestamoService.registrarSolicitud(codEstudiante, nombre, codLibro);
          
              JOptionPane.showMessageDialog(this, "Solicitud registrada");
              break;
      
            case "Mostrar cola":
              String cola = prestamoService.mostrarCola();
          
              JOptionPane.showMessageDialog(this, cola);
              break;
        }
  }
}
