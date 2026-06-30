package service;

import model.EstadoLibro;

public class ResporteService {

    private final BibliotecaService bibliotecaService;
    private final PrestamoService prestamoService;

    public ReporteService(BibliotecaService bibliotecaService, PrestamoService prestamoService) {
        this.bibliotecaService = bibliotecaService;
        this.prestamoService = prestamoService;
    }

    public String generarReporte() {
        return "REPORTE QUICKLIBRARY" + System.lineSeparator()
                + "Total de libros: " + bibliotecaService.contarTotal() + System.lineSeparator()
                + "Libros disponibles: " + bibliotecaService.contarPorEstado(EstadoLibro.DISPONIBLE) + System.lineSeparator()
                + "Libros prestados: " + bibliotecaService.contarPorEstado(EstadoLibro.PRESTADO) + System.lineSeparator()
                + "Solicitudes pendientes: " + prestamoService.contarPendientes();
    }
}
