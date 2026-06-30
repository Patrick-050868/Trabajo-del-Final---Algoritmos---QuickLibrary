package menu;

import javax.swing.*;
import java.awt.*;

import service.BibliotecaService;
import service.PrestamoService;
import service.ReporteService;
import model.SolicitudPrestamo;
import utils.DatosIniciales;

public class MainMenuFrame extend JFrame {

  private BibliotecaService bibliotecaService;
  private PrestamoService prestamoService;
  private ReporteService reporteService;
  private final JTextArea outputArea;
  
  public MainMenuFrame() {
    bibliotecaService = new BibliotecaService();
    DatosIniciales.cargar(bibliotecaService);
    prestamoService = new PrestamoService(bibliotecaService);
    reporteService = new ReporteService(bibliotecaService, prestamoService);
    outputArea = new JTextArea();

    setTitle("QUICKLIBRARY");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(920, 620));
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(10, 10));

    add(crearEncabezado(), BorderLayout.NORTH);
    add(crearPanelOpciones(), BorderLayout.WEST);
    add(crearPanelResultados(), BorderLayout.CENTER);

    mostrarResultado(bibliotecaService.mostrarLibros());
    setVisible(true);
  }
  
  private JPanel crearEncabezado() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(12, 14, 4, 14));

        JLabel titulo = new JLabel("QUICKLIBRARY", SwingConstants.LEFT);
        titulo.setFont(titulo.getFont().deriveFont(22f));
        JLabel subtitulo = new JLabel("Sistema de gestion de prestamos de libros", SwingConstants.RIGHT);

        panel.add(titulo, BorderLayout.WEST);
        panel.add(subtitulo, BorderLayout.EAST);
        return panel;
    }
    private JScrollPane crearPanelOpciones() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 6, 6));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 14, 14, 4));

        agregarBoton(panel, "Registrar libro", this::registrarLibro);
        agregarBoton(panel, "Mostrar libros", () -> mostrarResultado(bibliotecaService.mostrarLibros()));
        agregarBoton(panel, "Libros disponibles", () -> mostrarResultado(bibliotecaService.mostrarDisponibles()));
        agregarBoton(panel, "Libros prestados", () -> mostrarResultado(bibliotecaService.mostrarPrestados()));
        agregarBoton(panel, "Buscar por codigo", this::buscarPorCodigo);
        agregarBoton(panel, "Buscar por titulo", this::buscarPorTitulo);
        agregarBoton(panel, "Buscar por autor", this::buscarPorAutor);
        agregarBoton(panel, "Buscar por categoria", this::buscarPorCategoria);
        agregarBoton(panel, "Modificar libro", this::modificarLibro);
        agregarBoton(panel, "Eliminar libro", this::eliminarLibro);
        agregarBoton(panel, "Registrar solicitud", this::registrarSolicitud);
        agregarBoton(panel, "Mostrar solicitudes", () -> mostrarResultado(prestamoService.mostrarCola()));
        agregarBoton(panel, "Siguiente solicitud", this::consultarSiguiente);
        agregarBoton(panel, "Atender solicitud", this::atenderSolicitud);
        agregarBoton(panel, "Registrar devolucion", this::registrarDevolucion);
        agregarBoton(panel, "Mostrar reporte", () -> mostrarResultado(reporteService.generarReporte()));
        agregarBoton(panel, "Salir", () -> dispose());

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(240, 0));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        return scroll;
    }

    private JScrollPane crearPanelResultados() {
        outputArea.setEditable(false);
        outputArea.setLineWrap(false);
        outputArea.setFont(outputArea.getFont().deriveFont(14f));
        outputArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultados"));
        return scroll;
    }

    private void agregarBoton(JPanel panel, String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(e -> accion.run());
        panel.add(boton);
    }

    private void registrarLibro() {
        Integer codigo = pedirEntero("Codigo del libro:");
        if (codigo == null) {
            return;
        }
        String titulo = pedirTexto("Titulo:");
        String autor = pedirTexto("Autor:");
        String categoria = pedirTexto("Categoria:");
        Integer anio = pedirEntero("Anio:");
        if (titulo == null || autor == null || categoria == null || anio == null) {
            return;
        }

        boolean registrado = bibliotecaService.registrarLibro(codigo, titulo, autor, categoria, anio);
        mostrarMensaje(registrado ? "Libro registrado." : "Ya existe un libro con ese codigo.");
        mostrarResultado(bibliotecaService.mostrarLibros());
    }

    private void buscarPorCodigo() {
        Integer codigo = pedirEntero("Codigo del libro:");
        if (codigo != null) {
            mostrarResultado(bibliotecaService.buscarPorCodigo(codigo));
        }
    }

    private void buscarPorTitulo() {
        String titulo = pedirTexto("Titulo o parte del titulo:");
        if (titulo != null) {
            mostrarResultado(bibliotecaService.buscarPorTitulo(titulo));
        }
    }

    private void buscarPorAutor() {
        String autor = pedirTexto("Autor o parte del autor:");
        if (autor != null) {
            mostrarResultado(bibliotecaService.buscarPorAutor(autor));
        }
    }
    private void buscarPorCategoria() {
        String categoria = pedirTexto("Categoria:");
        if (categoria != null) {
            mostrarResultado(bibliotecaService.buscarPorCategoria(categoria));
        }
    }

    private void modificarLibro() {
        Integer codigo = pedirEntero("Codigo del libro a modificar:");
        if (codigo == null) {
            return;
        }
        String titulo = pedirTexto("Nuevo titulo:");
        String autor = pedirTexto("Nuevo autor:");
        String categoria = pedirTexto("Nueva categoria:");
        Integer anio = pedirEntero("Nuevo anio:");
        if (titulo == null || autor == null || categoria == null || anio == null) {
            return;
        }

        boolean modificado = bibliotecaService.modificarLibro(codigo, titulo, autor, categoria, anio);
        mostrarMensaje(modificado ? "Libro modificado." : "Libro no encontrado.");
        mostrarResultado(bibliotecaService.mostrarLibros());
    }

    private void eliminarLibro() {
        Integer codigo = pedirEntero("Codigo del libro a eliminar:");
        if (codigo == null) {
            return;
        }
        boolean eliminado = bibliotecaService.eliminarLibro(codigo);
        mostrarMensaje(eliminado ? "Libro eliminado." : "Libro no encontrado.");
        mostrarResultado(bibliotecaService.mostrarLibros());
    }

    private void registrarSolicitud() {
        String codigoEstudiante = pedirTexto("Codigo del estudiante:");
        String nombreEstudiante = pedirTexto("Nombre del estudiante:");
        Integer codigoLibro = pedirEntero("Codigo del libro:");
        if (codigoEstudiante == null || nombreEstudiante == null || codigoLibro == null) {
            return;
        }

        boolean registrada = prestamoService.registrarSolicitud(codigoEstudiante, nombreEstudiante, codigoLibro);
        mostrarMensaje(registrada ? "Solicitud registrada." : "No se pudo registrar la solicitud.");
        mostrarResultado(prestamoService.mostrarCola());
    }

    private void consultarSiguiente() {
        SolicitudPrestamo solicitud = prestamoService.consultarSiguiente();
        mostrarResultado(solicitud == null ? "No hay solicitudes pendientes." : solicitud.toString());
    }

    private void atenderSolicitud() {
        mostrarResultado(prestamoService.atenderSiguiente());
    }

    private void registrarDevolucion() {
        Integer codigo = pedirEntero("Codigo del libro a devolver:");
        if (codigo == null) {
            return;
        }
        boolean devuelto = bibliotecaService.registrarDevolucion(codigo);
        mostrarMensaje(devuelto ? "Devolucion registrada." : "No se pudo registrar la devolucion.");
        mostrarResultado(bibliotecaService.buscarPorCodigo(codigo));
    }

    private String pedirTexto(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(this, mensaje);
            if (valor == null) {
                return null;
            }
            valor = valor.trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            mostrarMensaje("El campo no puede estar vacio.");
        }
    }

    private Integer pedirEntero(String mensaje) {
        while (true) {
            String valor = JOptionPane.showInputDialog(this, mensaje);
            if (valor == null) {
                return null;
            }
            try {
                return Integer.parseInt(valor.trim());
            } catch (NumberFormatException e) {
                mostrarMensaje("Ingrese un numero valido.");
            }
        }
    }

    private void mostrarResultado(String texto) {
        outputArea.setText(texto);
        outputArea.setCaretPosition(0);
    }

    private void mostrarMensaje(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }
}
