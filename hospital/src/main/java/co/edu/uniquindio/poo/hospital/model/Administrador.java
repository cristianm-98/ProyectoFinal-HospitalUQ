package co.edu.uniquindio.poo.hospital.model;

public class Administrador extends Persona {
    private String cargo;
    private String areaResponsable;

    public Administrador(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario,String cargo,String areaResponsable){
        super(id,nombre,edad,telefono,direccion,theUsusario);
        this.cargo=cargo;
        this.areaResponsable=areaResponsable;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAreaResponsable() {
        return areaResponsable;
    }

    public void setAreaResponsable(String areaResponsable) {
        this.areaResponsable = areaResponsable;
    }
}
