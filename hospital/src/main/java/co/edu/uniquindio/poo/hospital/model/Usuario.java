package co.edu.uniquindio.poo.hospital.model;

public class Usuario {
    private String usuario;
    private String contrasena;
    private Persona thePersona;
    private TipoUsuario tipoUsuario;

    public Usuario(String usuario, String contrasena, Persona thePersona, TipoUsuario tipoUsuario) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.thePersona = thePersona;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String usuario, String contrasena, String thePersona) {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {

        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
