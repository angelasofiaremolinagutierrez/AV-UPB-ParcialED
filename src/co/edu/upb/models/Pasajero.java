package co.edu.upb.models;

public class Pasajero {
    public int idPasajero;
    public String nombre;
    public String apellido;
    public String tipoID;
    public int numeroID;
    public String direccion;
    public String telefono;

    public String nombreContactoSOS;
    public String apellidoContactoSOS;
    public String direccionContactoSOS;
    public String telefonoContactoSOS;

    public Pasajero() {

    }

    public Pasajero(int numeroID) {
        this.numeroID = numeroID;
    }

    public void registrarse(String nombre, String apellido, String tipoID, int numeroID, String direccion, String telefono, String nombreContactoSOS, String apellidoContactoSOS, String direccionContactoSOS, String telefonoContactoSOS) {
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

    public int getNumeroID() {
        return numeroID;
    }

    public void setNumeroID(int numeroID) {
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
}
