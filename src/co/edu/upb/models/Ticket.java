package co.edu.upb.models;

import java.util.Date;

public class Ticket {
    public int idRegistro = 0;
    public Vuelo vuelo;
    public Pasajero pas;
    public int puesto;
    public int carga; //en kilogramos.
    public int categoria;//"1. Premium\n2. Ejecutiva\n3.Economica"
    public int precio;

    public Ticket(Pasajero pas) {
        this.pas = pas;
        //asignar un idRegistro
    }

    public void comprar(Vuelo vuelo, Pasajero pas, int carga, int categoria) {
        this.idRegistro = 133 - (vuelo.getPuestosDisponibles() - 1);
        this.vuelo = vuelo;
        this.pas = pas;
        // al comprar un vuelo se debe asignar puesto segun lugares disponibles
        // y modificar el numero de puestosDisponibles
        this.vuelo.setPuestosDisponibles(vuelo.getPuestosDisponibles()-1);
        this.carga = carga;
        this.categoria = categoria;
        //asignar precio segun categoria
        if(categoria == 1){
            this.precio = 7000000;
        }else if(categoria == 2){
            this.precio = 300000;
        }else if(categoria == 3){
            this.precio = 120000;
        }
        System.out.println("A continuación le daremos la información de su tiquete de vuelo, guardela bien para el check-in");
        System.out.println("Su id de registro de ticket es el número: "+ this.idRegistro);
        System.out.println("Su vuelo es: " +this.vuelo.toString());
        System.out.println("Su silla es la número: "+((int)vuelo.getPuestosDisponibles()+1));
        System.out.println("Según la categoría escogida, el precio de su ticket es de: "+this.precio);
        System.out.println("El id del Avion es: " + this.getVuelo().idAvion);

        //agregar el vuelo a la lista de vuelos del pasajero
        this.pas.getVuelos().add(this.vuelo);

        //agregar el pasajero a la lista de pasajeros del vuelo
        this.vuelo.getTickets().add(this);
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

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
