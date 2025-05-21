package co.edu.uniquindio.poo.hospital.controller;

import co.edu.uniquindio.poo.hospital.model.Usuario;

public class LoginController {
    Usuario theUsuario;

    public LoginController(Usuario theUsuario) {
        this.theUsuario = theUsuario;
    }

    public Usuario getTheUsuario() {
        return theUsuario;
    }

    public void setTheUsuario(Usuario theUsuario) {
        this.theUsuario = theUsuario;
    }

}
