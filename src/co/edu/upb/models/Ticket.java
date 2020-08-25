package co.edu.upb.models;

import java.util.Date;

public class Ticket {
    public int idRegistro;
    public Vuelo vuelo;
    public Pasajero pas;
    public int puesto;
    public int carga; //en kilogramos.
    public String categoria;
    public int precio;

    public Ticket(Pasajero pas) {
        this.pas = pas;
    }

    public void comprar(Vuelo vuelo, Pasajero pas,  int puesto, int carga, String categoria) {
        //asignar un idRegistro

        this.vuelo = vuelo;
        this.pas = pas;
        this.puesto = puesto;
        // al comprar uno el vuelo se debe modificar el numero de puestosDisponibles.
        this.carga = carga;
        this.categoria = categoria;
        //asignar precio segun categoria
        //this.precio = precio;
    }

    public boolean checkIn(int idRegistro){
        //COMPROBAR LA HORA ACTUAL CON LA HORA DEL VUELO SI QUEDAN MAS DE 30 MINUTOS T, ELSE F
        return true;
    }



    //getters & setters

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Pasajero getPas() {
        return pas;
    }

    public void setPas(Pasajero pas) {
        this.pas = pas;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

}
