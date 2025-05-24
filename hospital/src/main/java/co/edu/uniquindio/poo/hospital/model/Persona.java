package co.edu.uniquindio.poo.hospital.model;

public class Persona {
    protected String id;
    protected String nombre;
    protected int edad;
    protected String telefono;
    protected String direccion;
    protected Usuario theUsuario;

    public Persona(String id, String nombre, int edad, String telefono,String direccion,Usuario theUsusario){
        this.id=id;
        this.nombre=nombre;
        this.edad=edad;
        this.telefono=telefono;
        this.direccion=direccion;
        this.theUsuario=theUsusario;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getTheUsuario() {
        return theUsuario;
    }

    public void setTheUsuario(Usuario theUsuario) {
        this.theUsuario = theUsuario;
    }
}
