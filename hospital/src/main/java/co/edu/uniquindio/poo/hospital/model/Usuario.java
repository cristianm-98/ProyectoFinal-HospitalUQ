package co.edu.uniquindio.poo.hospital.model;

public class Usuario {
    private String usuario;
    private String contraseña;
    private Persona thePersona;
    private TipoUsuario tipoUsuario;

    public Usuario(String usuario,String contraseña,Persona thePersona,TipoUsuario tipoUsuario){
        this.usuario=usuario;
        this.contraseña=contraseña;
        this.thePersona=thePersona;
        this.tipoUsuario=tipoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Persona getThePersona() {
        return thePersona;
    }

    public void setThePersona(Persona thePersona) {
        this.thePersona = thePersona;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
