package co.edu.uniquindio.poo.hospital.model;

import co.edu.uniquindio.poo.hospital.App;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
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
        return this.listaPersonas;
    }

    public void setListaPersonas(LinkedList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public LinkedList<Paciente> getListaPacientes() {
        return this.listaPacientes;
    }

    public void setListaPacientes(LinkedList<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public LinkedList<Medico> getListaMedicos() {
        return this.listaMedicos;
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

    /// Paciente CRUD

    public boolean agregarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
        return true;
    }

    public boolean eliminarPaciente(Paciente paciente) {
        String id = paciente.getId();
        for (Paciente paciente_local : this.listaPacientes) {
            if (paciente_local.getId().equals(id)) {
                this.listaPacientes.remove(paciente_local);
                return true;
            }
        }
        return false;
    }

    public boolean modificarPaciente(Paciente paciente) {
        String id = paciente.getId();
        for (Paciente paciente_local : this.listaPacientes) {
            if (paciente_local.getId().equals(id)) {
                this.listaPacientes.remove(paciente_local);
                this.listaPacientes.add(paciente);
                return true;
            }
        }
        return false;
    }

    public Paciente consultarPaciente(String id) {
        for (Paciente paciente_local : this.listaPacientes) {
            if (paciente_local.getId().equals(id)) {
                return paciente_local;
            }
        }
        return null;
    }

    /// Medico CRUD

    public boolean agregarMedico(Medico medico) {
        this.listaMedicos.add(medico);
        return true;
    }

    public boolean eliminarMedico(Medico medico) {
        String id = medico.getId();
        for (Medico medico_local : this.listaMedicos) {
            if (medico_local.getId().equals(id)) {
                this.listaMedicos.remove(medico_local);
                return true;
            }
        }
        return false;
    }

    public boolean modificarMedico(Medico medico) {
        String id = medico.getId();
        for (Medico medico_local : this.listaMedicos) {
            if (medico_local.getId().equals(id)) {
                this.listaMedicos.remove(medico_local);
                this.listaMedicos.add(medico);
                return true;
            }
        }
        return false;
    }

    public Medico consultarMedico(String id) {
        for (Medico medico_local : this.listaMedicos) {
            if (medico_local.getId().equals(id)) {
                return medico_local;
            }
        }
        return null;
    }

    /// Administrador CRUD


    public boolean agregarAdministrador(Administrador administrador) {
        this.listaAdministradores.add(administrador);
        return true;
    }

    public boolean eliminarAdministrador(Administrador administrador) {
        String id = administrador.getId();
        for (Administrador administrador_local : this.listaAdministradores) {
            if (administrador_local.getId().equals(id)) {
                this.listaAdministradores.remove(administrador_local);
                return true;
            }
        }
        return false;
    }

    public boolean modificarAdministrador(Administrador administrador) {
        String id = administrador.getId();
        for (Administrador administrador_local : this.listaAdministradores) {
            if (administrador_local.getId().equals(id)) {
                this.listaAdministradores.remove(administrador_local);
                this.listaAdministradores.add(administrador);
                return true;
            }
        }
        return false;
    }

    public Administrador consultarAdministrador(String id) {
        for (Administrador administrador_local : this.listaAdministradores) {
            if (administrador_local.getId().equals(id)) {
                return administrador_local;
            }
        }
        return null;
    }

    /// Consultorio Medico CRUD

    public boolean agregarConsultorio(ConsultorioMedico consultorioMedico) {
        this.listaConsultorioMedicos.add(consultorioMedico);
        return true;
    }

    public boolean eliminarConsultorio(ConsultorioMedico consultorioMedico) {
        String id = consultorioMedico.getId();
        for (ConsultorioMedico consultorio_local : this.listaConsultorioMedicos) {
            if (consultorio_local.getId().equals(id)) {
                this.listaConsultorioMedicos.remove(consultorio_local);
                return true;
            }
        }
        return false;
    }

    public boolean modificarConsultorio(ConsultorioMedico consultorioMedico) {
        String id = consultorioMedico.getId();
        for (ConsultorioMedico consultorio_local : this.listaConsultorioMedicos) {
            if (consultorio_local.getId().equals(id)) {
                this.listaConsultorioMedicos.remove(consultorio_local);
                this.listaConsultorioMedicos.add(consultorioMedico);
                return true;
            }
        }
        return false;
    }

    public ConsultorioMedico consultarConsultorio(String id) {
        for (ConsultorioMedico consultorio_local : this.listaConsultorioMedicos) {
            if (consultorio_local.getId().equals(id)) {
                return consultorio_local;
            }
        }
        return null;
    }

    //Metodo para obtener todas las citas
    public LinkedList<Cita> obtenerTodasLasCitas() {
        LinkedList<Cita> totasLasCitas = new LinkedList<>();
        for (ConsultorioMedico consultorioMedico : listaConsultorioMedicos) {
            Iterator<Cita> iterator = consultorioMedico.getListaCitas().iterator();
            while (iterator.hasNext()) {
                Cita cita = iterator.next();
                totasLasCitas.add(cita);
            }
        }
        return totasLasCitas;
    }
}
