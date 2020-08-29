import co.edu.upb.models.Pasajero;
import co.edu.upb.models.Ticket;
import co.edu.upb.models.Vuelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Pasajero pas1 = new Pasajero("1193560933");
        pas1.registrarse("Angela","Remolina","CC", pas1.numeroID, "Cra.15","3188334099","Maria","Remolina","Calle 12","3188334095");

        Vuelo v1 = new Vuelo("Bucaramanga","Cucuta",new GregorianCalendar(2020, Calendar.AUGUST, 31, 23, 11, 44) ,new GregorianCalendar(2020, Calendar.SEPTEMBER, 1, 0, 0, 0));
        Vuelo v2 = new Vuelo("Bucaramanga","Bogotá",new GregorianCalendar(2020, Calendar.AUGUST, 27, 23, 39, 44) ,new GregorianCalendar(2020, Calendar.AUGUST, 24, 23, 59, 59));

        Ticket t = new Ticket(pas1);
        t.comprar(v1,pas1,22,2);

        Ticket t2 = new Ticket(pas1);
        t.comprar(v2,pas1,88,3);
        System.out.println(pas1.toString());
    }
}
