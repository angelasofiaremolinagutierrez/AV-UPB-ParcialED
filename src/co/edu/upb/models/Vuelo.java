package co.edu.upb.models;

import java.util.Date;

public class Vuelo {
    public String ciudadSalida;
    public String ciudadLlegada;
    public Date horaSalida;
    public Date horaLlegada;
    public int idAvion;

    public int puestosDisponibles;

    public Vuelo(String ciudadSalida, String ciudadLlegada, Date horaSalida, Date horaLlegada) {
        this.ciudadSalida = ciudadSalida;
        this.ciudadLlegada = ciudadLlegada;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "ciudadSalida='" + ciudadSalida + '\'' +
                ", ciudadLlegada='" + ciudadLlegada + '\'' +
                ", horaSalida=" + horaSalida +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
