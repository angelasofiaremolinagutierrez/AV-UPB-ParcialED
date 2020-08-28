package co.edu.upb.models;

import java.util.Calendar;

public class Vuelo {
    public int idAvion=0;
    public String ciudadSalida;
    public String ciudadLlegada;
    public Calendar horaSalida;
    public Calendar horaLlegada;
    public int puestosDisponibles; //133

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
                "ciudadSalida='" + ciudadSalida + '\'' +
                ", ciudadLlegada='" + ciudadLlegada + '\'' +
                ", horaSalida=" + horaSalida.getTime() +
                ", horaLlegada=" + horaLlegada.getTime() +
                ", puestos disponibles="+ puestosDisponibles;
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


}
