package menu;

import javax.swing.*;
import java.awt.*;

public class MainMenuFrame extend JFrame {
  public MainMenuFrame() {
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
        }
  }
}
