package co.edu.uniquindio.poo.hospital.model;

import co.edu.uniquindio.poo.hospital.App;

import java.util.LinkedList;

public class Hospital {
    private String nit;
    private String nombre;
    private LinkedList<Persona> listaPersonas;
    private LinkedList<Paciente> listaPacientes;
    private LinkedList<Medico> listaMedicos;
    private LinkedList<Administrador> listaAdministradores;
    private LinkedList<ConsultorioMedico> listaConsultorioMedicos;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public Hospital(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        listaPersonas = new LinkedList<>();
        listaPacientes = new LinkedList<>();
        listaMedicos = new LinkedList<>();
        listaAdministradores = new LinkedList<>();
        listaConsultorioMedicos = new LinkedList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(LinkedList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public LinkedList<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(LinkedList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public LinkedList<Medico> getListaMedicos() {
        return listaMedicos;
    }

    public void setListaMedicos(LinkedList<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    public LinkedList<Administrador> getListaAdministradores() {
        return listaAdministradores;
    }

    public void setListaAdministradores(LinkedList<Administrador> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }

    public LinkedList<ConsultorioMedico> getListaConsultorioMedicos() {
        return listaConsultorioMedicos;
    }

    public void setListaConsultorioMedicos(LinkedList<ConsultorioMedico> listaConsultorioMedicos) {
        this.listaConsultorioMedicos = listaConsultorioMedicos;
    }

    public Usuario buscarUsuario(String nombreUsuario) {
        for (Persona persona : listaPersonas) {
            if (persona.getTheUsuario().getUsuario().equals(nombreUsuario)) {
                return persona.getTheUsuario();
            }
        }
        return null;
    }

    //Crud
    public boolean verificarPersona(String id) {
        boolean centinela = false;
        for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                centinela = true;
            }
        }
        return centinela;
    }

    public boolean agregarPersona(Persona persona) {
        boolean centinela = false;
        if (!verificarPersona(persona.getId())) {
            listaPersonas.add(persona);
            centinela = true;
        }
        return centinela;
    }
    public boolean eliminarPaciente(String id){
        return listaPacientes.removeIf(paciente -> paciente.getId().equals(id));
    }
    

    public boolean actualizarPaciente(String id, Paciente actualizado) {
        boolean centinela = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getId().equals(id)) {
                paciente.setId(actualizado.getId());
                paciente.setNombre(actualizado.getNombre());
                paciente.setEdad(actualizado.getEdad());
                paciente.setTelefono(actualizado.getTelefono());
                paciente.setDireccion(actualizado.getDireccion());
                paciente.setTipoSangre(actualizado.getTipoSangre());
                centinela = true;
                break;
            }
        }
        return centinela;
    }
}

