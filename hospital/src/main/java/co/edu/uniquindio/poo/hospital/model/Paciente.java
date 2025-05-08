package co.edu.uniquindio.poo.hospital.model;

public class Paciente extends Persona{
    private String tipoSangre;

    public Paciente(String id, String nombre, int edad, String telefono,String direccion,String tipoSangre){
        super(id,nombre,edad,telefono,direccion);
        this.tipoSangre=tipoSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
