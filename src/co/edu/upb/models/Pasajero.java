package co.edu.upb.models;

import co.edu.upb.list.DoubleList;
import co.edu.upb.list.DoubleListNode;

public class Pasajero {
    public int idPasajero;
    public String nombre;
    public String apellido;
    public String tipoID;
    public String numeroID;
    public String direccion;
    public String telefono;

    public String nombreContactoSOS;
    public String apellidoContactoSOS;
    public String direccionContactoSOS;
    public String telefonoContactoSOS;

    public DoubleList vuelos = new DoubleList();

    public Pasajero() {

    }

    public Pasajero(String numeroID) {
        this.numeroID = numeroID;
    }

    public void registrarse(String nombre, String apellido, String tipoID, String numeroID, String direccion, String telefono, String nombreContactoSOS, String apellidoContactoSOS, String direccionContactoSOS, String telefonoContactoSOS) {
        //Asignar un id de pasajero y mostrar.
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoID = tipoID;
        this.numeroID = numeroID;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreContactoSOS = nombreContactoSOS;
        this.apellidoContactoSOS = apellidoContactoSOS;
        this.direccionContactoSOS = direccionContactoSOS;
        this.telefonoContactoSOS = telefonoContactoSOS;
    }

    @Override
    public String toString() {
        String listaVuelos = "{";
        DoubleListNode n = vuelos.head;
        for (int i = 0; i < vuelos.getSize(); i++) {
            listaVuelos +="Vuelo ";
            listaVuelos += (i+1);
            listaVuelos += ": " +n.getObject() +"\n";
            n = n.next;
        }
        listaVuelos += "}";
        return "Pasajero:\n" +
                "id pasajero=" + idPasajero +
                ", \nNombre='" + nombre + '\'' +
                ", \nApellido='" + apellido + '\'' +
                ", \nTipoID='" + tipoID + '\'' +
                ", \nNumeroID='" + numeroID + '\'' +
                ", \nDireccion='" + direccion + '\'' +
                ", \nTelefono='" + telefono + '\'' +
                ", \nNombreContactoSOS='" + nombreContactoSOS + '\'' +
                ", \nApellidoContactoSOS='" + apellidoContactoSOS + '\'' +
                ", \nDireccionContactoSOS='" + direccionContactoSOS + '\'' +
                ", \nTelefonoContactoSOS='" + telefonoContactoSOS + '\'' +
                ",\nLista vuelos: \n" + listaVuelos;
    }

    //getters & setters

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(String numeroID) {
        this.numeroID = numeroID;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContactoSOS() {
        return nombreContactoSOS;
    }

    public void setNombreContactoSOS(String nombreContactoSOS) {
        this.nombreContactoSOS = nombreContactoSOS;
    }

    public String getApellidoContactoSOS() {
        return apellidoContactoSOS;
    }

    public void setApellidoContactoSOS(String apellidoContactoSOS) {
        this.apellidoContactoSOS = apellidoContactoSOS;
    }

    public String getDireccionContactoSOS() {
        return direccionContactoSOS;
    }

    public void setDireccionContactoSOS(String direccionContactoSOS) {
        this.direccionContactoSOS = direccionContactoSOS;
    }

    public String getTelefonoContactoSOS() {
        return telefonoContactoSOS;
    }

    public void setTelefonoContactoSOS(String telefonoContactoSOS) {
        this.telefonoContactoSOS = telefonoContactoSOS;
    }

    public DoubleList getVuelos() {
        return vuelos;
    }

    public void setVuelos(DoubleList vuelos) {
        this.vuelos = vuelos;
    }
}
