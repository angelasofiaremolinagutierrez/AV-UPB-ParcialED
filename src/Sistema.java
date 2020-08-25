import co.edu.upb.list.DoubleList;
import co.edu.upb.models.Metodos;
import co.edu.upb.models.Pasajero;

import java.util.Scanner;

public class Sistema implements Metodos{

    DoubleList vuelos = new DoubleList();
    DoubleList pasajeros = new DoubleList();


    public static void main(String[] args) {
        System.out.println("Bienvenido a la aerolinea AV-UPB!");
        System.out.println("¿quién ingresa al sistema?\n1.Pasajero\n2.Agente de abordaje");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        switch (user){
            case "1":{ //Sistema del pasajero
                System.out.println("¿Qué desea hacer?\n1. Comprar un tiquete.\n2. Realizar su check-in.");
                String accion = scan.nextLine();
                switch (accion){
                    case "1":{ //comprar tiquete
                        //mostrar vuelos disponibles
                        //preguntar si ya está registrado (preguntar cedula y buscar)
                        //si no está registrado, primero:
                        //todo llamar a un metodo registrar con la cedula que ingresó.
                        //si ya lo está:
                        //todo llamar a un metodo comprar
                        //NOTA: ESTOS METODOS ESTÁN DENTRO DE LA CLASE PASAJERO y TICKET RESPECTIVAMENTE
                        break;
                    }
                    case "2":{ //check-in
                        //todo llamar a un metodo check-in
                        //NOTA: ESTOS METODOS LOS PUEDES PONER DENTRO DE LA CLASE TICKET
                        break;
                    }
                }
                break;
            }
            case "2":{ //Sistema del agente de abordaje
                //preguntar que quiere ver y dependiendo de eso
                //Consultarpasajeros
                //mostrarVuelos
                break;
            }
        }
    }

    @Override
    public String mostrarVuelos() {
        return null;
    }

    @Override
    public Pasajero consultarPasajero() {
        return null;
    }
}
