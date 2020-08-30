package co.edu.upb.models;

import co.edu.upb.list.DoubleList;

import java.util.Calendar;

public class Vuelo {
    public int idAvion=0;
    public String ciudadSalida;
    public String ciudadLlegada;
    public Calendar horaSalida;
    public Calendar horaLlegada;
    public int puestosDisponibles; //133
    public String estado = "Activo";

    public DoubleList tickets = new DoubleList();

    public Vuelo(String ciudadSalida, String ciudadLlegada, Calendar horaSalida, Calendar horaLlegada) {
        this.puestosDisponibles = 133;
        this.ciudadSalida = ciudadSalida;
        this.ciudadLlegada = ciudadLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        // asignar avion en la creacion del vuelo

    }

    public boolean checkearAvionesDisponibles(){
        if(idAvion > 10 || idAvion == -1){
            return false;
        }else{
            return true;
        }
    }
    @Override
    public String toString() {
        return
                "Salida='" + ciudadSalida + '\'' +
                ", Llegada='" + ciudadLlegada + '\'' +
                ", horaSalida=" + horaSalida.getTime() +
                ", horaLlegada=" + horaLlegada.getTime() +
                ", ID Avion=" + idAvion +
                ", Estado= " + estado;
    }

    //getters y setters

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getCiudadSalida() {
        return ciudadSalida;
    }

    public void setCiudadSalida(String ciudadSalida) {
        this.ciudadSalida = ciudadSalida;
    }

    public String getCiudadLlegada() {
        return ciudadLlegada;
    }

    public void setCiudadLlegada(String ciudadLlegada) {
        this.ciudadLlegada = ciudadLlegada;
    }

    public Calendar getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Calendar horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Calendar getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Calendar horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getPuestosDisponibles() {
        return puestosDisponibles;
    }

    public void setPuestosDisponibles(int puestosDisponibles) {
        this.puestosDisponibles = puestosDisponibles;
    }

    public DoubleList getTickets() {
        return tickets;
    }

    public void setTickets(DoubleList tickets) {
        this.tickets = tickets;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
