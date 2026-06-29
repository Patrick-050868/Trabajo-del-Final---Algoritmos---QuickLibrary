package model;
import java.time.localDate

public class SolicitudPrestamo {
  private String codigoestudiante;
  private String nombreestudiante;
  private String codigolibro;
  private String LocalDate fechasolicitud;

  public solicitudprestamo (String codigoestudiante,String nombreestudiante, String codigolibro)
  {
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
  public String getnombreestudiante()
  {
    return nombreestudiante;
  }
  public void setnombreestudiante()
  {
    this.nombreestudiante = nombre estudiante;
  }
  public String getcodigolibro()
  {
   return codigolibro; 
  }
  public void setcodigolibro(String nombreestudiante)
  {
    this.codigolibro = codigolibro;
  }
  public LocalDate getsolicitudprestamo()
  {
    return solicitudprestamo;
  }
  public void setsolicitudprestamo(LocalDate solicitudprestamo)
  {
    this.solicitudprestamo = solicitudprestamo;
  }
  @Override
  public String toString ()
  {
    return String.format("estudiante:[%s] %s ---- libro:%s ---- fecha:%s",codigoestudiante,nombreestudiante,codigoestudiante,codigolibro,fechasolicitud );
  }
}

