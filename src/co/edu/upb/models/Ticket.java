package co.edu.upb.models;

import java.util.Date;

public class Ticket {
    public int idRegistro;
    public Vuelo vuelo;
    public Pasajero pas;
    public int puesto;
    public int carga; //en kilogramos.
    public int categoria;//"1. Premium\n2. Ejecutiva\n3.Economica"
    public int precio;

    public Ticket(Pasajero pas) {
        this.pas = pas;
    }

    public void comprar(Vuelo vuelo, Pasajero pas, int carga, int categoria) {
        //asignar un idRegistro

        this.vuelo = vuelo;
        this.pas = pas;
        this.puesto = puesto;
        // al comprar uno el vuelo se debe modificar el numero de puestosDisponibles.
        this.carga = carga;
        this.categoria = categoria;
        //asignar puesto segun lugares disponibles
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

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

}
