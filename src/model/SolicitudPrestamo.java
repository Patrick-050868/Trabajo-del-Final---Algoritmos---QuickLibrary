package model;
import java.time.localDate

public class SolicitudPrestamo {
  private String codigoestudiante;
  private String nombreestudiante;
  private String codigolibro;
  private String LocalDate fechasolicitud;

  public solicitudprestamo (String codigoestudiante,String nombreestudiante, String codigolibro){
      this.codigoestudiante = codigoestudiante;
      this.nombreestudiante = nombreestudiante;
      this.codigolibro = codigolibro;
      this.fechasolicitud = LocalDate.now();
  }

  public String getcodigoestudiante(){
      return codigoestudiante;
  }

  public void setcodigoestudiante(){
      this.codigoestudiante = codigoestudiante;
  
  }
  public String getnombreestudiante(){
      return nombreestudiante;
  }
  public void setnombreestudiante(){
      this.nombreestudiante = nombre estudiante;
  }
  public String getcodigolibro(){
     return codigolibro; 
  }
  public void setcodigolibro(String nombreestudiante){
      this.codigolibro = codigolibro;
  }
  public LocalDate getsolicitudprestamo(){
      return solicitudprestamo;
  }
  public void setsolicitudprestamo(LocalDate solicitudprestamo){
      this.solicitudprestamo = solicitudprestamo;
  }
  // ══════════════════════════════════════════════════════════════════════════
  // RF03 – Solicitudes de préstamo
  // ══════════════════════════════════════════════════════════════════════════
  public void registrarSolicitud(SolicitudPerstamo solicitud){
      if (solicitud == null) thow new IllegalArgumentException("La solicitud no puede ser nula");
      colaSolicitudes.enqueue(solicitud);
  }
  public SolicitudPrestamo consultarSiguienteSolicitud(){
      colaSolicitudes.mostrar();
  }
  public SolicitudPerstamo consultarSiguienteSolicitud(){
      return colaSolicitudes.peek();
  }
  public int cantidadSolicitudesPendientes(){
      return colaSolicitudes.size();
  }
    // ══════════════════════════════════════════════════════════════════════════
    // RF04 – Préstamo de libros (atender solicitud)
    // ══════════════════════════════════════════════════════════════════════════
    public String atenderSiguienteSolicitud(){
        if(colaSolitudes.isEmpty()){
            return "No hay solicitudes pendientes en la calo";
        }
        SolicitudesPrestamo solicitud = colaSolicitudes.peek());
        Libro libro = buscarPorCodigo(solicitud.getCondigoLibro());
        if (libro == null){
            colaSolicitudes.dequeue();
            return "Solicitud rechazada: el libro con código '"
                    + solicitud.getCodigoLibro() + "' no existe en el catálogo. "
                    + "Solicitud eliminada de la cola.";
        }
        if (!libro.isDisponible()) {
            return "Solicitud en espera: el libro '" + libro.getTitulo()
                    + "' está actualmente prestado. La solicitud permanece en cola.";
        }
        libro.setDisponible(false);
        colaSolicitudes.dequeue();
        return String.format(
              "✔ Préstamo registrado exitosamente.%n" +
              "   Libro : [%s] %s%n" +
              "   Estudiante: %s – %s",
              libro.getCodigo(), libro.getTitulo(),
              solicitud.getCodigoEstudiante(), solicitud.getNombreEstudiante()
        );
    }
      // ══════════════════════════════════════════════════════════════════════════
      // RF05 – Devolución de libros
      // ══════════════════════════════════════════════════════════════════════════
        public String registrarDevolucion(String codigo){
            Libro libro = buscarPorCodigo(codigo);
            if(libro==null){
                return " error : no existe libro "+codigo+"."
            }
            if(libro.isDisponible()){
                return "avisos:el libro "+libro.getTitulo()+"ya esta marcado como disponible";
            }
            libro.setDisponible(true);
            return String.format(
                "✔ Devolución registrada. Libro [%s] '%s' ahora está disponible.",
                libro.getCodigo(), libro.getTitulo()
            );
        }
      // ══════════════════════════════════════════════════════════════════════════
      // RF06 – Reporte básico
      // ══════════════════════════════════════════════════════════════════════════
  
      public int totalLibros()        { return catalogo.contar(); }
      public int totalDisponibles()   { return obtenerLibrosDisponibles().size(); }
      public int totalPrestados()     { return obtenerLibrosPrestados().size();}
  @Override
  public String toString (){
      return String.format("estudiante:[%s] %s ---- libro:%s ---- fecha:%s",codigoestudiante,nombreestudiante,codigoestudiante,codigolibro,fechasolicitud );
  }
}

