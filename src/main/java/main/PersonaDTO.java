package main;

/**
 *
 * @author familia
 */
public class PersonaDTO {
    private int id_persona;
    private String pnombre;
    private String pDireccion;
    private Integer pNumTelefono;
    private String pImail;
    
    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_persona() {
        return id_persona;
    }
      
    public String getPnombre() {
        return pnombre.toUpperCase();
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    public String getpDireccion() {
        return pDireccion;
    }

    public void setpDireccion(String pDireccion) {
        this.pDireccion = pDireccion;
    }

    public Integer getpNumTelefono() {
        return pNumTelefono;
    }

    public void setpNumTelefono(Integer pNumTelefono) {
        this.pNumTelefono = pNumTelefono;
    }

    public String getpImail() {
        return pImail;
    }

    public void setpImail(String pImail) {
        this.pImail = pImail;
    }

    
    
}
    

