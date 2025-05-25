package co.edu.uniquindio.poo.hospital.model;

import co.edu.uniquindio.poo.hospital.model.Interfaces.ICitaCRUD;

import java.util.LinkedList;

public class ConsultorioMedico implements ICitaCRUD {
    private String id;
    private String nombre;
    private boolean disponible;
    private byte numeroSala;
    private LinkedList<Cita>listaCitas;

    public ConsultorioMedico(String id, String nombre,boolean disponible, byte numeroSala){
        this.id=id;
        this.nombre=nombre;
        this.disponible=disponible;
        this.numeroSala=numeroSala;
        listaCitas=new LinkedList<>();
    }

    public ConsultorioMedico(String number) {
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public byte getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(byte numeroSala) {
        this.numeroSala = numeroSala;
    }

    public LinkedList<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(LinkedList<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    /// Cita CRUD
    @Override
    public boolean agregarCita(Cita cita) {
        this.listaCitas.add(cita);
        return true;
    }
    @Override
    public boolean eliminarCita(Cita cita) {
        String id = cita.getId();
        for (Cita cita_local : this.listaCitas){
            if (cita_local.getId().equals(id)){
                this.listaCitas.remove(cita_local);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean modificarCita(Cita cita) {
        String id = cita.getId();
        for (Cita cita_local : this.listaCitas){
            if (cita_local.getId().equals(id)){
                this.listaCitas.remove(cita_local);
                this.listaCitas.add(cita);
                return true;
            }
        }
        return false;
    }

    @Override
    public Cita consultarCita(String id) {
        for (Cita cita_local: this.listaCitas){
            if (cita_local.getId().equals(id)){
                return cita_local;
            }
        }
        return null;
    }
}
